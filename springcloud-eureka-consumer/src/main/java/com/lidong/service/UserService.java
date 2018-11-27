package com.lidong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lidong.user.User;

@Service
public class UserService {
	@Autowired
	private LoadBalancerClient loadBalancerClient;//注入ribbon负载均衡器
	public List<User> getUser(){
		//ServiceInstance封装了基本信息，如ip，端口等等
		ServiceInstance si=loadBalancerClient.choose("eureka-provider");//获取到服务实例，参数为服务提供方的配置文件配置的服务名
		//拼接http 链接   http://localhost:9090/users
		StringBuffer sb=new StringBuffer();
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/users");
		//springmvc Resttempate
		RestTemplate rt=new RestTemplate();
		ParameterizedTypeReference<List<User>> type=new ParameterizedTypeReference<List<User>>() {};
		//参数1 请求的url 2请求方式 3 请求的参数 4请求返回的数据用什么包装
		 ResponseEntity<List<User>> responseEntity=rt.exchange(sb.toString(),HttpMethod.GET, null, type);
		 List<User> users=responseEntity.getBody();
		return users;
	}
}
