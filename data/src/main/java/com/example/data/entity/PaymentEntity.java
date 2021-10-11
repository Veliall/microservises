package com.example.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, name = "sender_id")
    private long senderId;
    @Column(nullable = false, name = "sender_card_number", columnDefinition = "TEXT")
    private String senderCardNumber;
    @Column(nullable = false, name = "addressee_card_number", columnDefinition = "TEXT")
    private String addresseeCardNumber;
    @Column(nullable = false)
    private long amount;
    @Column(columnDefinition = "TEXT")
    private String comment;
}
