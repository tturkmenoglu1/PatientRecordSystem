package com.patientrecord.service;

import com.patientrecord.domain.Patient;
import com.patientrecord.domain.Transaction;
import com.patientrecord.dto.TransactionDTO;
import com.patientrecord.dto.request.TransactionRequest;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.mapper.TransactionMapper;
import com.patientrecord.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

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

    public TransactionDTO getTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()-> new
                                ResourceNotFoundException(String.format(ErrorMessage.TRANSACTION_NOT_FOUND_MESSAGE,id)));
        return transactionMapper.transactionToTransactionDTO(transaction);
    }
}
