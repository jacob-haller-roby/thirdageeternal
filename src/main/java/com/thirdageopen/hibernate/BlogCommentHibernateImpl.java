package com.thirdageopen.hibernate;

import org.springframework.stereotype.Repository;

import com.thirdageopen.dao.BlogCommentDao;
import com.thirdageopen.domain.BlogComment;

@Repository
public class BlogCommentHibernateImpl extends BaseHibernateImpl<BlogComment> implements BlogCommentDao{
	
	public BlogCommentHibernateImpl() {
		type = new BlogComment();
	}

}
