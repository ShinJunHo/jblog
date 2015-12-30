package com.hanains.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.jblog.dao.UserDao;
import com.hanains.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public void join(UserVo vo){
		userDao.register(vo);
	}
	
	
	
	public UserVo login(UserVo vo){
		UserVo authUser = userDao.getVoByidAndPassword(vo);
		return authUser;			
				
	}
	public List<UserVo> getList(){
		List<UserVo> list = userDao.getList();
		return list;
	}
}
