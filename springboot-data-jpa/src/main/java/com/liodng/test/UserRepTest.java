package com.liodng.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liodng.App;
import com.liodng.dao.UserRep;
import com.liodng.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserRepTest {
	@Autowired
	private UserRep useRep;
	@Test
	public void userRepTest() {
		User user=new User();
		user.setAddress("nayong");
		user.setAge(24);
		user.setName("huge");
		useRep.save(user);
	}
}
