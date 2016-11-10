package cn.com.cisec.cheyoumei.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.ICommentDao;
import cn.com.cisec.cheyoumei.server.dto.CommentListDto;
import cn.com.cisec.cheyoumei.server.model.Comment;
@Repository
public class CommentDao extends BaseDao<Comment> implements ICommentDao {

	@Override
	public Object findCommentList(List<Integer> goodsList, int limitStart,
			Integer pageSize) {
		List<Object> lists = new ArrayList<Object>();
		List<CommentListDto> list = new ArrayList<CommentListDto>();
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println("goodsList:"+goodsList.get(i));
			String sql = "select c.id as id,c.message as message,c.createdAt as createdAt,u.userName as username,u.mobilePhone as mobilePhone from "
					+ "Comment c left outer join User u on c.user_id=u.id where c.goodsId_id="+goodsList.get(i)+" limit "+limitStart+","+pageSize;
			 list = findMobileDatasBySql(sql, CommentListDto.class, limitStart, limitStart, false);
			 lists.add(list);
		}
		return lists;
	}

}
