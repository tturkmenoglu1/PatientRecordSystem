package com.patientrecord.dto.request;

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

    private Integer receivable;

    private Integer debt;

    private Integer balance;

}
