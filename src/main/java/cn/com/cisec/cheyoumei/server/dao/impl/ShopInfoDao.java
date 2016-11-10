package cn.com.cisec.cheyoumei.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IShopInfoDao;
import cn.com.cisec.cheyoumei.server.dto.GoodsCatRelDto;
import cn.com.cisec.cheyoumei.server.dto.GoodsDto;
import cn.com.cisec.cheyoumei.server.dto.ShopInfoListDto;
import cn.com.cisec.cheyoumei.server.model.ShopInfo;
@Repository
public class ShopInfoDao extends BaseDao<ShopInfo> implements IShopInfoDao{

	@Override
	public Object findShopInfos(String city, int limitStart, int pageSize) {
		String sql="select s.id as id,s.addr as addr,s.shopName as shopName,s.totalRase as totalRase,s.user_id as user_id, b.url as url,g.id as goodsId,g.name as goodsName,g.discPrice as discPrice from ShopGallery b left outer join ShopInfo s on b.shopInfo_id=s.id left outer join Goods g on g.shopInfo_id=s.id";
		if (city!=null&&!"".equals(city)) {
			sql=sql+" where (s.city='"+city+"' and g.critical=1) LIMIT "+limitStart+","+pageSize+"";
		}
		return findMobileDatasBySql(sql, ShopInfoListDto.class,limitStart,pageSize,false);
	}

	@Override
	public Integer findGoodsCatId(Integer id) {
		String sql ="SELECT g.goodsCat_id FROM Goods g WHERE g.shopInfo_id="+id;
		Integer goodsCatId = findIdByXXXX(sql);
		return goodsCatId;
	}

	@Override
	public List<GoodsCatRelDto> findGoodsCatRel(Integer ids) {
		String sql="select g.id as id,g.child_id as child,g.parent_id as parent,g.level as level from GoodsCatRel g where g.child_id =" + ids;
		List<GoodsCatRelDto> list = findMobileDatasBySql(sql,GoodsCatRelDto.class,0,0,false);
		return list;
	}

	@Override
	public String findTitleByParentId(int parent_id) {
		String sql = "select g.title from GoodsCat g where g.id = " +parent_id;
		String goodsCatTitle = findTitleByParentId(sql);
		return goodsCatTitle;
	}

	@Override
	public List<GoodsDto> findGoodsName(Integer id) {
		String sql = "select g.id as id,g.name as name,g.discPrice as discPrice from Goods g where g.shopInfo_id = " + id;
		List<GoodsDto> list = findMobileDatasBySql(sql,GoodsDto.class,0,0,false);
		return list;
	}

}
