package com.lidong.mapper;


import java.util.List;

import com.lidong.pojo.User;

public interface UserMapper {
	/**
	 * 添加用户
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 查询所有用户
	 */
	public List<User> getAllUser();
	/**
	 * 删除用户
	 * @param userid
	 */
	void deleteUserByid(Integer userid);
	/**
	 * 更新用户
	 */
	void updateUser(User user) ;
	/**
	 * 根据ID查询用户
	 */
	User selectByid(Integer id);
}
