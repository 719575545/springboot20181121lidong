package com.lidong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lidong.App;
import com.lidong.service.UserService;

/**
 * springboot 测试类
 * @RunWith(SpringJUnit4ClassRunner.class):让junit与Spring环境进行整合
 * @SpringBootTest(classes= {App.class})两个含义：当前类为Springboot类  加载springboot启动类，启动springboot
 * 与junit与Spring整合时 @Contxtconfigration("classpath:applicationcontext.xml")相似，就是告诉测试类我这是Spring 环境的启动类，在启动测试的时候县启动spring
 * @author lidong
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {App.class})
public class SpringbootUnitTest {
	@Autowired
	private UserService userService;
	@Test
	public void test() {
		userService.saveUser();
	}
}
