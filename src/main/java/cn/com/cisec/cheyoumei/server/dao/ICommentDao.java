package cn.com.cisec.cheyoumei.server.dao;

import java.util.List;

import cn.com.cisec.cheyoumei.server.model.Comment;

public interface ICommentDao extends IBaseDao<Comment> {

	Object findCommentList(List<Integer> goodsList, int limitStart,
			Integer pageSize);

}
