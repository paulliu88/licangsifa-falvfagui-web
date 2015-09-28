package com.hzc.service;

import com.hzc.factory.alias.D;
import com.hzc.framework.ssh.service.TrancationType;
import com.hzc.framework.ssh.service.Transaction;
import com.hzc.model.SysCompany;

import java.util.List;

/**
 * 李沧干部法律法规学习考试系统学员单位类
 * Created by HZC on 2015/5/26.
 */
@Transaction(jdbc = TrancationType.CLOSE)
public class SysCompanyService {

    /**
     * 查询单位
     * 说明：
     * 根据companyId获取单位
     *
     * @param id companyId
     * @return SysCompany
     */
    public SysCompany getCompanyById(Integer id) {
        return D.sysCompanyMapper().selectByPrimaryKey(id);
    }

    /**
     * 返回所有单位
     * <pre>
     *     说明：
     *     查询所有非其他类的单位
     * </pre>
     *
     * @return
     */
    public List<SysCompany> listStandardCompanies() {
        return D.sysCompanyMapper().selectStandardCompanies();
    }

    /**
     * 返回所有其他类的单位
     *
     * @return
     */
    public List<SysCompany> listOtherCompanies() {
        return D.sysCompanyMapper().selectOtherCompanies();
    }

    /**
     * 返回新添加单位的id
     * <pre>
     *    用户手动添加自己的单位（其他类）
     *    参数设置
     *    SysCompany company = new SysCompany();
     *    company.setDeleted(1);
     *    company.setName(companyName);
     *    company.setPassword("123456");
     *    company.setPid(8);
     * </pre>
     *
     * @param company
     */
    @Transaction(jdbc = TrancationType.OPEN)
    public Integer addSelfCompany(SysCompany company) {
        D.sysCompanyMapper().insertSelfCompany(company);
        return company.getId();
    }
}
