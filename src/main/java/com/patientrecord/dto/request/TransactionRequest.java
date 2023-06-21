package com.patientrecord.dto.request;

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

public class TransactionRequest {

    private Long patientId;

    private Payment payment;

    private Integer receivable;

    private Integer debt;

    private String description;

}
