package com.dominos.pilot_3.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;


@Service
public class SqsService {
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SqsService(AmazonSQS amazonSqs) {
        this.queueMessagingTemplate = new QueueMessagingTemplate((AmazonSQSAsync) amazonSqs);
    }

    public void getMessage() {
        String rr = queueMessagingTemplate.receiveAndConvert("MyQueue2", String.class);
        System.out.println("queue message :: " + rr );

    }
}
