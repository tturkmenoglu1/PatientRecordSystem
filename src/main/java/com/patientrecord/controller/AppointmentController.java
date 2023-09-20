package com.patientrecord.controller;

import com.patientrecord.dto.AppointmentDTO;
import com.patientrecord.dto.PatientDTO;
import com.patientrecord.dto.request.AppointmentRequest;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    //******************** GET APPOINTMENT **********************


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id){
        AppointmentDTO appointmentDTO = appointmentService.findAppointmentById(id);
        return ResponseEntity.ok(appointmentDTO);
    }

    //******************** GET ALL PATIENT AS LIST **********************


    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        List<AppointmentDTO> list = appointmentService.getAllAppointments();
        return ResponseEntity.ok(list);
    }


    //******************** GET ALL PATIENT AS PAGE **********************
    @GetMapping("/all/pg")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<AppointmentDTO>> getAllAppointmentsAsPage(@RequestParam("page") int page,
                                                                         @RequestParam("size") int size,
                                                                         @RequestParam("sort") String prop,
                                                                         @RequestParam(value = "direction", required = false, defaultValue = "DESC") Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page,size,Sort.by(direction,prop));
        Page<AppointmentDTO> pageDTO = appointmentService.findAllWitnPage(pageable);
        return ResponseEntity.ok(pageDTO);
    }

}
