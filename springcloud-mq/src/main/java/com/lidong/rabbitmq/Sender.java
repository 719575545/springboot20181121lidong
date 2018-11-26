package com.lidong.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lidong.rabbitmq.pojo.User;
/**
 * 消息发送者
 * @author lidong
 *
 */
@Component
public class Sender {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(String msg) {
		amqpTemplate.convertAndSend("hello-queue", msg);//消息队列名称 消息
	}
	public void sendEntity(User user) {
		amqpTemplate.convertAndSend("hello-queue", user);//消息队列名称 消息
	}
}
