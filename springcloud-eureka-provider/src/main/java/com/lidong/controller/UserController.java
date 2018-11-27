package com.lidong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lidong.user.User;

@RestController
public class UserController {
	@RequestMapping("/users")
	public List<User> getUsers(){
		List<User> users=new ArrayList<User>();
		users.add(new User("lidong",24,"beijing"));
		users.add(new User("lihong",24,"shanghai"));
		users.add(new User("liqiang",24,"hangzhou"));
		users.add(new User("liling",24,"tianjin"));
		return users;
	}

}
