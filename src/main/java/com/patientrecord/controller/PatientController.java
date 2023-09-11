package com.patientrecord.controller;

import com.patientrecord.dto.PatientDTO;
import com.patientrecord.dto.request.PatienceRequest;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @PostMapping("/admin/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PRResponse> savePatient(@Valid @RequestBody PatienceRequest patienceRequest){

        patientService.savePatient(patienceRequest);

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


    //**********************PAGING************************


    @GetMapping("/all/page")
    public ResponseEntity<Page<PatientDTO>> getAllPatientsAsPage(@RequestParam(value = "q",required = false)String query,
                                                                 @RequestParam("page") int page,
                                                                 @RequestParam("size") int size,
                                                                 @RequestParam("sort") String prop,
                                                                 @RequestParam(value = "direction", required = false, defaultValue = "DESC") Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page,size,Sort.by(direction,prop));
        Page<PatientDTO> pageDTO = patientService.findAllWitnPage(query,pageable);
        return ResponseEntity.ok(pageDTO);
    }
}
