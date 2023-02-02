package com.dominos.pilot_3.controller;

import com.amazonaws.services.sqs.model.Message;
import com.dominos.pilot_3.service.SnsService;
import com.dominos.pilot_3.service.SnsService_;
import com.dominos.pilot_3.service.SqsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.sns.model.PublishResponse;

import java.util.Map;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("pilot-api")
public class SnsController {
    private final SnsService snsService;
    private final SqsService sqsService;

    @PostMapping("/publish")
    public void publish(@RequestBody Map<String, Object> scriptData) {
        PublishResponse pr = snsService.awsSnsPublishTest(scriptData);
        System.out.println(pr);

    }

    @GetMapping("/subscribe")
    public void getMessage() {
        sqsService.getMessage();
    }
}
