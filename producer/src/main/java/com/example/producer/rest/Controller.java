package com.example.producer.rest;


import com.example.producer.dto.PaymentRequestDto;
import com.example.producer.dto.PaymentResponseDto;
import com.example.producer.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class Controller {
    private final PaymentsService paymentsService;

    @PostMapping("/payments")
    public PaymentResponseDto register(@RequestBody @Valid PaymentRequestDto payment) {
        return paymentsService.register(payment);
    }
}
