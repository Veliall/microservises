package com.example.producer.dto;

import com.example.producer.validation.AllowedCardNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentRequestDto {
    private long senderId;
    @AllowedCardNumber
    private String senderCardNumber;
    @AllowedCardNumber
    private String addresseeCardNumber;
    @Min(1)
    private long amount;
    private String comment;
}
