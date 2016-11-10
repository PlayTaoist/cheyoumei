<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>车优美</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="管理">
	<meta http-equiv="description" content="首页">
	<link rel="stylesheet" href="css/login.css"/>
	<link rel="stylesheet" type="text/css" href="ext/resources/css/ext-all-neptune.css">
	<script type="text/javascript" src="ext/ext-all.js"></script>
	<script type="text/javascript" src="ext/locale/ext-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript">
		var contextPath="<%=basePath%>";
	</script>
  </head>
  
<body style="background-color:#157FCC;">
	<div id="logo"></div>
	<div id="loginForm">
    	<form>
            <div id="username"></div>
            <div id="password"></div>
            <div id="checkcode"></div>
            <div id="submit"></div>
            <div id="reset"></div>
            <img id="imgcode" title="点击更换" onclick="javascript:refresh(this);" src="getcode"><br/>
        </form>
    </div>
    
</body>
</html>
