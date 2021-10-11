package com.example.consumer.service;

import com.example.consumer.data.Payment;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final KafkaTemplate<String, Payment> template;

    public void process(Payment payment) {
        final ListenableFuture<SendResult<String, Payment>> future = template.send(
                new ProducerRecord<>("processed", "ibank", payment));
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, Payment> result) {
                logger.info(result);
            }
        });
    }
}
