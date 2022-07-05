package com.doneugene.rabbitmqproducer.Publisher;

/**
 * @Author: Don Eugene
 * ***************Highly Freeeeeeeee******************
 */

import com.doneugene.rabbitmqproducer.Message.CustomMessage;
import com.doneugene.rabbitmqproducer.config.QueueConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;


    /*  Publish Data To RabbitMQ Queue  */
    @PostMapping(value = "/publishMessage")
    public String publishMessage(@RequestBody CustomMessage message){

        log.info("Inside Publish Message Controller!");
        /*  Set Msg ID and Date   */
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(QueueConfig.EXCHANGE,  QueueConfig.ROUTING_KEY, message);

        /*  Return Success After Message Successfully Published   */
        return "Message Published to RabbitMQ!";
    }
}
