package com.patientrecord.service;

import com.patientrecord.dto.AppointmentDTO;
import com.patientrecord.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void createAppointment(AppointmentDTO appointmentDTO) {
    }
}
