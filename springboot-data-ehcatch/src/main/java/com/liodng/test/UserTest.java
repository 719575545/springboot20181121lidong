package com.liodng.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liodng.App;
import com.liodng.dao.UserRep;
import com.liodng.pojo.User;
import com.liodng.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserTest {
	@Autowired
	private UserService userService;
	@Test
	public void test1() {
		User user1 = userService.findByid(2);
		System.out.println(user1.toString());
		User user2= userService.findByid(2);
		System.out.println(user2.toString());
	}
	@Test
	public void test2() {
		Pageable pageable=new PageRequest(0, 2);
		System.out.println(userService.findByPage(pageable));
		System.out.println(userService.findByPage(pageable));
		pageable=new PageRequest(1, 2);
		System.out.println(userService.findByPage(pageable));
	}
	@Test
	public void test3() {
		Pageable pageable=new PageRequest(0, 2);
		System.out.println(userService.findByPage(pageable).getTotalElements());
		System.out.println(userService.findByPage(pageable).getTotalElements());
		User user=new User();
		user.setAddress("hangzhou");
		user.setAge(89);
		user.setName("zhangdaxian");
		this.userService.saveUser(user);
		System.out.println(userService.findByPage(pageable).getTotalElements());
	}
}
