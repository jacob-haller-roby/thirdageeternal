package com.thirdageopen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.BlogDAO;
import com.thirdageopen.domain.Blog;
import com.thirdageopen.service.BlogService;

@Service
@Transactional
public class BlogServiceImpl extends BaseCRUDServiceImpl<Blog> implements BlogService{

	@Autowired
	private BlogDAO blogDAO;
	
	
	@Override
	public void create(Blog object) {
		blogDAO.save(object);
	}

	@Override
	public List<Blog> retrieve() {
		return blogDAO.all();
	}

	@Override
	public void update(Blog object) {
		blogDAO.update(object);
	}

	@Override
	public void delete(Blog object) {
		blogDAO.delete(object);
	}

	@Override
	public Blog getArticle(Integer id) {
		return blogDAO.startCall().exactMatch("id", id).list().get(0);
	}
	
	@Override
	public List<Blog> getDeveloperBlog(){
		return blogDAO.startCall().exactMatch("category", 1).list();
	}
	
	@Override
	public List<Blog> getNewsBlog(){
		return blogDAO.startCall().exactMatch("category", 2).list();
	}
}
