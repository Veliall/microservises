package com.example.consumer;

import com.example.consumer.data.Payment;
import com.example.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaConsumerApplication {
  private final Log logger = LogFactory.getLog(this.getClass());
  private final ConsumerService consumerService;

  @Bean // Kafka Admin
  public NewTopic processedTopic() {
    return new NewTopic("processed", 3, (short) 2);
  }

  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerApplication.class, args);
  }

  @KafkaListener(groupId = "consumer", topics = "payments")
  public void listen(Payment message, ConsumerRecord<String, Payment> record, Acknowledgment acknowledgment) {
    logger.info(message);
    consumerService.process(message);
    acknowledgment.acknowledge();
  }

}
