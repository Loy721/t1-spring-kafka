package com.loy.consumerservice.repository;

import com.loy.consumerservice.domain.Metric;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository
public class MetricRepository {

    private static final String METRIC_KEY = "metric";

    private final HashOperations<String, String, Map<String, Double>> opsForHash;


    public MetricRepository(RedisTemplate<String, Metric> redisTemplate) {
        opsForHash = redisTemplate.opsForHash();
    }

    public Metric save(Metric metric) {
        opsForHash.put(METRIC_KEY, metric.getName(), metric.getStats());
        return metric;
    }

    public Metric findMetricByName(String name) {
        Map<String, Double> stats = opsForHash.get(METRIC_KEY, name);
        return new Metric(name, stats);
    }

    public Set<String> getAllNames() {
        return opsForHash.keys(METRIC_KEY);
    }
}
