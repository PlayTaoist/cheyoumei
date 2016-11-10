package cn.com.cisec.cheyoumei.server.service;

import java.util.List;
import java.util.Map;

import cn.com.cisec.cheyoumei.server.dto.ResourceListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;

public interface IResourceService {

	List<ResourceListDto> getResourceList();

	Map<String, Object> addResource(String name, String url, String description);

	void deleteResource(int id);

	void updateResource(int id, String name, String url, String description);
	/**
	 * 带搜索的查询
	 * @param query 查询关键字,""或者NUll代表查询所有
	 * @return
	 */
	Pager<ResourceListDto> findResourceList(String query);


}
