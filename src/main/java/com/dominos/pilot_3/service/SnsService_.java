package com.dominos.pilot_3.service;

import com.dominos.pilot_3.config.AWSSnsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class SnsService_ {
    private final AWSSnsConfig awsConfig;

    public void awsSnsPublish(Map<String,Object> scriptData) {
        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(awsConfig.getSnsTopicARN())
                .subject("HTTP ENDPOINT TEST MESSAGE")
                .message(scriptData.toString())
                .build();

        log.info("#### data :: " + scriptData.toString());

        SnsClient snsClient = awsConfig.getSnsClient();
        PublishResponse publishResponse = snsClient.publish(publishRequest);
        log.info("##### response message status :: " + publishResponse.sdkHttpResponse().statusCode());
        log.info("##### response message ID :: " + publishResponse.messageId());
        snsClient.close();
    }
}
