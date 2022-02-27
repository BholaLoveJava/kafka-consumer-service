package com.sapient.web.configuration;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sapient.web.model.EmployeeModel;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,String> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(consumerFactory());
        return listenerContainerFactory;
    }

    @Bean
    public ConsumerFactory<String, EmployeeModel> employeeModelConsumerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_json");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new org.springframework.kafka.support.serializer.JsonDeserializer<>(EmployeeModel.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,EmployeeModel> employeeModelConcurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,EmployeeModel> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(employeeModelConsumerFactory());
        return listenerContainerFactory;
    }
}
