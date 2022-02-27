package com.sapient.web.listeners;

import com.sapient.web.model.EmployeeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics="kafka_example", groupId = "group_id")
    public void consume(String message){
        logger.info("Message Consumed Successfully :: "+message);
    }

    @KafkaListener(topics="kafka_model_json", groupId = "group_json",containerFactory = "employeeModelConcurrentKafkaListenerContainerFactory")
    public void consume(EmployeeModel employeeData){
        logger.info("Message Consumed Successfully :: "+employeeData);
    }
}
