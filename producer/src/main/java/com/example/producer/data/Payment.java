package com.example.producer.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment implements Payload {
  private long senderId;
  private String senderCardNumber;
  private String addresseeCardNumber;
  private long amount;
  private String comment;
}
