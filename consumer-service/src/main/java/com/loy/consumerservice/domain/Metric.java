package com.loy.consumerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class Metric {
    @Id
    private String name;
    private Map<String, Double> stats;
}
