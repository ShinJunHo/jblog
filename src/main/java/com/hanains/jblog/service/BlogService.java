package com.hanains.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.jblog.dao.BlogDao;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	

}
