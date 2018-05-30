package com.chen.longhai.sbjpa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chen.longhai.sbjpa.entity.CUser;
import com.chen.longhai.sbjpa.repository.CUserRepository;

@RestController
public class HelloController {
	
	@Autowired
	private CUserRepository cuserRepository;
	
	@RequestMapping(value="/hello",method =RequestMethod.GET )
    public String hello() {
		System.out.println(new CUser());
		
		return "hello";
	}
   
	/**
	 * 查找所有用户
	 * @return
	 */
	@GetMapping(value="userlist")
	public List<CUser>userlist(){
		return cuserRepository.findAll();
	}
	/**
	 * 获取一个用户
	 * @param id
	 * @return
	 */
	@GetMapping(value="/getuser")
	public CUser userById(@RequestParam("id") Integer id) {
		return cuserRepository.getOne(id);
	}
	
	
	
	
	
	
	
	
}
