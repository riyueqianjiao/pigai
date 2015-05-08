<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<div class="topbar">
        <div class="toolbar-left"> <i class="app-icon"><img src="images/icon/oa.png" width="18" height="18" /></i><span class="app-name">办公管理</span></div>
        <ul class=" user-toolbar " style="position: relative">
            <li id="mySites" class="my-sites menu-button-active">
                <a class="menu-button"><span>访问</span></a>
            </li>
            <li class="separator"><span></span></li>
            <li class="user-links">
                <a class="user-portrait"><img src="images/tuoxiang.png"  /></a>
                <a class="user-fullname">学校管理员</a>
                <span class="sign-out">
                    <a href="">（注销）</a>
                </span>
            </li>
             <div id="mySitesContainer" class="my-sites-menu" style="display:none;position: absolute;left: 10px;top: 24px;z-index: 999999;">
                <div class="sites-menu-content">
                    <ul>
                        <li class="first"><a href=""><i class="icon back"></i> <span class="site-name">返回云桌面</span></a></li>
                        <li ><a href=""><i class="icon users"></i> <span class="site-name">用户和组织</span></a></li>
                        <li ><a href=""><i class="icon bag"></i> <span class="site-name">公文流转</span></a></li>
                        <li ><a href=""><i class="icon contactcard"></i> <span class="site-name">学生信息</span></a></li>
                        <li ><a href=""><i class="icon mailopened"></i> <span class="site-name">上级通知</span></a></li>
                        <li ><a href=""><i class="icon bargraph"></i> <span class="site-name">教师统计</span></a></li>
                        <li ><a href=""><i class="icon linedpapercheck"></i> <span class="site-name">考试成绩</span></a></li>
                        <li ><a href=""><i class="icon inedpaperpencil"></i> <span class="site-name">在线听课</span></a></li>
                        <li ><a href=""><i class="icon slide"></i> <span class="site-name">教学管理</span></a></li>
                        <li ><a href=""><i class="icon monitor"></i> <span class="site-name">网络课堂</span></a></li>
                        <li class="last"><a href=""><i class="icon paperpencil"></i> <span class="site-name">请假管理</span></a></li>
                        
                    </ul>
              </div>
            </div>
        </ul>
    </div>
    
    <script>
    if ($.browser.safari) {
 		$(".sf-sub-indicator").toggle(function(){
 			stopPro(event);
	 		$(this).parent().next("ul").show();
        },function(){
        	stopPro(event);
        	$(this).parent().next("ul").hide();
        });
 		$(".sf-sub-indicator-a").toggle(function(){
 			stopPro(event);
	 		$(this).next("ul").show();
        },function(){
        	stopPro(event);
        	$(this).next("ul").hide();
        });
    }   
    
    </script>