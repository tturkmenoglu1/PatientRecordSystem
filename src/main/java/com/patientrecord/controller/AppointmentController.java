package com.patientrecord.controller;

import com.patientrecord.dto.AppointmentDTO;
import com.patientrecord.dto.request.AppointmentRequest;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    //******************** CREATE APPOINTMENT **********************


    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PRResponse> createAppointment(@Valid @RequestBody AppointmentRequest appointmentRequest){

        appointmentService.createAppointment(appointmentRequest);

        PRResponse response = new PRResponse(ResponseMessage.APPOINTMENT_SAVED_RESPONSE_MESSAGE, true);

        return ResponseEntity.ok(response);
    }

    //******************** GET ALL PATIENT AS LIST **********************
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id{
        AppointmentDTO appointmentDTO = appointmentService.findAppointmentById(id);
        return ResponseEntity.ok(appointmentDTO);
    })


}
