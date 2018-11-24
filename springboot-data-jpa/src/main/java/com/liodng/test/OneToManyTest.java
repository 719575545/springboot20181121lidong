package com.liodng.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liodng.App;
import com.liodng.dao.UserCrudRep;
import com.liodng.dao.UserRep;
import com.liodng.pojo.Role;
import com.liodng.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class OneToManyTest {
	@Autowired
	private UserCrudRep userCrudRep;
	@Test
	public void test1() {
		User user=new User();
		user.setAddress("beijing");
		user.setAge(89);
		user.setName("zhangqiling");
		Role role=new Role();
		role.setRolename("arole");
		role.getUsers().add(user);
		user.setRole(role);
		userCrudRep.save(user);
	}
	@Test
	public void test2() {
		User user=userCrudRep.findOne(8);
		System.out.println(user);
		Role role = user.getRole();
		System.out.println(role.getRolename());
	}
}
