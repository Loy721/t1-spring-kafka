package com.loy.consumerservice.config;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter(new JsonMapper());
    }
}
