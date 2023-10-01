package com.patientrecord.mapper;

import com.patientrecord.domain.Transaction;
import com.patientrecord.dto.TransactionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionDTO domaingToDto(Transaction transaction);
}
