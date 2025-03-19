package com.finance.FinWise.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transId;

    @Column(nullable = false)
    private Double transAmount;

    @Column(nullable = false)
    private String transType; // income or expense

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private Date transDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}