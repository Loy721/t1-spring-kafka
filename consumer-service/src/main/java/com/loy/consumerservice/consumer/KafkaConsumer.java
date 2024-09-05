package com.loy.consumerservice.consumer;

import com.loy.consumerservice.domain.Metric;
import com.loy.consumerservice.repository.MetricRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MetricRepository metricRepository;


    @RetryableTopic
    @KafkaListener(id = "mainGroup", topics = "topic")
    public void listenMetricsTopic(Metric metrics, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Received from topic: '{}', message: {}", topic, metrics);
        metricRepository.save(metrics);
    }

    @DltHandler
    public void dltListener(String in, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset) {
        log.info("Received from DLT: {}, topic: {}, offset: {}", in, topic, offset);
    }
}
