package com.example.producer.service;

import com.example.producer.data.Payment;
import com.example.producer.dto.PaymentRequestDto;
import com.example.producer.dto.PaymentResponseDto;
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
public class PaymentsService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final KafkaTemplate<String, Payment> template;

    public PaymentResponseDto register(PaymentRequestDto payment) {
        final ListenableFuture<SendResult<String, Payment>> future = template.send(
                new ProducerRecord<>("payments", "ibank", new Payment(
                        payment.getSenderId(),
                        payment.getSenderCardNumber(),
                        payment.getAddresseeCardNumber(),
                        payment.getAmount(),
                        payment.getComment()
                )));
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
        return new PaymentResponseDto(
                payment.getSenderId(),
                payment.getSenderCardNumber(),
                payment.getAddresseeCardNumber(),
                payment.getAmount(),
                payment.getComment());
    }
}
