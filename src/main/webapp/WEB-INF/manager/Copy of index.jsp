<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>海南海事局网上政务大厅后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="海事局,网上政务,网上审批">
	<meta http-equiv="description" content="首页">
	<link rel="stylesheet" href="css/login.css"/>
	<link rel="stylesheet" type="text/css" href="ext/resources/css/ext-all-neptune.css">
	<script type="text/javascript" src="ext/ext-all.js"></script>
	<script type="text/javascript" src="ext/locale/ext-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
  </head>
  
<body style="background-color:#157FCC;">
	<div id="logo">海南海事局网上政务大厅管理系统</div>
	<div id="loginForm">
   		
    	<form>
        	<label role="username" class="usernamelabel" style="font-size: 14px;">用户名：
            	<input type="text" name="username" id="username" />
            </label>
            <label role="password" class="passwordlabel" style="font-size: 14px;">密&nbsp;&nbsp;&nbsp;码：
            	<input type="password" name="password" id="password"/>
            </label>
            <label role="checkcode" class="checkcodelabel" style="font-size: 14px;">验证码：
            	<input type="text" name="checkcode" id="checkcode" />
            </label>
            <div id="submit"></div>
            <div id="reset"></div>
            <!-- <input type="image" id="submit"  src="img/login/form_login.gif"/>
            <input type="image" id="reset" src="img/login/form_reset.gif" /> -->
        </form>
        <div id="info" style="font-size: 16px;">@Copyright 中华人民共和国海南海事局</div>
    </div>
    
</body>
</html>
