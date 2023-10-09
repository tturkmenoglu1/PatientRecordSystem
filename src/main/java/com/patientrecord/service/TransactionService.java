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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        transaction.setDescription(transactionRequest.getDescription());
        transaction.setPayment(transactionRequest.getPayment());
        transaction.setReceivable(transactionRequest.getReceivable());

        transactionRepository.save(transaction);
    }


    public TransactionDTO getTransaction(Long id) {
        Transaction transaction = findTransactionById(id);
        return transactionMapper.domaingToDto(transaction);
    }

    public Transaction findTransactionById(Long id){
        return transactionRepository.findById(id).orElseThrow(()-> new
                ResourceNotFoundException(String.format(ErrorMessage.TRANSACTION_NOT_FOUND_MESSAGE,id)));
    }

    public Page<TransactionDTO> findAllWitnPage(Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAll(pageable);
        return transactions.map(transactionMapper::domaingToDto);
    }

    public long coundAccountBalance() {
        List<Transaction> transactions = transactionRepository.findAll();
        int sum = transactions.stream().mapToInt(Transaction::getReceivable).sum();
        return sum;
    }
}
