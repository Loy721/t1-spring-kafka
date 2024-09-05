package com.loy.consumerservice.service.impl;

import com.loy.consumerservice.domain.Metric;
import com.loy.consumerservice.repository.MetricRepository;
import com.loy.consumerservice.service.MetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RedisMetricsService implements MetricsService {

    private final MetricRepository metricRepository;

    @Override
    public Metric getMetricByName(String name) {
        return metricRepository.findMetricByName(name);
    }

    @Override
    public Set<String> getAllMetricNames() {
        return metricRepository.getAllNames();
    }
}
