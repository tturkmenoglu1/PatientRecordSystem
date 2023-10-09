package com.patientrecord.controller;

import com.patientrecord.dto.StatisticsDTO;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.service.DataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
@RequiredArgsConstructor
public class DataBaseController {

    public final DataBaseService dataBaseService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StatisticsDTO> getCountOfAllRecords(){
        StatisticsDTO statisticsDTO = dataBaseService.getCountOfAllRecords();
        return ResponseEntity.ok(statisticsDTO);
    }

}
