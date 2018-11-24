package com.liodng.service.impl;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.liodng.dao.UserRep;
import com.liodng.pojo.User;
import com.liodng.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRep userRep;
	@Override
	public List<User> findAll() {
		return userRep.findAll();

	}
/**
 * @Cacheable :把方法的返回值添加到ehcache缓存当中
 * 	value="user" ：自定义缓存的值，配置在ehcache.xml当中
 */
	@Override
	@Cacheable(value="user")
	public User findByid(Integer id) {
		
		return userRep.findOne(id);
	}
/**
 * key :指定放入缓存当中的key值，因为ehcache将对象放入缓存当中是会给对象一个key值，下次再查询如果是相同的key，直接从缓存当中去取值，
 * 以下的key写成了#pageable.pageSize，所以无论传递过来的pageable是什么，只要里面的pagsize值是一样的，也就是同一个key，就还是会走缓存
 */
	@Override
	@Cacheable(value="user",key="#pageable.pageSize")
	public Page<User> findByPage(Pageable pageable) {
		return userRep.findAll(pageable);
	}
/**
 * @CacheEvict:清除缓存当中对应缓存策略缓存的对象
 */
	@Override
	@CacheEvict(value="user",allEntries=true)
	public void saveUser(User user) {
		userRep.save(user);

	}

}
