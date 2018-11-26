package com.lidong.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.lidong.rabbitmq.pojo.User;

/**
 * 消息接受者
 * @author lidong
 *
 */
@Component
@RabbitListener(
			bindings=@QueueBinding(value=@Queue(value="${mq.config.queue.info}",autoDelete="true"),
			exchange=@Exchange(value="${mq.config.exchage}",type=ExchangeTypes.DIRECT),key="${mq.config.queue.info.routing.key}"
			)
		)
public class InfoReceiver {
	@RabbitHandler
	public void process(User user) throws InterruptedException {
		while(true) {
			Thread.sleep(1000);
			System.out.println("info"+user);
		}
	}
}
