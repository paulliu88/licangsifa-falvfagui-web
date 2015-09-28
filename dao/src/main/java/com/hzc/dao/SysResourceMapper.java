package com.hzc.dao;

import com.hzc.model.SysResource;

import java.util.List;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    /**
     * 查询系统资源
     *
     * @return List<SysResource>
     */
    List<SysResource> selectResources();
}