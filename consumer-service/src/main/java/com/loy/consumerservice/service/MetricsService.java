package com.loy.consumerservice.service;

import com.loy.consumerservice.domain.Metric;

import java.util.Set;

public interface MetricsService {

    Set<String> getAllMetricNames();


    Metric getMetricByName(String id);
}
