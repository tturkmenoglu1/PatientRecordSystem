package com.patientrecord.controller;

import com.patientrecord.dto.PatientDTO;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    //******************** CREATE PATIENT **********************

    @PostMapping("/admin/{imageId}/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PRResponse> savePatient(@Valid @RequestBody PatientDTO patientDTO){

        patientService.savePatient(patientDTO);

        PRResponse response = new PRResponse(ResponseMessage.PATIENT_RECORD_SUCCESS_MESSAGE, true);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //******************** GET ALL PATIENT AS LIST **********************

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PatientDTO>> getAllPatients(){

        List<PatientDTO> allPatients = patientService.getAllPatients();

        return ResponseEntity.ok(allPatients);
    }

    //******************** GET PATIENT **********************

    @GetMapping("/{id}")
    @PreAuthorize(("hasRole('ADMIN')"))
    public ResponseEntity<PatientDTO> getPatientById(@RequestParam Long id){

        PatientDTO patientDTO = patientService.findById(id);

        return ResponseEntity.ok(patientDTO);
    }


    //******************** UPDATE PATIENT **********************

    @PutMapping("/admin/auth")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PRResponse> updatePatient(@RequestParam("id") Long id, @Valid @RequestBody PatientDTO patientDTO){

        patientService.updatePatient(id,patientDTO);

        PRResponse response = new PRResponse(ResponseMessage.PATIENT_UPDATE_SUCCESS_MESSAGE, true);

        return ResponseEntity.ok(response);
    }

    //******************** DELETE **********************
    @DeleteMapping("/admin/{id}/auth")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PRResponse> deletePatient(@RequestParam Long id){
        patientService.removeByID(id);

        PRResponse response = new PRResponse(ResponseMessage.PATIENT_DELETE_SUCCESS_MESSAGE, true);

        return ResponseEntity.ok(response);
    }
}
