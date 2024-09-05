package com.loy.producerservice.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
@Slf4j
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return new NewTopic("topic", 1, (short) 1);
    }

}
