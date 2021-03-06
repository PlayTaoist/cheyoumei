/**
 * 
 */
package cn.com.cisec.cheyoumei.server.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import cn.com.cisec.cheyoumei.server.dao.IBaseDao;
import cn.com.cisec.cheyoumei.server.model.Pager;
import cn.com.cisec.cheyoumei.server.model.SystemContext;


@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> {
	private final static Logger log = Logger.getLogger(BaseDao.class);
	private SessionFactory sessionFactory;
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;
	
	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T add(T t) {
		getSession().save(t);
		return t;
	}


	@Override
	public void update(T t) {
		getSession().update(t);
	}


	@Override
	public void delete(int id) {
		getSession().delete(this.load(id));
	}


	@Override
	public T load(int id) {
		return (T)getSession().load(getClz(), id);
	}


	public List<T> list(String hql, Object[] args) {
		return this.list(hql, args, null);
	}


	public List<T> list(String hql, Object arg) {
		return this.list(hql, new Object[]{arg});
	}


	public List<T> list(String hql) {
		return this.list(hql,null);
	}
	
	private String initSort(String hql) {
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(sort!=null&&!"".equals(sort.trim())) {
			hql+=" order by "+sort;
			if(!"desc".equals(order)) hql+=" asc";
			else hql+=" desc";
		}
		return hql;
	}
	
	@SuppressWarnings("rawtypes")
	private void setAliasParameter(Query query,Map<String,Object> alias) {
		if(alias!=null) {
			Set<String> keys = alias.keySet();
			for(String key:keys) {
				Object val = alias.get(key);
				if(val instanceof Collection) {
					//查询条件是列表
					query.setParameterList(key, (Collection)val);
				} else {
					query.setParameter(key, val);
				}
			}
		}
	}
	
	private void setParameter(Query query,Object[] args) {
		if(args!=null&&args.length>0) {
			int index = 0;
			for(Object arg:args) {
				query.setParameter(index++, arg);
			}
		}
	}


	public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(hql);
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.list();
	}


	public List<T> listByAlias(String hql, Map<String, Object> alias) {
		return this.list(hql, null, alias);
	}


	public Pager<T> find(String hql, Object[] args) {
		return this.find(hql, args, null);
	}


	public Pager<T> find(String hql, Object arg) {
		return this.find(hql, new Object[]{arg});
	}


	public Pager<T> find(String hql) {
		return this.find(hql,null);
	}
	
	@SuppressWarnings("rawtypes")
	private void setPagers(Query query,Pager pages) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageOffset==null||pageOffset<0) pageOffset = 0;
		if(pageSize==null||pageSize<0) pageSize = 15;
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
	}
	
	private String getCountHql(String hql,boolean isHql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*) "+e;
		if(isHql)
			c = c.replaceAll("fetch", "");
		return c;
	}


	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(hql);
		String cq = getCountHql(hql,true);
		Query cquery = getSession().createQuery(cq);
		Query query = getSession().createQuery(hql);
		//设置别名参数
		setAliasParameter(query, alias);
		setAliasParameter(cquery, alias);
		//设置参数
		setParameter(query, args);
		setParameter(cquery, args);
		Pager<T> pages = new Pager<T>();
		setPagers(query,pages);
		List<T> datas = query.list();
		pages.setDatas(datas);
		long total = (Long)cquery.uniqueResult();
		pages.setTotal(total);
		return pages;
	}


	public Pager<T> findByAlias(String hql, Map<String, Object> alias) {
		return this.find(hql,null, alias);
	}

	public Object queryObject(String hql, Object[] args) {
		return this.queryObject(hql, args,null);
	}


	public Object queryObject(String hql, Object arg) {
		return this.queryObject(hql, new Object[]{arg});
	}


	public Object queryObject(String hql) {
		return this.queryObject(hql,null);
	}


	public void updateByHql(String hql, Object[] args) {
		Query query = getSession().createQuery(hql);
		setParameter(query, args);
		query.executeUpdate();
	}


	public void updateByHql(String hql, Object arg) {
		this.updateByHql(hql,new Object[]{arg});
	}


	public void updateByHql(String hql) {
		this.updateByHql(hql,null);
	}


	public <N extends Object>List<N> listBySql(String sql, Object[] args, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, args, null, clz, hasEntity);
	}


	public <N extends Object>List<N> listBySql(String sql, Object arg, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, new Object[]{arg}, clz, hasEntity);
	}


	public <N extends Object>List<N> listBySql(String sql, Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, clz, hasEntity);
	}


	public <N extends Object>List<N> listBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		SQLQuery sq = getSession().createSQLQuery(sql);
		setAliasParameter(sq, alias);
		setParameter(sq, args);
		if(hasEntity) {
			sq.addEntity(clz);
		} else 
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		return sq.list();
	}

	public <N extends Object>List<N> listByAliasSql(String sql, Map<String, Object> alias,
			Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, alias, clz, hasEntity);
	}


	public <N extends Object>Pager<N> findBySql(String sql, Object[] args, Class<?> clz,
			boolean hasEntity) {
		return this.findBySql(sql, args, null, clz, hasEntity);
	}

	public <N extends Object>Pager<N> findBySql(String sql, Object arg, Class<?> clz,
			boolean hasEntity) {
		return this.findBySql(sql, new Object[]{arg}, clz, hasEntity);
	}


	public <N extends Object>Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, null, clz, hasEntity);
	}
	//TODO
	public String findShopGalleryUrl(String sql){
		return null;
	}
	//TODO
	public List findUsrCarListDatas(String sql){
		List sqlList = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < sqlList.size(); i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			Object[] obj = (Object[])sqlList.get(i);
			 map.put("id",(Integer)obj[0]);
			 map.put("url",(String)obj[1]);
			 map.put("plateNum",(String)obj[2]);
			 map.put("carSeries",(String)obj[3]);
			 map.put("carColor",(String)obj[4]);
			 map.put("defaultOne",obj[5]);
			 list.add(map);
		}
		return list;
	}
	//TODO
	@SuppressWarnings("rawtypes")
	private void setMobilePagers(Query query,Pager pages,int limitStart,int pageSize) {
		Integer pageSizes = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageOffset==null||pageOffset<0) pageOffset = 0;
		if(pageSizes==null||pageSize<0) pageSizes = limitStart;
		pages.setOffset(pageOffset);
		pages.setSize(pageSizes);
	}
	//TODO
	public String findTitleByParentId(String sql){
		List sqlList = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		Object goodsCat_Title = sqlList.get(0);
		String goodsCatTitle = (String)goodsCat_Title;
		return goodsCatTitle;
	}
	//TODO
	public boolean findPlateNumByNum(String sql){
		List sqlList = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		if (sqlList.isEmpty()) {
			//如果为空就是没有次车牌在数据库中
			return false;
		}
		return true;
	}
	//TODO
	public List<Integer> findIdList(String sql){
		List<Integer> list = new ArrayList<Integer>();
		List<Object> sqlList = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		if (sqlList.isEmpty()) {
			return null;
		}
		for (int i = 0; i < sqlList.size(); i++) {
			Object id = sqlList.get(i);
			Integer ids = (Integer) id;
			list.add(ids);
		}
		return list;
	}
	//TODO
	public boolean findIsCommentByOrderCode(String sql){
		List sqlList = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		if (sqlList.isEmpty()) {
			return false;
		}
		Object serviceTime = sqlList.get(0);
		boolean isComment = (Boolean) serviceTime;
		return isComment;
	}
	//TODO
	public Date findTimeByXXXX(String sql){
		List sqlList = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		if (sqlList.isEmpty()) {
			return null;
		}
		Object serviceTime = sqlList.get(0);
		Date time = (Date) serviceTime;
		return time;
	}
	//TODO
	public Integer findIdByXXXX(String sql){
		List sqlList = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		if (sqlList.isEmpty()) {
			return null;
		}
		Object ordersId = sqlList.get(0);
		Integer id = (Integer) ordersId;
		return id;
	}

	//TODO
	public <N extends Object>List<N> findMobileDatasBySql(String sql, Class<?> clz,int limitStart,int pageSize, boolean hasEntity) {
		return this.findMobileDatasBySql(sql, null, clz,limitStart,pageSize, hasEntity);
	}
	//TODO
	public <N extends Object>List<N> findMobileDatasBySql(String sql, Object[] args, Class<?> clz,int limitStart,int pageSize,
			boolean hasEntity) {
		return this.findMobileDatasBySql(sql, args, null, clz,limitStart,pageSize, hasEntity);
	}
	//TODO
	public <N extends Object> List<N> findMobileDatasBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz,int limitStart,int pageSize, boolean hasEntity) {
		sql = initSort(sql);
		String cq = getCountHql(sql,false);
		SQLQuery sq = getSession().createSQLQuery(sql);
		SQLQuery cquery = getSession().createSQLQuery(cq);
		setAliasParameter(sq, alias);
		setAliasParameter(cquery, alias);
		setParameter(sq, args);
		setParameter(cquery, args);
		Pager<N> pages = new Pager<N>();
		setMobilePagers(sq, pages,limitStart,pageSize);
		System.out.println("sq:"+sq);
		System.out.println("cquery:"+cquery);
		if(hasEntity) {
			sq.addEntity(clz);
		} else {
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		}
		List<N> datas = sq.list();
		return datas;
	}
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		String cq = getCountHql(sql,false);
		SQLQuery sq = getSession().createSQLQuery(sql);
		SQLQuery cquery = getSession().createSQLQuery(cq);
		setAliasParameter(sq, alias);
		setAliasParameter(cquery, alias);
		setParameter(sq, args);
		setParameter(cquery, args);
		Pager<N> pages = new Pager<N>();
		setPagers(sq, pages);
		if(hasEntity) {
			sq.addEntity(clz);
		} else {
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		}
		List<N> datas = sq.list();
		pages.setDatas(datas);
		long total = ((BigInteger)cquery.uniqueResult()).longValue();
		pages.setTotal(total);
		return pages;
	}

	public <N extends Object>Pager<N> findByAliasSql(String sql, Map<String, Object> alias,
			Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, null, alias, clz, hasEntity);
	}

	public Object queryObject(String hql, Object[] args,
			Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.uniqueResult();
	}

	public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
		return this.queryObject(hql,null,alias);
	}

}
