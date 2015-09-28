package com.hzc.dao;

import com.hzc.model.LpOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LpOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LpOption record);

    int insertSelective(LpOption record);

    LpOption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LpOption record);

    int updateByPrimaryKey(LpOption record);

    List<LpOption> selectByQuestionId(@Param("questionId") int questionId);
}