package com.loy.consumerservice.api.impl;

import com.loy.consumerservice.api.MetricController;
import com.loy.consumerservice.domain.Metric;
import com.loy.consumerservice.service.MetricsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/metrics")
@Slf4j
@RequiredArgsConstructor
public class MetricControllerImpl implements MetricController {

    private final MetricsService metricsService;

    @GetMapping
    public Set<String> getAll() {
        return metricsService.getAllMetricNames();
    }

    @GetMapping("/{id}")
    public Metric getMetric(@PathVariable String id) {
        return metricsService.getMetricByName(id);
    }
}
