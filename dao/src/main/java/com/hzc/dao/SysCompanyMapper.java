package com.hzc.dao;

import com.hzc.model.SysCompany;

import java.util.List;

public interface SysCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysCompany record);

    int insertSelective(SysCompany record);

    SysCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysCompany record);

    int updateByPrimaryKey(SysCompany record);

    /**
     * 返回所有非其他类的单位
     *
     * @return
     */
    List<SysCompany> selectStandardCompanies();

    /**
     * 返回所有其他类的单位
     *
     * @return
     */
    List<SysCompany> selectOtherCompanies();

    /**
     * 返回新添加的单位的id
     * <pre>
     *     用户手动添加自己的单位部门（属于其他类）
     * </pre>
     *
     * @param company
     * @return
     */
    Integer insertSelfCompany(SysCompany company);
}