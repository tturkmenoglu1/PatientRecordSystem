package com.patientrecord.domain;

import com.patientrecord.domain.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "t_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @Enumerated(EnumType.STRING)
    @Column
    private Payment payment;

    @Column
    private Integer receivable;

    @Column
    private Integer debt;

    @Column
    private String description;

    @Column
    private LocalDateTime createAt = LocalDateTime.now();



}
