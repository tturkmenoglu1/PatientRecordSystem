package com.patientrecord.dto;

import com.patientrecord.domain.Patient;
import com.patientrecord.domain.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TransactionDTO {

    private Long id;

    private Patient patient;

    private Integer receivable;

    private Integer debt;

    private Payment payment;

    private String description;

    private LocalDateTime createAt;
}
