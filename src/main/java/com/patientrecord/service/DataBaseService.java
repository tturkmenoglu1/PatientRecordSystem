package com.patientrecord.service;

import com.patientrecord.domain.Patient;
import com.patientrecord.dto.StatisticsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataBaseService {


    private final PatientService patientService;

    private final TransactionService transactionService;

    public StatisticsDTO getCountOfAllRecords() {
        long patientCount = patientService.countPatientRecords();
        long balance = transactionService.coundAccountBalance();
        StatisticsDTO statisticsDTO = new StatisticsDTO();
        statisticsDTO.setPatientCount(patientCount);
        statisticsDTO.setBalance(balance);
        return statisticsDTO;
    }
}
