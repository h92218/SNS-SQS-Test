package com.dominos.pilot_3.controller;

import com.dominos.pilot_3.domain.redis.IntegratedLog;
import com.dominos.pilot_3.service.redis.RedisPubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor // final로 선언된 생성자 주입해주는 어노테이션
@RequestMapping("pilot-api")
public class RedisController {
    private final RedisPubService redisPubService;

    @PostMapping(value = "/integratedLog")
    public String pubSend(@RequestBody IntegratedLog integratedLog) {
        // 메세지 보내기
        redisPubService.sendMessage(integratedLog);
        return "success";
    }
}
