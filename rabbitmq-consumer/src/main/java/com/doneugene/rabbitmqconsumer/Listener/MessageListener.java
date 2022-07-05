package com.doneugene.rabbitmqconsumer.Listener;

/**
 * @Author: Don Eugene
 * ***************Highly Freeeeeeeee******************
 */

import com.doneugene.rabbitmqconsumer.Message.CustomMessage;
import com.doneugene.rabbitmqconsumer.config.QueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {


    /*  Consume Data From RabbitMQ Queue  */
    @RabbitListener(queues = QueueConfig.QUEUE)
    public void consumeCustomMessage(CustomMessage message){
        log.info("About to consume some data -> {}", message.getMessage());
        System.out.println("Message Received " + message);
    }

}
