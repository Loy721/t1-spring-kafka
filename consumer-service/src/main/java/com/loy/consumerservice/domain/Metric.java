package com.loy.consumerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash
public class Metric {
    private String name;
    private Map<String, Double> stats;
}
