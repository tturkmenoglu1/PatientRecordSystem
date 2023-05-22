package com.patientrecord.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer receivable;

    @Column
    private Integer debt;

    @Column
    private Integer balance;

    @Column
    private LocalDateTime createAt = LocalDateTime.now();



}
