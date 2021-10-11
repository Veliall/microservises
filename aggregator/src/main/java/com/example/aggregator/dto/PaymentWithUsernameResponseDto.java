package com.example.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentWithUsernameResponseDto {
    private long id;
    private long senderId;
    private String senderUsername;
    private String senderCardNumber;
    private String addresseeCardNumber;
    private long amount;
    private String comment;
}
