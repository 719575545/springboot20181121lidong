package com.lidong.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 配置
 * @author lidong
 */
@Configuration
public class RedisConfig {
	/**
	 * 创建JedisPoolConfig对象 该对象配置了rdis的连接池配置
	 * @ConfigurationProperties 此注解会将配置文件里面前缀相同的属性封装成一个实体
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis.pool")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
		//最大空闲数
		jedisPoolConfig.setMaxIdle(10);
		//最小空闲数
		jedisPoolConfig.setMinIdle(5);
		//总的连接数
		jedisPoolConfig.setMaxTotal(20);
		return jedisPoolConfig;
	}
	/**
	 * 创建JedisConnectionFactory对象，配置redis的链接信息
	 */
	@Bean
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
		JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
		//配置连接池对象
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		//配置redis服务器所在的主机
		//jedisConnectionFactory.setHostName("localhost");
		//配置端口号
		//jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}
	/**
	 * 创建redisTemplate 封装了对jedis的一些操作api
	 *
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
		RedisTemplate<String, Object> redisTemplate=new RedisTemplate<String, Object>();
		//关联redis链接信息以及连接池对象
		redisTemplate.setConnectionFactory(jedisConnectionFactory); 
		//设置key序列化器
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//设置value序列化起器
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}
