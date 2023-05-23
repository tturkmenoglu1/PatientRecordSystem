package com.patientrecord.controller;

import com.patientrecord.dto.PatientDTO;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/admin/{imageId}/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PRResponse> savePatient(@PathVariable String imageId, @Valid @RequestBody PatientDTO patientDTO){

        return ResponseEntity
    }

}
