package com.thirdageopen.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thirdageopen.domain.Blog;
import com.thirdageopen.domain.BlogComment;
import com.thirdageopen.model.APIResponseModel;
import com.thirdageopen.model.BlogModel;
import com.thirdageopen.request.model.CommentBlogModel;
import com.thirdageopen.request.model.EditBlogModel;
import com.thirdageopen.request.model.WriteBlogModel;
import com.thirdageopen.service.BlogCommentService;
import com.thirdageopen.service.BlogService;
import com.thirdageopen.service.UserService;


@Controller
@RequestMapping(value = "/api/blog")
public class BlogApi {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogCommentService blogCommentService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value="/all")
	@ResponseBody
	public BlogModel getAll(){
		BlogModel model = new BlogModel();
		model.setUrl("all");
		model.setItems(blogService.retrieve());
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value="/article/{id}")
	@ResponseBody
	public Blog getArticle(@PathVariable(value = "id") Integer id){
		return blogService.getArticle(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value="/developer")
	@ResponseBody
	public BlogModel getDeveloper(){
		BlogModel model = new BlogModel();
		model.setUrl("developer");
		model.setItems(blogService.getDeveloperBlog());
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value="/news")
	@ResponseBody
	public BlogModel getNews(){
		BlogModel model = new BlogModel();
		model.setUrl("news");
		model.setItems(blogService.getNewsBlog());
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/write")
	@ResponseBody
	public APIResponseModel createBlog(@RequestBody WriteBlogModel writeBlogModel){
		Blog blog = new Blog();
		blog.setOutput(writeBlogModel.getOutput());
		blog.setCategory(writeBlogModel.getCategory());
		blog.setCreatedAt(new Date());
		blog.setCreatedBy(userService.getCurrentUser());
		blog.setTitle(writeBlogModel.getTitle());
		blogService.create(blog);
		return new APIResponseModel(true);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	@ResponseBody
	public APIResponseModel editBlog(@RequestBody EditBlogModel editBlogModel){
		Blog blog = blogService.getArticle(editBlogModel.getId());
		blog.setOutput(editBlogModel.getOutput());
		blog.setTitle(editBlogModel.getTitle());
		blogService.update(blog);
		return new APIResponseModel(true);
	} 
	
	@RequestMapping(method = RequestMethod.POST, value="/comment")
	@ResponseBody
	public APIResponseModel commentBlog(@RequestBody CommentBlogModel commentBlogModel) {
		BlogComment blogComment = new BlogComment();
		blogComment.setBlogId(commentBlogModel.getBlogId());
		blogComment.setOutput(commentBlogModel.getOutput());
		blogComment.setCreatedBy(userService.getCurrentUser());
		blogComment.setCreatedAt(new Date());
		blogCommentService.create(blogComment);
		return new APIResponseModel(true);
	}

}
