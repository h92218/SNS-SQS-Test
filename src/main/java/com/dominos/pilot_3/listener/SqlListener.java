package com.dominos.pilot_3.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqlListener {
    @SqsListener(value = "MyQueue2", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void listen(@Payload String sst, Acknowledgment ack) {
        log.info("{}", sst);
        ack.acknowledge();
    }
}
