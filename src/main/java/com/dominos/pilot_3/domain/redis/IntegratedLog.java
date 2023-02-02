package com.dominos.pilot_3.domain.redis;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class IntegratedLog {
    private String serverName;
    private String logLevel;
    private String context;
}
