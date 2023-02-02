package com.dominos.pilot_3.service.redis;

import com.dominos.pilot_3.domain.redis.IntegratedLog;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPubService {
    private final RedisTemplate<String, IntegratedLog> integratedLogRedisTemplate;

    public void sendMessage(IntegratedLog integratedLog) {
        integratedLogRedisTemplate.convertAndSend("ScriptKafkaLog", integratedLog);
    }
}
