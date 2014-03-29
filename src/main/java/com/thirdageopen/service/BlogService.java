package com.thirdageopen.service;

import java.util.List;

import com.thirdageopen.domain.Blog;

public interface BlogService extends BaseCRUDService<Blog>{
	
	public Blog getArticle(Integer id);
	
	public List<Blog> getDeveloperBlog();
	
	public List<Blog> getNewsBlog();

}
