//package com.loy.consumerservice.service.impl;
//
//import com.loy.consumerservice.service.MetricsService;
//import lombok.RequiredArgsConstructor;
//import org.apache.kafka.common.protocol.types.Field;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ZSetOperations;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class MetricAvgAggregationService {
//
//    private final MetricsService metricsService;
//
//    private final RedisTemplate<String, Map<String, Map<String, Double>>> redisTemplate;
//
//    private static final String METRICS_KEY = "avg-metrics";
//
//    public List<Map<String, Map<String, Double>>> getAvgMetrics() {
//        Set<String> keys = redisTemplate.keys("avg-metrics:*");
//
//        // Получаем все значения по этим ключам
//        return keys.stream()
//                .map(key -> redisTemplate.opsForValue().get(key))
//                .collect(Collectors.toList());
//    }
//}
