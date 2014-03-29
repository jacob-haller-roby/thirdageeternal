package com.thirdageopen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.BlogCommentDao;
import com.thirdageopen.domain.BlogComment;
import com.thirdageopen.service.BlogCommentService;

@Service
@Transactional
public class BlogCommentServiceImpl extends BaseCRUDServiceImpl<BlogComment> implements BlogCommentService{

	@Autowired
	private BlogCommentDao blogCommentDao;
	
	@Override
	public void create(BlogComment object) {
		blogCommentDao.save(object);
	}

	@Override
	public List<BlogComment> retrieve() {
		return blogCommentDao.all();
	}

	@Override
	public void update(BlogComment object) {
		blogCommentDao.update(object);
	}

	@Override
	public void delete(BlogComment object) {
		blogCommentDao.delete(object);
	}

}
