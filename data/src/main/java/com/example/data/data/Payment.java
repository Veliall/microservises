package com.example.data.data;

import lombok.*;

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
