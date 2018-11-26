package com.lidong.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.lidong.rabbitmq.pojo.User;

/**
 * 消息接受者
 * @author lidong
 *
 */
@Component
public class Receiver {
//	@RabbitListener(queues="hello-queue")
//	public void process(String msg) {
//		System.out.println(msg);
//	}
	@RabbitListener(queues="hello-queue")
	public void process(User user) {
		System.out.println(user);
	}
}
