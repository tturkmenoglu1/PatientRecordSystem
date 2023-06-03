package com.patientrecord.mapper;

import com.patientrecord.domain.Appointment;
import com.patientrecord.dto.AppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {


    AppointmentDTO appointmentToAppointmentDTO(Appointment appointment);

    List<AppointmentDTO> map(List<Appointment> appointments);
}
