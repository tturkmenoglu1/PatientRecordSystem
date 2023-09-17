package com.patientrecord.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime appointmentDate;

    private String about;

}
