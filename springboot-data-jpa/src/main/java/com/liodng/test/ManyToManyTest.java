package com.liodng.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liodng.App;
import com.liodng.dao.RoleJpaRep;
import com.liodng.pojo.Manu;
import com.liodng.pojo.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class ManyToManyTest {
	@Autowired
	private RoleJpaRep roleJpaRep;
	@Test
	public void test1() {
		//创建manu对象
		Manu manu1=new Manu();
		manu1.setManuname("xxxsysotem");
		manu1.setManuurl("/sfdf/fsd");
		manu1.setFatherid(0);
		Manu manu2=new Manu();
		manu2.setManuname("student");
		manu2.setManuurl("/sfdffsdf/fsdfsd");
		manu2.setFatherid(1);
		//创建role对象
		Role role=new Role();
		role.setRolename("rolename");
		//添加关联关系
		role.getManus().add(manu1);
		role.getManus().add(manu2);
		manu1.getRoles().add(role);
		manu2.getRoles().add(role);
		//保存
		this.roleJpaRep.save(role);
	}
	@Test
	public void test2() {
		Role role = this.roleJpaRep.findOne(2);
		Set<Manu> manus = role.getManus();
		System.out.println(role.getRolename());
		for (Manu manu : manus) {
			System.out.println(manu.getManuname());
		}
	}
}
