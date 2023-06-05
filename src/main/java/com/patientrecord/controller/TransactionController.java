package com.patientrecord.controller;

import com.patientrecord.domain.Patient;
import com.patientrecord.domain.Transaction;
import com.patientrecord.dto.TransactionDTO;
import com.patientrecord.dto.request.TransactionRequest;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.service.PatientService;
import com.patientrecord.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;



    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PRResponse> createTransaction(@RequestBody TransactionRequest transactionRequest){

        transactionService.saveTransaction(transactionRequest);
        PRResponse response = new PRResponse(ResponseMessage.TRANSACTION_SAVED_RESPONSE_MESSAGE, true);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id){
        TransactionDTO transactionDTO = transactionService.getTransaction(id);
        return ResponseEntity.ok(transactionDTO);
    }

}
