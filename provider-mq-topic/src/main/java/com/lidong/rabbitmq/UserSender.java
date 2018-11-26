package com.lidong.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lidong.rabbitmq.pojo.User;
/**
 * 消息发送者
 * @author lidong
 *
 */
@Component
public class UserSender {
	@Value("${mq.config.exchage}")
	private String exchange;
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void sendEntity(User user) {
		/*
		 * param1:exchange
		 * param2:routingkey
		 * param2:msg
		 */
		amqpTemplate.convertAndSend(exchange,"user.log.debug",user);//消息队列名称 消息
		amqpTemplate.convertAndSend(exchange,"user.log.info",user);//消息队列名称 消息
		amqpTemplate.convertAndSend(exchange,"user.log.warning",user);//消息队列名称 消息
		amqpTemplate.convertAndSend(exchange,"user.log.error",user);//消息队列名称 消息
	}
}
