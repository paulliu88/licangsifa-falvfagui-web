package com.hzc.dao;

import com.hzc.model.SysConfig;

public interface SysConfigMapper {
    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    /**
     * 查询系统设置
     * 说明：
     *     包括考试开始时间，考试结束时间，报名开始时间，报名结束时间
     *     打印准考证开始时间，打印准考证结束时间
     * @return
     */
    SysConfig select();
}