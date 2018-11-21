package com.lidong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page) {
		System.out.println("sdf很个房间风格fsdfsfs");
		return page;
	}
}
