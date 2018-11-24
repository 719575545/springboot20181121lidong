package com.liodng.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.liodng.pojo.User;

public interface UserReoQuery extends Repository<User, Integer> {
	@Query("from User where name=?")
	public List<User> findByNameHql(String name);
	/**
	 * nativeQuery 默认值为false，则使用hql，为true的话使用sql
	 * @param name
	 * @return
	 */
	@Query(value="select * from user where name=?",nativeQuery=true)
	public List<User> findByNameSql(String name); 
	@Query("update User set name = ? where id=?")
	@Modifying //表示此时执行的是更新操作
	public void updateUserNameById(String name,Integer id);
}
