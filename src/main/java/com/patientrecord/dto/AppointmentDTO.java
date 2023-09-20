package com.patientrecord.dto;


import com.patientrecord.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentDTO {

    private Long id;

    private Patient patient;

    private LocalDateTime appointmentDate;

    private String about;

}
