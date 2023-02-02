package com.dominos.pilot_3.service;


import com.dominos.pilot_3.config.AWSSnsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SnsService {
    private final AWSSnsConfig awsConfig;

    public PublishResponse awsSnsPublishTest(Map<String,Object> scriptData) {
        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(awsConfig.getSnsTopicARN())
                .subject("TEST 제목")
                .message(scriptData.toString())
                .build();

        SnsClient snsClient = awsConfig.getSnsClient();
        PublishResponse publishResponse = snsClient.publish(publishRequest);

        snsClient.close();
        return publishResponse;
    }
}