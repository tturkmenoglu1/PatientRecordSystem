package com.patientrecord.controller;

import com.patientrecord.dto.AppointmentDTO;
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

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PRResponse> createAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO){

        appointmentService.createAppointment(appointmentDTO);

        PRResponse response = new PRResponse(ResponseMessage.APPOINTMENT_SAVED_RESPONSE_MESSAGE, true);

        return ResponseEntity.ok(response);
    }


}
