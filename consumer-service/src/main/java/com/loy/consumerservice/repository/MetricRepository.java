package com.loy.consumerservice.repository;

import com.loy.consumerservice.domain.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MetricRepository {

    public static final String METRIC_KEY = "metric";

    private final RedisTemplate<String, Metric> redisTemplate;

    public Metric save(Metric metric) {
        redisTemplate.opsForHash().put(METRIC_KEY, metric.getName(), metric.getStats());
        return metric;
    }

    public Metric findMetricByName(String name) {
        return  (Metric) redisTemplate.opsForHash().get(METRIC_KEY, name);
    }
}
