package com.example.aggregator.util;

import com.example.aggregator.dto.PaymentWithUsernameResponseDto;
import com.example.aggregator.dto.PaymentsResponseDto;

public class PaymentAndUserUtils {
    public static PaymentWithUsernameResponseDto bind(PaymentsResponseDto paymentsResponseDto, String name) {
        return new PaymentWithUsernameResponseDto(
                paymentsResponseDto.getId(),
                paymentsResponseDto.getSenderId(),
                name,
                paymentsResponseDto.getSenderCardNumber(),
                paymentsResponseDto.getAddresseeCardNumber(),
                paymentsResponseDto.getAmount(),
                paymentsResponseDto.getComment()
        );
    }
}
