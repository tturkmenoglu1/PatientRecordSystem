package com.patientrecord.dto;

import com.patientrecord.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TransactionDTO {

    private Patient patient;

    private Integer receivable;

    private Integer debt;

    private Integer balance;

    private LocalDateTime createAt;
}
