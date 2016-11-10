package cn.com.cisec.cheyoumei.server.service;

import java.util.List;
import java.util.Map;

import cn.com.cisec.cheyoumei.server.dto.SelectListDto;
import cn.com.cisec.cheyoumei.server.dto.RoleListDto;

public interface IRoleService {

	List<RoleListDto> getAllRoleDto();

	List<SelectListDto> getResourceListByRoleId(int id);

	Map<String, Object> addRole(String name, int[] resIds, String description);

	void deleteRole(int id);

	void updateRole(int id, String name, int[] resIds, String description);

}
