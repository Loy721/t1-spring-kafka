package com.loy.producerservice.config;

import com.loy.producerservice.domain.Metric;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.mapping.Jackson2JavaTypeMapper;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class KafkaConfig {
    @Bean
    public StringJsonMessageConverter jsonConverter() {
        StringJsonMessageConverter converter = new StringJsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
        Map<String, Class<?>> classMap = new HashMap<>();
        classMap.put("metric", Metric.class);
        typeMapper.setIdClassMapping(classMap);
        converter.setTypeMapper(typeMapper);
        return converter;
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("topic", 1, (short) 1);
    }

}
