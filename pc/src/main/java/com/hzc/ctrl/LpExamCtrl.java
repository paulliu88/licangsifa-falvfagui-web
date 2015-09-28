package com.hzc.ctrl;

import com.hzc.util.HttpSessionUtil;
import com.hzc.util.alias.S;
import com.hzc.util.alias.W;
import com.hzc.vo.AnswerCardVO;
import com.hzc.vo.QuestionVO;

import java.util.List;

/**
 * Created by yinbin on 2015/5/27.
 * 用于考试模块
 */
public class LpExamCtrl {

    /**
     * 查询所的用于考试的题号
     */
    public void getCardQuestionListForTest() {
        int userId = HttpSessionUtil.getUserId();
        List<AnswerCardVO> anserCardList = S.examService().loadCardList(userId);
        W.writeJsonArray(anserCardList);
    }

    /**
     * FIXME    重复了，在LpQuestionCtrl 类中已经存在一个方法： getQuestionDetail
     * 根据题号，查询这道题的所有信息
     */
    public void getQuestionDetail() {
        Integer questionId = W.getInteger("questionId");
        QuestionVO question = S.examService().loadQuestionDetail(questionId, HttpSessionUtil.getUserId());
        W.writeJsonObject(question);
    }

    /**
     * 保存错题
     */
    public void saveErrors() {
        String hisPaperStr = W.getString("hisPaperStr");
        String hisPaperItemsStr = W.getString("hisPaperItemsStr");
        int userId = HttpSessionUtil.getUserId();
        Integer cardId = HttpSessionUtil.getCardId();
        S.examService().saveUserAnswer(hisPaperStr, hisPaperItemsStr, userId, cardId);
        W.writeJson(true, "");
    }

}
