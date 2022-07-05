package com.doneugene.rabbitmqproducer.Message;

/**
 * @Author: Don Eugene
 * ***************Highly Freeeeeeeee******************
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomMessage {

    private String messageId;
    private String message;
    private Date messageDate;

}
