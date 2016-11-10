package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.controller.ResultInfo;
import cn.com.cisec.cheyoumei.server.dao.IResourceDao;
import cn.com.cisec.cheyoumei.server.dao.IRoleDao;
import cn.com.cisec.cheyoumei.server.dto.SelectListDto;
import cn.com.cisec.cheyoumei.server.dto.RoleListDto;
import cn.com.cisec.cheyoumei.server.model.Resource;
import cn.com.cisec.cheyoumei.server.model.Role;
import cn.com.cisec.cheyoumei.server.service.IRoleService;
@Service
public class RoleService implements IRoleService {
	private IRoleDao roleDao;
	private IResourceDao resourceDao;
	
	@Autowired
	public void setResourceDao(IResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	@Autowired
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	/**
	 * 获取所有角色列表，并转换为客户端需要的对象
	 */
	@Transactional
	@Override
	public List<RoleListDto> getAllRoleDto() {
		List<Role> roles  = roleDao.getAllRole();
		List<RoleListDto> roleDtos  = new ArrayList<RoleListDto>();
		for(Role role:roles){
			Set<Resource> resourcesObj  = role.getResources();
			String resources="";
			for(Resource res:resourcesObj){
				resources+=res.getName()+",";
			}
			resources=resources.substring(0, resources.length()-1);
			RoleListDto roleDto = new RoleListDto(role.getId(), role.getName(), resources, role.getDescription());
			roleDtos.add(roleDto);
		}
		return roleDtos;
	}
	/**
	 * 获取所有的资源，通过角色iD
	 */
	@Transactional
	@Override
	public List<SelectListDto> getResourceListByRoleId(int id) {
		List<Resource> list = resourceDao.getAllResource();
		List<SelectListDto> resources  = new ArrayList<SelectListDto>();
		for(Resource res:list){
			Set<Role> roles  =   res.getRoles();
			boolean checked = false;
			for(Role role:roles){
				if(role.getId()==id){
					checked =true;
					break;
				}
			}
			SelectListDto resource =  new SelectListDto(res.getName(), res.getId()+"", res.getId(), checked);
			resources.add(resource);
		}
		return resources;
	}
	@Transactional
	@Override
	public Map<String, Object> addRole(String name, int[] resIds,
			String description) {
		Map<String, Object> result  = new HashMap<String, Object>();
		Role role  = roleDao.getRoleByName(name);
		if(role==null){
			Set<Resource> resources = new HashSet<Resource>();
			for(int resId:resIds){
				Resource resource = resourceDao.load(resId);
				if(resource==null){
					result.put(ResultInfo.RESULT, false);
					result.put(ResultInfo.TYPE, ResultInfo.TYPE_ERROR);
					result.put(ResultInfo.MSG, "给角色授权的资源不存在");
					return result;
				}else{
					resources.add(resource);
				}
			}
			role  = new Role(name,description,resources);
			role=roleDao.add(role);
			if(role!=null){
				result.put(ResultInfo.RESULT, true);
				result.put(ResultInfo.TYPE, ResultInfo.TYPE_INFO);
				result.put(ResultInfo.MSG, "添加成功");
			}else{
				result.put(ResultInfo.RESULT, false);
				result.put(ResultInfo.TYPE, ResultInfo.TYPE_ERROR);
				result.put(ResultInfo.MSG, "添加角色失败，请与管理员联系");
			}
			return result;
		}else{
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_HINT);
			result.put(ResultInfo.MSG, "角色名称重复！");
			return result;
		}
	}
	@Transactional
	@Override
	public void deleteRole(int id) {
		roleDao.delete(id);
	}
	@Transactional
	@Override
	public void updateRole(int id, String name, int[] resIds, String description) {
		Role role =roleDao.load(id);
		role.setName(name);
		role.setDescription(description);
		Set<Resource> resources  =new HashSet<Resource>();
		for(int resId:resIds){
			Resource resource  = resourceDao.load(resId);
			resources.add(resource);
		}
		role.setResources(resources);
		roleDao.update(role);
	}
	
}
