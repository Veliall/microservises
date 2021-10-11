package com.example.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentsResponseDto {
  private long id;
  private long senderId;
  private String senderCardNumber;
  private String addresseeCardNumber;
  private long amount;
  private String comment;
}
