package com.dominos.pilot_3.domain.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KafkaScriptDTO {
    private String session_id;
    private String user_id;
    private String page_code;
    private String goods;
    private String branch;
    private String data_no;
}
