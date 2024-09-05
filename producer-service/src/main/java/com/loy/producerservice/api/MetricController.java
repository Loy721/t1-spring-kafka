package com.loy.producerservice.api;

import com.loy.producerservice.domain.Metric;
import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MetricController {

    private final KafkaTemplate<Object, Object> template;
    private final MeterRegistry meterRegistry;

    @PostMapping("/metrics")
    public void sendMetrics() {

        //meterRegistry.getMeters().stream().forEach(m -> metricsMap.put(m.getId().getName(), m.measure()));
        for (Meter meter : meterRegistry.getMeters()) {
            Metric metric = meterToMetric(meter);
            CompletableFuture<SendResult<Object, Object>> future = template.send("topic", metric);
            future.whenComplete((key, value) -> log.info("message wiht key: {} and value: {} is sanding", key, value));//TODO
        }
    }

    private Metric meterToMetric(Meter meter) {
        String meterName = meter.getId().getName();
        Map<String, Double> measurements = new HashMap<>();
        for (Measurement measurement : meter.measure())
            measurements.put(measurement.getStatistic().name(), measurement.getValue());
        return new Metric(meterName, measurements);
    }
}
