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
public class Sender {
	@Value("${mq.config.exchage}")
	private String exchange;
	@Value("${mq.config.queue.error.routing.key}")
	private String routingkey;
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void sendEntity(User user) {
		/*
		 * param1:exchange
		 * param2:routingkey
		 * param2:msg
		 */
		amqpTemplate.convertAndSend(exchange,routingkey,user);//消息队列名称 消息
	}
}
