package com.hzc.service;

import com.hzc.factory.alias.D;
import com.hzc.framework.ssh.service.TrancationType;
import com.hzc.framework.ssh.service.Transaction;
import com.hzc.model.SysConfig;

/**
 * 系统配置类
 * 说明：
 * 加载考试系统配置的相关信息
 * Created by HZC on 2015/5/26.
 */
@Transaction(jdbc = TrancationType.CLOSE)
public class SysConfigService {

    /**
     * 获取考试系统的相关配置信息
     *
     * @return SysConfig
     */
    public SysConfig get() {
        return D.sysConfigMapper().select();
    }
}
