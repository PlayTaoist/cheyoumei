package cn.com.cisec.cheyoumei.server.controller.systemmanage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cisec.cheyoumei.server.controller.ResultInfo;
import cn.com.cisec.cheyoumei.server.dto.SelectListDto;
import cn.com.cisec.cheyoumei.server.dto.RoleListDto;
import cn.com.cisec.cheyoumei.server.service.IRoleService;

@Controller
@RequestMapping("manager/systemManage/roleManage")
public class RoleManageController {
	private IRoleService roleService;

	@Autowired
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
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
	 * 获取角色列表
	 * 
	 * @return
	 */
	@RequestMapping("getRoleList")
	@ResponseBody
	public Object getRoleList() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<RoleListDto> roles = roleService.getAllRoleDto();
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.LIST, roles);
		return result;
	}

	/**
	 * 获取角色对应的资源列表
	 * 
	 * @param id
	 *            角色的ID
	 * @return
	 */
	@RequestMapping("getResourceListByRoleId")
	@ResponseBody
	public Object getResourceListByRoleId(int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		/*
		 * if(id==1||id==2||id==3||id==4){ result.put(ResultInfo.RESULT, false);
		 * result.put(ResultInfo.MSG, "系统内置角色，不可编辑"); return result; }
		 */
		List<SelectListDto> resources = roleService.getResourceListByRoleId(id);
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.LIST, resources);
		return result;
	}

	@RequestMapping("addRole")
	@ResponseBody
	public Object addRole(String name, String resourceIds, String description) {
		//System.out.println("name="+name+"resourceIds="+resourceIds+"description="+description);
		Map<String, Object> result = new HashMap<String, Object>();
		if (name == null || resourceIds == null || "".equals(name)
				|| "".equals(resourceIds)) {
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_HINT);
			result.put(ResultInfo.MSG, "请输入角色名称或选择角色可访问的资源！ ");
			return result;
		}
		String[] resourceIdsStrngArray = resourceIds.split(",");
		int[] resIds = new int[resourceIdsStrngArray.length];
		for (int i = 0; i < resIds.length; i++) {
			try {
				resIds[i] = Integer.parseInt(resourceIdsStrngArray[i]);
			} catch (NumberFormatException e) {
				result.put(ResultInfo.RESULT, false);
				result.put(ResultInfo.TYPE, ResultInfo.TYPE_ERROR);
				result.put(ResultInfo.MSG, "资源ID格式有误");
				return result;
			}
		}
		 result = roleService.addRole(name,resIds,description);
		 return result;
	}
	@RequestMapping("deleteRole")
	@ResponseBody
	public Object deleteRole(int id){
		Map<String, Object> result = new HashMap<String, Object>();
		if(id==1||id==1||id==2||id==3||id==4){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_WARNING);
			result.put(ResultInfo.MSG, "系统内置角色不能删除");
		}
		roleService.deleteRole(id);
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.MSG, "删除成功");
		return result;
	}
	@RequestMapping("editRole")
	@ResponseBody
	public Object editRole(int id,String name,String resourceIds,String description){
		//System.out.println("id="+id+"name="+name+"resourceIds="+resourceIds+"description="+description);
		Map<String, Object> result = new HashMap<String, Object>();
		if(name==null||resourceIds==null||"".equals(name)||"".equals(resourceIds)){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_HINT);
			result.put(ResultInfo.MSG, "角色名称，角色权限不能为空");
			return result;
		}
		//调试期间暂时放开编辑
	/*	if(id==1||id==1||id==2||id==3||id==4){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_WARNING);
			result.put(ResultInfo.MSG, "系统内置角色不能删除");
		}*/
		String[] resourceIdsStrArray =  resourceIds.split(",");
		int[] resIds  = new int[resourceIdsStrArray.length];
		for(int i=0;i<resourceIdsStrArray.length;i++){
			try {
				resIds[i]=Integer.parseInt(resourceIdsStrArray[i]);
			} catch (NumberFormatException e) {
				result.put(ResultInfo.RESULT, false);
				result.put(ResultInfo.TYPE, ResultInfo.TYPE_HINT);
				result.put(ResultInfo.MSG, "权限格式不正确");
				return result;
			}
		}
		roleService.updateRole(id,name,resIds,description);
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.MSG, "升级成功");
		return result;
	}
}
