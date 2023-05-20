package com.patientrecord.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String patientName;

    private LocalDateTime appointmentDate;


    private String about;
}
