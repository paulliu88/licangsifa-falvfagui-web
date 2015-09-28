package com.hzc.dao;

import com.hzc.model.HisPaper;

public interface HisPaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisPaper record);

    int insertSelective(HisPaper record);

    HisPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisPaper record);

    int updateByPrimaryKey(HisPaper record);
}