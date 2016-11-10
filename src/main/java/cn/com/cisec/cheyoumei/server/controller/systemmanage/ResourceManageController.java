package cn.com.cisec.cheyoumei.server.controller.systemmanage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.controller.ResultInfo;
import cn.com.cisec.cheyoumei.server.dto.ResourceListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.service.IResourceService;

@Controller
@RequestMapping("manager/systemManage/resourceManage")
public class ResourceManageController {
	private IResourceService resourceService;
	@Autowired
	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}
	@RequestMapping("")
	@ResponseBody
	public Object roleManage() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.MSG, "访问成功");
		return result;
	}
	/**
	 * 获取资源对象列表
	 * @param query 如果为null 或者‘’‘’为没有查询关键字
	 * @return
	 */
	@RequestMapping("getResourceList")
	@ResponseBody
	public Object getResourceList(String query){
		/*List<ResourceListDto> list  = resourceService.getResourceList();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.LIST, list);
		return result;*/
		Pager<ResourceListDto> page= resourceService.findResourceList(query);//分页对象
		return page;
	}
	@RequestMapping("addResource")
	@ResponseBody
	public Object addResource(String name,String url,String description){
		Map<String, Object> result = new HashMap<String, Object>();
		if(name==null||url==null||"".equals(name)||"".equals(url)){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_ERROR);
			result.put(ResultInfo.MSG, "资源名称或资源的URL不能为空");
			return result;
		}
		result  = resourceService.addResource(name,url,description);
		return result;
	}
	@RequestMapping("deleteResource")
	@ResponseBody
	public Object deleteResource(int id){
		Map<String, Object> result = new HashMap<String, Object>();
		 resourceService.deleteResource(id);
		 result.put(ResultInfo.RESULT, true);
		 result.put(ResultInfo.MSG, "删除成功");
		return result;
	}
	@RequestMapping("editResource")
	@ResponseBody
	public Object editResource(int id,String name,String url,String description){
		Map<String, Object> result = new HashMap<String, Object>();
		 if(name==null||url==null||"".equals(name)||"".equals(url)){
			 result.put(ResultInfo.RESULT, false);
			 result.put(ResultInfo.TYPE, ResultInfo.TYPE_ERROR);
			 result.put(ResultInfo.MSG, "资源名称，资源url不能为空");
			return result;
		 }
		 resourceService.updateResource(id,name,url,description);
		 result.put(ResultInfo.RESULT, true);
		 result.put(ResultInfo.MSG, "编辑成功");
		return result;
	}
}
