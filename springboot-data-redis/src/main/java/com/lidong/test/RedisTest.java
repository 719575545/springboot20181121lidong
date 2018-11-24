package com.lidong.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lidong.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {
	@Autowired
	private RedisTemplate<String, Object> RedisTemplate;
	@Test
	public void testRedisTemplate1() {
		RedisTemplate.opsForValue().set("lidong", "lidong");
	}
	@Test
	public void testRedisTemplate2() {
		String value =(String) RedisTemplate.opsForValue().get("key");
		System.out.println(value);
	}

}
