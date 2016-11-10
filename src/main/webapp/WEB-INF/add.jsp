<%@ page language="java" pageEncoding="UTF-8"%>  
<form action="<%=request.getContextPath()%>/upload/uploadfile" method="post" enctype="multipart/form-data">   
    yourfile: <input type="file" name="file"/><br/>  
    <input type="submit" value="添加新用户"/>  
</form>  