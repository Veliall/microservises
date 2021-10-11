package com.example.data;

import com.example.data.data.Payment;
import com.example.data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

@SpringBootApplication
@RequiredArgsConstructor
public class DataApplication {
  private final DataService dataService;
  private final Log logger = LogFactory.getLog(this.getClass());

  @KafkaListener(groupId = "data",topics = "processed")
  public void listen(Payment message, ConsumerRecord<String, Payment> record, Acknowledgment acknowledgment) {
    logger.info(message);
    dataService.save(message);
    acknowledgment.acknowledge();
  }

  public static void main(String[] args) {
    SpringApplication.run(DataApplication.class, args);
  }

}
