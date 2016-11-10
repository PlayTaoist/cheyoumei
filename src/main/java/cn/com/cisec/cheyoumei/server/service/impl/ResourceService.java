package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.controller.ResultInfo;
import cn.com.cisec.cheyoumei.server.dao.IResourceDao;
import cn.com.cisec.cheyoumei.server.dto.ResourceListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.model.Resource;
import cn.com.cisec.cheyoumei.server.service.IResourceService;
@Service
public class ResourceService implements IResourceService {
	private IResourceDao resourceDao;
	@Autowired
	public void setResourceDao(IResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	@Override
	public List<ResourceListDto> getResourceList() {
		List<ResourceListDto> list  =  resourceDao.getAllResourceList();
		return list;
	}
	@Override
	public Map<String, Object> addResource(String name, String url,
			String description) {
		Map<String, Object> result  = new HashMap<String, Object>();
		if(isExistResourceWithName(name)){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_HINT);
			result.put(ResultInfo.MSG, "资源名称重复");
			return result;
		}
		if(isExistResourceWithUrl(url)){
			result.put(ResultInfo.RESULT, false);
			result.put(ResultInfo.TYPE, ResultInfo.TYPE_HINT);
			result.put(ResultInfo.MSG, "资源URL重复");
			return result;
		}
		Resource resource = new Resource(url,name,description);
		resourceDao.add(resource);
		result.put(ResultInfo.RESULT, true);
		result.put(ResultInfo.MSG, "添加成功");
		return result;
	}
	
	
	private boolean isExistResourceWithUrl(String url){
		boolean result  = false;
		Resource resource  = resourceDao.getResourceByUrl(url);
		if(resource!=null){
			result  = true;
		}
		return result;
	}
	/**
	 * 判断资源名称是否存在在数据库中
	 * @param name
	 * @return
	 */
	private boolean isExistResourceWithName(String name){
		boolean result  = false;
		Resource resource  = resourceDao.getResourceByName(name);
		if(resource!=null){
			result  = true;
		}
		return result;
	}

	@Override
	public void deleteResource(int id) {
		resourceDao.delete(id);
	}
	@Override
	public void updateResource(int id, String name, String url, String description) {
		//System.out.println(description);
		Resource resource = resourceDao.load(id);
		resource.setName(name);
		resource.setUrl(url);
		resource.setDescription(description);
		resourceDao.update(resource);
	}
	@Override
	public Pager<ResourceListDto> findResourceList(String query) {
		return resourceDao. findResourceList(query);
	}
}
