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
	<meta http-equiv="keywords" content="Android">
	<meta http-equiv="description" content="首页">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="ext/resources/css/ext-all-neptune.css">
	<script type="text/javascript" src="ext/ext-all.js"></script>
	<script type="text/javascript" src="ext/locale/ext-lang-zh_CN.js"></script>	
	<script type="text/javascript" src="js/main.js"></script>
	<!-- <link rel="stylesheet" type="text/css" href="ext/examples/shared/example.css" />
	<script type="text/javascript" src="ext/examples/shared/examples.js"></script> -->
	<script type="text/javascript">
		var contextPath = "<%=basePath %>";
	</script>
	
	<!-- <link rel="stylesheet" type="text/css" href="ext/examples/portal/portal.css" /> -->
	
  </head>
  
  <body>
  </body>
</html>
