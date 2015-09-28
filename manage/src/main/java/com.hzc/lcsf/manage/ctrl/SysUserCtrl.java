package com.hzc.lcsf.manage.ctrl;

import com.hzc.lcsf.manage.util.alias.W;
import com.hzc.util.alias.S;
import com.hzc.vo.SysUserVO;

import java.util.List;

/**
 * 用户管理相关方法
 * Created by HZC on 2015/6/17.
 */
public class SysUserCtrl {

    /**
     * 登录
     */
    public void login() {
        W.forward("/WEB-INF/pages/main.jsp");
    }

    /**
     * 返回用户管理列表
     */
    public void ajaxUserManage() {
        SysUserVO sysUserVO = W.packBean(SysUserVO.class);
        List<SysUserVO> list = S.sysUserService().getUserManageList(sysUserVO);
        W.writeJsonArray(list);
    }

}
