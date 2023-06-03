package com.patientrecord.service;

import com.patientrecord.domain.Appointment;
import com.patientrecord.domain.Patient;
import com.patientrecord.dto.AppointmentDTO;
import com.patientrecord.dto.PatientDTO;
import com.patientrecord.dto.request.AppointmentRequest;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.mapper.AppointmentMapper;
import com.patientrecord.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired PatientService patientService;

    public void createAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = new Appointment();

        Patient patient = patientService.getPatientById(appointmentRequest.getPatientId());

        appointment.setPatient(patient);
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setAbout(appointmentRequest.getAbout());

        appointmentRepository.save(appointment);
    }

    public AppointmentDTO findAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.APPOINTMENT_NOT_FOUND_MESSAGE, id)));
        return appointmentMapper.appointmentToAppointmentDTO(appointment);
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointmentMapper.map(appointments);
    }
}
