package com.hanains.jblog.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanains.jblog.service.UserService;
import com.hanains.jblog.vo.UserVo;


@Controller("userApiController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Response body 를 붙여줘야 한다. 메시지 컨버터.
	
	@ResponseBody
	@RequestMapping("/checkId")
	public Object checkId(@RequestParam(value="id",required=true,defaultValue="")String id){
		
		System.out.println("AJAX ID: "+id);
		
		UserVo vo = userService.getUserById(id);
		System.out.println("USERVO: "+vo);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("result","success"); // success or fail
		map.put("message",null); // 실패시 실패 메세지 
		map.put("data",vo==null); // vo가 없으면 사용가능한 이메일
		return map;
	}
}
