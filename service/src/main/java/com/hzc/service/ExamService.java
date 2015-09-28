package com.hzc.service;

import com.hzc.factory.alias.D;
import com.hzc.framework.ssh.controller.WebUtil;
import com.hzc.framework.ssh.service.TrancationType;
import com.hzc.framework.ssh.service.Transaction;
import com.hzc.model.*;
import com.hzc.vo.AnswerCardVO;
import com.hzc.vo.QuestionVO;
import com.hzc.vo.UserAnswerVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by yinbin on 2015/5/28.
 * 在线考试模块的业务逻辑
 */
@Transaction(jdbc = TrancationType.CLOSE)
public class ExamService {

    /**
     * 根据userId
     * 获取模拟页答题卡内容
     * 包括：questionId，答题次数，错误次数，试题类型，是否收藏
     *
     * @param userId
     * @return
     */
    public List<AnswerCardVO> loadCardList(int userId) {
        //    模拟题中答题卡数据的缓存
        List<AnswerCardVO> test_panduan_card = new ArrayList<AnswerCardVO>();
        List<AnswerCardVO> test_danxuan_card = new ArrayList<AnswerCardVO>();
        List<AnswerCardVO> test_duoxuan_card = new ArrayList<AnswerCardVO>();

        List<AnswerCardVO> acvList = D.lpQuestionMapper().selectForAnswerCardList(userId);
        for (AnswerCardVO vo : acvList) {
            if ("判断题".equals(vo.getType())) {
                test_panduan_card.add(vo);
            } else if ("单选题".equals(vo.getType())) {
                test_danxuan_card.add(vo);
            } else if ("多选题".equals(vo.getType())) {
                test_duoxuan_card.add(vo);
            }
        }

        Collections.shuffle(test_panduan_card);
        Collections.shuffle(test_danxuan_card);
        Collections.shuffle(test_duoxuan_card);

        List<AnswerCardVO> acVos = new ArrayList<AnswerCardVO>();
        acVos.addAll(test_panduan_card.subList(0, 30));
        acVos.addAll(test_danxuan_card.subList(0, 30));
        acVos.addAll(test_duoxuan_card.subList(0, 20));

        return acVos;
    }

    /**
     * 根据questionId查询用户的试题
     * 包括：questionId，答题次数，错误次数，试题类型，试题信息
     *
     * @param questionId
     * @param userId
     * @return
     */
    public QuestionVO loadQuestionDetail(int questionId, int userId) {
        QuestionVO questionVO = D.lpQuestionMapper().selectByPrimaryKeyForUser(questionId, userId);
        List<LpOption> lpOptions = D.lpOptionMapper().selectByQuestionId(questionId);
        String[] labels = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
        int i = 0;
        for (LpOption lpOption : lpOptions) {
            lpOption.setLabel(labels[i]);
            i++;
        }
        List<LpOption> options = lpOptions;
        questionVO.setOptions(options);
        return questionVO;
    }

    /**
     * 保存用户错题
     *
     * @param hisPaperStr
     * @param hisPaperItemStr {name:"",seq:"",category_code:"",type:"",option_a:"",option_b:"",option_c:"",option_d:"",key:1,answer:"",answer_time:38}
     * @param userId
     */
    public void saveUserAnswer(String hisPaperStr, String hisPaperItemStr, int userId, Integer cardId) {

//        添加与用户之间的关联
        HisPaper hisPaper = WebUtil.jsonConvertJavaObject(HisPaper.class, hisPaperStr);
        hisPaper.setDeleted(1);
        hisPaper.setUserId(userId);
        hisPaper.setCardId(cardId);
        hisPaper.setUpdateTime(new Date());
        hisPaper.setCreateTime(new Date());
        D.hisPaperMapper().insert(hisPaper);

        Integer paperId = hisPaper.getId(); // 下面保存每道题的回答结果用
        System.out.println(paperId);

        HisPaperItem[] hisPaperItems = (HisPaperItem[]) WebUtil.jsonConvertJavaArray(HisPaperItem.class, hisPaperItemStr);
        System.out.println(hisPaperItems.length);

        for (HisPaperItem hisPaperItem : hisPaperItems) {

//            TODO 下面这些代码可以使用一个简单的update sql搞定。
            Integer questionId = hisPaperItem.getSeq();
            System.out.println(questionId);
            QuestionVO questionVO = loadQuestionDetail(questionId, userId);

            hisPaperItem.setName(questionVO.getName());
            hisPaperItem.setCategoryCode("" + questionVO.getCategoryCode());
            hisPaperItem.setType(questionVO.getType());
            List<LpOption> options = questionVO.getOptions();
            if (options.size() > 0) {
                LpOption lpOption = options.get(0);
                hisPaperItem.setOptionA(lpOption.getName());
                if (lpOption.getKey() == 1) {
                    hisPaperItem.setKey("A");
                }
            }
            if (options.size() > 1) {
                LpOption lpOption = options.get(1);
                hisPaperItem.setOptionB(lpOption.getName());
                if (lpOption.getKey() == 1) {
                    hisPaperItem.setKey("B");
                }
            }
            if (options.size() > 2) {
                LpOption lpOption = options.get(2);
                hisPaperItem.setOptionC(lpOption.getName());
                if (lpOption.getKey() == 1) {
                    hisPaperItem.setKey("C");
                }
            }
            if (options.size() > 3) {
                LpOption lpOption = options.get(3);
                hisPaperItem.setOptionD(lpOption.getName());
                if (lpOption.getKey() == 1) {
                    hisPaperItem.setKey("D");
                }
            }
            hisPaperItem.setUpdateTime(new Date());
            hisPaperItem.setCreateTime(new Date());
            hisPaperItem.setDeleted(1);
            hisPaperItem.setPaperId(paperId);

            D.hisPaperItemMapper().insert(hisPaperItem);
        }

    }


}
