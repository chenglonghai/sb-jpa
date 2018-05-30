package com.chen.longhai.sbjpa.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestWebController {
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		request.setAttribute("username", "李四");
		return "index";
	}
	
}
