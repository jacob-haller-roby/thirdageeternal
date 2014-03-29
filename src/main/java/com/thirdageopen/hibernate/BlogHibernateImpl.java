package com.thirdageopen.hibernate;

import org.springframework.stereotype.Repository;

import com.thirdageopen.dao.BlogDAO;
import com.thirdageopen.domain.Blog;

@Repository
public class BlogHibernateImpl extends BaseHibernateImpl<Blog> implements BlogDAO{

	public BlogHibernateImpl() {
		type = new Blog();
	}
	
}
