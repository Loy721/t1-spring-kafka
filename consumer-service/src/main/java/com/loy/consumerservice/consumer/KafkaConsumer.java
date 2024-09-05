package com.loy.consumerservice.consumer;

import com.loy.consumerservice.domain.Metric;
import com.loy.consumerservice.repository.MetricRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.backoff.FixedBackOff;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MetricRepository metricRepository;

    //@RetryableTopic(attempts = "2")
    @KafkaListener(id = "mainGroup", topics = "topic")
    public void listenMetricsTopic(Metric metrics) {
        if (metrics.getName().equals("jvm.memory.max"))
            throw new RuntimeException("dffs");
        log.info("Received: {}", metrics);
        metricRepository.save(metrics);
    }

    //    @DltHandler
//    public void  dltListener(Metric metrics) {
//        log.info("dlt");
//    }
    @KafkaListener(id = "dltGroup", topics = "topic.DLT")
    public void dltListener(Metric metrics) {
        log.info("dlt+");
    }
}
