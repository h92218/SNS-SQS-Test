package com.dominos.pilot_3.config;


import com.dominos.pilot_3.component.RedisClusterConfigurationProperties;
import com.dominos.pilot_3.domain.redis.IntegratedLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
@RequiredArgsConstructor

public class RedisConfig {


    @Autowired
    RedisClusterConfigurationProperties clusterProperties;


    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisClusterConfiguration redisConfig = new RedisClusterConfiguration ();
        clusterProperties.getNodes().forEach(s ->{
            String[] url = s.split(":");
            redisConfig.clusterNode(url[0],Integer.parseInt(url[1]));
        });
        redisConfig.setPassword("ehalsh!@#123");
        return new LettuceConnectionFactory(redisConfig);
    }

    @Primary
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        return redisTemplate;
    }

    // Log pub/sub 용 RedisTemplate 설정
    @Bean
    public RedisTemplate<String, IntegratedLog> integratedLogRedisTemplate() {
        RedisTemplate<String, IntegratedLog> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(IntegratedLog.class));
        return redisTemplate;
    }




}