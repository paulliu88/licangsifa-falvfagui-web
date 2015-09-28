package com.hzc.dao;

import com.hzc.model.HisPaperItem;

public interface HisPaperItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisPaperItem record);

    int insertSelective(HisPaperItem record);

    HisPaperItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisPaperItem record);

    int updateByPrimaryKey(HisPaperItem record);
}