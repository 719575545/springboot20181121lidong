package com.liodng.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liodng.App;
import com.liodng.dao.UserCrudRep;
import com.liodng.dao.UserJpaRep;
import com.liodng.dao.UserPSRep;
import com.liodng.dao.UserReoQuery;
import com.liodng.dao.UserRep;
import com.liodng.dao.UserSpecifictionExecutorRep;
import com.liodng.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserRepTest {
	@Autowired
	private UserJpaRep userJpaRep;
	@Autowired
	private UserRep userRep; 
	@Autowired
	private UserReoQuery userRepq;
	@Autowired
	private UserCrudRep userCrudRep;
	@Autowired
	private UserPSRep userPSRep;
	@Autowired
	private UserSpecifictionExecutorRep userSpecifictionExecutorRep;
	@Test
	public void userRepTest() {
		User user=new User();
		user.setAddress("beijing");
		user.setAge(80);
		user.setName("father");
		userJpaRep.save(user);
		Order order=new Order(Direction.DESC, "id");
		Sort sort=new Sort(order);
		Pageable page=new PageRequest(0, 2, sort);
		Page<User> users=userJpaRep.findAll(page);
		for (User user2 : users) {
			System.out.println(user2.toString());
		}
	}
	@Test
	public void findTest() {
		List<User> users1=userRep.findByName("huge");
		for (User user : users1) {
			System.out.println(user.toString());
		}
		List<User> users2=userRep.findByNameAndAge("huge",24);
		for (User user : users2) {
			System.out.println(user.toString());
		}
	}
	@Test
	public void likeTest() {
		/**
		 * h%表示以h开头
		 * %h表示以h结尾
		 * %h%表示包含h的
		 */
		List<User> users=userRep.findByNameLike("h%");
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
	@Test
	public void testQuery() {
		List<User> users=userRepq.findByNameHql("huge");
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
	@Test
	public void testQuerySql() {
		List<User> users=userRepq.findByNameSql("huge");
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
	@Test
	@Transactional //如果只有Test与Transactional配合使用的话事务会自动回滚，所以执行之后只看见语句，但是数据库没更新
	@Rollback(false)//取消回滚，此时事务不会自动回滚
	public void testQueryUp() {
		userRepq.updateUserNameById("你大爷",1);
	}
	@Test
	public void testCrudRep() {
		Iterable<User> users=userCrudRep.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		User user=new User();
		user.setAddress("hangzhou");
		user.setAge(13);
		user.setName("sfdjf");
		userCrudRep.save(user);
	}
	//测试排序
	@Test
	public void testUserPSRep() {
		Order order=new Order(Direction.DESC,"id");
		Sort sort=new Sort(order);
		List<User> users=(List<User>)userPSRep.findAll(sort);
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
	//测试分页
	@Test
	public void testUserPSRepp() {
		Order order=new Order(Direction.DESC,"id");//排序加分页
		Sort sort=new Sort(order);
		Pageable pageable=new PageRequest(0, 2,sort);//第一个参数 当前页 从0开始，第二个参数 每页显示的条数
		Page<User> users=userPSRep.findAll(pageable);
		System.out.println(users.getTotalElements());//总条数
		System.out.println(users.getTotalPages());//总页数
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
	//测试specificationExecutor
	@Test
	public void testUserSpecificationRep() {
		/**
		 * Specification<User> 用于封装查询条件
		 */
		Specification<User> spec=new Specification<User>() {
			/**
			 * Root<User> arg0 查询对象属性的封装
			 * CriteriaQuery<?> arg1 封装了我们要执行查询的各个部分的信息 select from order
			 * CriteriaBuilder arg2 查询条件的构造器，定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<User> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				/**
				 * 参数一：查询条件属性
				 * 参数二：属性的值
				 */
				//Predicate	pre=arg2.equal(arg0.get("name"),"lidong");//单条件的
				//以下是多条件的第一种写法
//				List<Predicate> list=new ArrayList<Predicate>();//将两个predicate放入list中
//				list.add(arg2.equal(arg0.get("age"),22));
//				list.add(arg2.equal(arg0.get("name"),"lidong"));
//				list.add(arg2.equal(arg0.get("address"),"paris"));
//				Predicate[] arr=new Predicate[list.size()];//创建一个predicate的数组
				//多条件的第二种写法
				
				return arg2.or(arg2.equal(arg0.get("name"),"lidong"),arg2.equal(arg0.get("age"),80));//将list转换为数组
			}
		};
		Order order=new Order(Direction.DESC,"id");
		Sort sort=new Sort(order);
		Pageable pageable=new PageRequest(0, 2,sort);
		Page<User> users=userSpecifictionExecutorRep.findAll(spec,pageable);
		System.out.println(users.getTotalElements());//总条数
		System.out.println(users.getTotalPages());//总页数
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
}
