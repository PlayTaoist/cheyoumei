package cn.com.cisec.cheyoumei.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IResourceDao;
import cn.com.cisec.cheyoumei.server.dto.ResourceListDto;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.model.Resource;
@Repository
public class ResourceDao extends BaseDao<Resource> implements IResourceDao {

	@Override
	public List<Resource> getAllResource() {
		return list("from Resource");
	}

	@Override
	public List<ResourceListDto> getAllResourceList() {
		return listBySql("select r.id as id,r.name as name,r.description as description,r.url as url from Resource r", ResourceListDto.class, false);
	}

	@Override
	public Resource getResourceByName(String name) {
		return (Resource) queryObject("from Resource r where r.name =?",name);
	}

	@Override
	public Resource getResourceByUrl(String url) {
		return (Resource) queryObject("from Resource r where r.url =?",url);
	}

	@Override
	public Pager<ResourceListDto> findResourceList(String query) {
		String sql ="select r.id as id,r.name as name,r.description as description,r.url as url from Resource r ";
		if(query!=null&&!"".equals(query)){
			sql  = sql+"where r.name like '%"+query+"%'  or r.description like '%"+query+"%' or r.url like '%"+query+"%'";
		}
		return findBySql(sql,ResourceListDto.class,false );
	}
	
}
