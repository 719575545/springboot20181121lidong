package com.lidong.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hello {
	@RequestMapping("/hello")
	@ResponseBody
	public Map<String,String> lello(){
		Map<String,String> ll=new HashMap<String,String>();
		ll.put("lidong","lidong");
		return ll;
	}
}
