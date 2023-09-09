package com.patientrecord.controller;

import com.patientrecord.dto.GenderDTO;
import com.patientrecord.dto.NationalityDTO;
import com.patientrecord.service.NationalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nationality")
@RequiredArgsConstructor
public class NationalityController {

    private final NationalityService nationalityService;

    @GetMapping("/option")
    public ResponseEntity<List<NationalityDTO>> getALlNationsForOption(){
        return ResponseEntity.ok(nationalityService.getAllNationsList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NationalityDTO> getNationById(@PathVariable Long id){
        return ResponseEntity.ok(nationalityService.getNAtionById(id));
    }

}
