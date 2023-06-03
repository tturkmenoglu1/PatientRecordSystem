package com.patientrecord.mapper;

import com.patientrecord.domain.Appointment;
import com.patientrecord.dto.AppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "id", ignore = true)
    AppointmentDTO appointmentToAppointmentDTO(Appointment appointment);
}
