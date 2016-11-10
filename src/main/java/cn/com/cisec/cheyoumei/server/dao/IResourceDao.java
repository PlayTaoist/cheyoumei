package cn.com.cisec.cheyoumei.server.dao;

import java.util.List;

import cn.com.cisec.cheyoumei.server.dto.ResourceListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.model.Resource;


public interface IResourceDao  extends IBaseDao<Resource>{

	List<Resource> getAllResource();

	List<ResourceListDto> getAllResourceList();

	Resource getResourceByName(String name);

	Resource getResourceByUrl(String url);

	Pager<ResourceListDto> findResourceList(String query);

}
