package com.patientrecord.service;

import com.patientrecord.domain.Patient;
import com.patientrecord.domain.Transaction;
import com.patientrecord.dto.request.TransactionRequest;
import com.patientrecord.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PatientService patientService;


    public void saveTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
        Patient patient = patientService.getPatientById(transactionRequest.getPatientId());

        transaction.setPatient(patient);
        transaction.setDebt(transactionRequest.getDebt());
        transaction.setBalance(transactionRequest.getBalance());
        transaction.setReceivable(transactionRequest.getReceivable());

        transactionRepository.save(transaction);
    }
}
