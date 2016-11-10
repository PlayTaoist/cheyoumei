<%@ page language="java" pageEncoding="UTF-8"%>  
<form action="<%=request.getContextPath()%>/app/uploadApp" method="post" enctype="multipart/form-data">   
	App包名: <input type="text" name ="packageName"/><br/>  
	App名称: <input type="text" name ="name"/><br/>  
	App描述: <input type="text" name ="describe"/><br/>  
	App图标: <input type="file" name="icon"/><br/>  
    App文件: <input type="file" name="file"/><br/>  
    <input type="submit" value="上传"/>  
</form>  