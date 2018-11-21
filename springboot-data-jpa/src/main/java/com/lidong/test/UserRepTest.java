package com.lidong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lidong.App;
import com.lidong.dao.UserRep;
import com.lidong.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserRepTest {
	@Autowired
	private UserRep userRep;
	@Test
	public void test() {
		User user=new User();
		user.setAddress("paris");
		user.setAge(22);
		user.setName("lidong");
		userRep.save(user);
	}
}
