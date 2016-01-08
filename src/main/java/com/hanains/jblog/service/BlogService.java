package com.hanains.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.jblog.dao.BlogDao;
import com.hanains.jblog.dao.CategoryDao;
import com.hanains.jblog.dao.CommentsDao;
import com.hanains.jblog.dao.PostDao;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.PostVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private PostDao postDao;

	@Autowired
	private CommentsDao commentsDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Map<String,Object> getList(String id){
		
		Map<String, Object>map= new HashMap<String,Object>();
		map.put("blog", blogDao.getView(id));
		map.put("post", postDao.getList(id));
		map.put("comments",commentsDao.getList());
		map.put("category",categoryDao.getList(id));
		
		return map;
	}
	public List<BlogVo> getBlogList(String keyword, String searchCondition){
		List<BlogVo> list = blogDao.getBlogList(keyword,searchCondition);
		return list;
	}
	public BlogVo getView(String id){
		
		return blogDao.getView(id);
	}
	public void insert(PostVo vo){
		postDao.insert(vo);
	}
	public Map<String,Object> getPostByNo(Long no){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("blog", blogDao.getTitleByNo(no));
		map.put("post",postDao.getPostByNo(no));
		map.put("comments", commentsDao.getCommentsByNo(no));
		System.out.println("comments ::"+commentsDao.getCommentsByNo(no));
		return map;
	}
	public void update(){
		
	}
}
