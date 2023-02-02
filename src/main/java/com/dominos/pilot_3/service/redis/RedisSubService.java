package com.dominos.pilot_3.service.redis;

import com.dominos.pilot_3.domain.dto.KafkaScriptDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisSubService implements MessageListener {
    public static List<KafkaScriptDTO> messageList = new ArrayList<>();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            KafkaScriptDTO kafkaScriptDTO = mapper.readValue(message.getBody(), KafkaScriptDTO.class);
            messageList.add(kafkaScriptDTO);

            System.out.println("받은 메시지 = " + kafkaScriptDTO.toString());
            System.out.println("kafkaScriptDTO.getSession_id() = " + kafkaScriptDTO.getSession_id());
            System.out.println("kafkaScriptDTO.getUser_id() = " + kafkaScriptDTO.getUser_id());
            System.out.println("kafkaScriptDTO.getPage_code() = " + kafkaScriptDTO.getPage_code());
            System.out.println("kafkaScriptDTO.getGoods() = " + kafkaScriptDTO.getGoods());
            System.out.println("kafkaScriptDTO.getBranch() = " + kafkaScriptDTO.getBranch());
            System.out.println("kafkaScriptDTO.getData_no() = " + kafkaScriptDTO.getData_no());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
