package com.patientrecord.dto.request;


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

public class AppointmentRequest {

    private Long patientId;

    private LocalDateTime appointmentDate;

    private String about;

}
