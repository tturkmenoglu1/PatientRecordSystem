package com.patientrecord.controller;

import com.patientrecord.dto.AppointmentDTO;
import com.patientrecord.dto.TransactionDTO;
import com.patientrecord.dto.request.TransactionRequest;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/all/page")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<TransactionDTO>> getAllTransactionsAsPage(@RequestParam("page") int page,
                                                                         @RequestParam("size") int size,
                                                                         @RequestParam("sort") String prop,
                                                                         @RequestParam(value = "direction", required = false, defaultValue = "DESC") Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page,size,Sort.by(direction,prop));
        Page<TransactionDTO> pageDTO = transactionService.findAllWitnPage(pageable);
        return ResponseEntity.ok(pageDTO);
    }



}
