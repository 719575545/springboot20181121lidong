package com.lidong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lidong.rabbitmq.Sender;
import com.lidong.rabbitmq.SpringfastbootApplication;
import com.lidong.rabbitmq.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringfastbootApplication.class)
public class QueueTest {
	@Autowired
	private Sender sender;
	@Test
	public void test2Queue() {
		User user=new User();
		user.setAddress("beijing");
		user.setName("lidong");
		user.setAge(18);
		user.setId(1);
		sender.sendEntity(user);
	}
}
