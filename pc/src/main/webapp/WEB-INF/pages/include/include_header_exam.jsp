<%--
  Created by IntelliJ IDEA.
  User: yinbin
  Date: 2015/5/2
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="../common_jstl.jsp" %>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <title>李沧区干部普法学习测试系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="bookmark" type="image/x-icon" href="${basePath}assets/system/pufa/img/logo.ico"/>
    <link rel="shortcut icon" href="${basePath}assets/system/pufa/img/logo.ico"/>
    <link rel="icon" href="${basePath}assets/system/pufa/img/logo.ico"/>

    <!-- basic styles -->

    <link href="${basePath}assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}assets/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="${basePath}assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->

    <link rel="stylesheet" href="${basePath}assets/css/jquery-ui-1.10.3.custom.min.css"/>
    <link rel="stylesheet" href="${basePath}assets/css/jquery.gritter.css"/>

    <!-- fonts -->

    <!--<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />-->

    <!-- ace styles -->

    <link rel="stylesheet" href="${basePath}assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${basePath}assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${basePath}assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${basePath}assets/css/ace-ie.min.css"/>
    <![endif]-->

    <%-- 新手引导效果库 --%>
    <link rel="stylesheet" href="${basePath}assets/js/joyride/joyride-2.1.css">

    <!-- inline styles related to this page -->

    <!--        OWN CSS              -->
    <link rel="stylesheet" href="${basePath}assets/system/pufa/css/header-main.css">

    <!-- ace settings handler -->

    <!--
      判断IE浏览器版本小于IE8，则直接提示更新。
    -->
    <!--[if lte IE 7]>
    <script>window.location.href = 'http://cdn.dmeng.net/upgrade-your-browser.html?referrer=' + location.href;</script>
    <![endif]-->

    <script src="${basePath}assets/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="${basePath}assets/js/html5shiv.js"></script>
    <script src="${basePath}assets/js/respond.min.js"></script>
    <![endif]-->

</head>

<body style="min-width: 1100px;background-color: #ffffff;" class="container">
<div class="row">
    <div class="col-xs-1 col-sm-1"></div>
    <div class="col-xs-10 col-sm-10">

        <div class="navbar navbar-default" id="navbar" style="height: 150px;">
            <script type="text/javascript">
                try {
                    ace.settings.check('navbar', 'fixed')
                } catch (e) {
                }
            </script>

            <div class="navbar-container" id="navbar-container"
                 style="height: 160px; background: none repeat scroll 0px 0px #1687D5">
                <div class="logo" style='background-image: url("${basePath}assets/system/pufa/img/biaozi.png");'></div>

                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand" style="cursor: default;height: 80px;">
                        <small style="font-size: 40px;font-family: 微软雅黑;font-weight: 200;line-height:120px;letter-spacing:0.2em;">
                            李沧区干部法律法规考试系统
                        </small>
                    </a><!-- /.brand -->
                    <div class="" style="margin-top:120px;margin-left: 8px;color: #f5f5f5;">
                        当前登录用户：${sessionScope.username}
                    </div>
                </div>
                <!-- /.navbar-header -->

                <div class="navbar-header pull-right my-menu" role="navigation" id="yd-menu-id">
                    <ul class="nav ace-nav my-ace-nav" style="top: 80px; display:none;">

                        <li id="my-all-study-menu" style="min-width: 50px;" data-is-modal="study-bank" class="dropdown-toggle btn-group">

                            <a href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/study-main.jsp" title="点击打开学习题库"
                               class="btn dropdown-toggle my-btn-default" style="width:116px;font-size: 18px;border-width: 0px;" >
                                <img src="assets/system/pufa/img/menu/lx.png" class="my-menu-item">
                                学习题库
                            </a>

                            <button title="鼠标经过自动打开下拉菜单" class="btn  dropdown-toggle my-btn-default" data-toggle="dropdown" style="height:100%;border-width: 0px;width: 18px !important;">
                                <span class="icon-caret-down icon-only "></span>
                            </button>

                            <ul class="dropdown-menu dropdown-warning my-dropdown-menu" style="text-align: center;">
                                <li>
                                    <a href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/all.jsp" class="dropdown-toggle my-dropdown-toggle">总题库</a>
                                </li>

                                <li>
                                    <a href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/panduanti.jsp" class="dropdown-toggle my-dropdown-toggle">判断题</a>
                                </li>

                                <li>
                                    <a href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/danxuanti.jsp" class="dropdown-toggle my-dropdown-toggle">单选题</a>
                                </li>
                                <li>
                                    <a href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/duoxuanti.jsp" class="dropdown-toggle my-dropdown-toggle">多选题</a>
                                </li>
                            </ul>

                        </li>
                        <li id="my-test-menu" data-is-modal="modal">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"
                               data-href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/pre-test.jsp">
                                <%--<i class="icon-bell-alt icon-animated-bell"></i>--%>
                                <img src="assets/system/pufa/img/menu/mn.png" class="my-menu-item">
                                模拟考试
                                <%--<span class="badge badge-important">8</span>--%>
                            </a>
                        </li>
                        <li id="my-collect-menu">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"
                               data-href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/collect.jsp">
                                <%--<i class="icon-envelope icon-animated-vertical"></i>--%>
                                <img src="assets/system/pufa/img/menu/sc.png" class="my-menu-item">
                                收藏题库
                                <%--<span class="badge badge-success">5</span>--%>
                            </a>
                        </li>

                        <li id="my-error-menu">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"
                               data-href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/error.jsp">
                                <%--<i class="icon-envelope icon-animated-vertical"></i>--%>
                                <img src="assets/system/pufa/img/menu/ct.png" class="my-menu-item">
                                错题题库
                                <%--<span class="badge badge-success">5</span>--%>
                            </a>
                        </li>

                        <li id="my-all-menu" data-is-modal="ztk" style="display: none;">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"
                               data-href="CommonCtrl.goTo.do?path=/WEB-INF/system/pufa/all.jsp">
                                <%--<i class="icon-tasks"></i>--%>
                                <img src="assets/system/pufa/img/menu/qt.png" class="my-menu-item">
                                总题库
                                <%--<span class="badge badge-grey">4</span>--%>
                            </a>
                        </li>
                        <%--
                        FIXME
                        <li data-is-modal="logout" class="pull-right"  data-href="${basePath}UserCtrl.logoutForLp.do"--%>
                        <%--style="width: 50px;margin-left:45px;margin-right: -45px;background-color: inherit!important;border-left:0px!important;">--%>
                        <%--<a  data-toggle="dropdown" href="javascript:void(0);"--%>
                        <%--style="width: 45px;height: 45px;margin:0px;padding: 0px;background-color: inherit!important;">--%>
                        <%--<img class="my-exit-btn" title="退出系统" src="${basePath}assets/system/pufa/img/menu/exit1.png"--%>
                        <%--style="margin:0px;padding:0px;width: 45px;height: 45px;">--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <li data-is-modal="logout" class="pull-right" data-href="${basePath}UserCtrl.logoutForLp.do"
                            style="display: none; width: 50px;margin-left:45px;margin-right: -45px;background-color: inherit!important;border-left:0px!important;">
                            <a data-toggle="dropdown" href="javascript:void(0);"
                               style="width: 45px;height: 45px;margin:0px;padding: 0px;color: #000000; background-color: #d3d3d3!important;border: 1px solid #ffffff;">
                                退出
                            </a>
                        </li>
                        <li class="light-blue" style="display: none;">
                            <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                                <img class="nav-user-photo" src="${basePath}assets/avatars/user.jpg"
                                     alt="Jason's Photo"/>
								<span class="user-info">
									<small>个人中心,</small>
									隋丽丽
								</span>

                            </a>
                        </li>
                    </ul>
                    <!-- /.ace-nav -->
                </div>
                <!-- /.navbar-header -->
            </div>
            <!-- /.container -->
        </div>

        <div class="main-container" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed')
                } catch (e) {
                }
            </script>

            <div class="main-container-inner">


                <div id="main-content-id" class="main-content" style="margin-left:0px;margin-top: 10px;">


                    <!-- basic scripts -->

                    <!--[if !IE]> -->

                    <script src="${basePath}assets/js/jquery-2.0.3.min.js"></script>

                    <!-- <![endif]-->

                    <!--[if IE]>
                    <script src="${basePath}assets/js/jquery-1.10.2.min.js"></script>
                    <![endif]-->

                    <!--[if !IE]> -->

                    <script type="text/javascript">
                        window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
                    </script>

                    <!-- <![endif]-->

                    <!--[if IE]>
                    <script type="text/javascript">
                        window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>" + "<" + "/script>");
                    </script>
                    <![endif]-->

                    <script type="text/javascript">
                        if ("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
                    </script>
                    <script src="${basePath}assets/js/bootstrap.min.js"></script>
                    <script src="${basePath}assets/js/typeahead-bs2.min.js"></script>

                    <!-- page specific plugin scripts -->

                    <!--[if lte IE 8]>
                    <script src="${basePath}assets/js/excanvas.min.js"></script>
                    <![endif]-->

                    <script src="${basePath}assets/js/jquery-ui-1.10.3.custom.min.js"></script>
                    <script src="${basePath}assets/js/jquery.ui.touch-punch.min.js"></script>
                    <script src="${basePath}assets/js/bootbox.min.js"></script>
                    <script src="${basePath}assets/js/jquery.easy-pie-chart.min.js"></script>
                    <script src="${basePath}assets/js/jquery.gritter.min.js"></script>
                    <%--<script src="${basePath}assets/js/spin.min.js"></script>--%>
                    <script src="${basePath}assets/js/jquery.knob.min.js"></script>

                    <!-- ace scripts -->
                    <script src="${basePath}assets/js/ace-elements.min.js"></script>
                    <script src="${basePath}assets/js/ace.min.js"></script>

                    <%-- 新手引导效果脚本 --%>
                    <script type="text/javascript" src="${basePath}assets/js/joyride/jquery.cookie.js"></script>
                    <script type="text/javascript" src="${basePath}assets/js/joyride/modernizr.mq.js"></script>
                    <script type="text/javascript" src="${basePath}assets/js/joyride/jquery.joyride-2.1.js"></script>

                    <!-- inline scripts related to this page -->

                    <!-- OWN JS -->
                    <script src="${basePath}config.js"></script>
                    <script src="${basePath}assets/js/jquery.toaster.js"></script>
                    <script src="${basePath}assets/js/hzc.common.1.0.js"></script>

                    <!-- jquery 打印插件 -->
                    <script src="${basePath}assets/js/jquery.jqprint-0.3.js"></script>




