package com.patientrecord.domain;

import com.patientrecord.domain.enums.Gender;
import com.patientrecord.domain.enums.GroupName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "t_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private GroupName groupName;

    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column
    private LocalDateTime birthDate;

    @Column(length = 30)
    private String birthPlace;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String phoneNumber;

    @Column(length = 100)
    private String address;

    @Column(length = 500)
    private String complain;

    @Column(length = 3500)
    private String story;

    @Column(length = 100, nullable = false)
    private String treat;

    @Column(length = 300)
    private String medicine;

    @Column(length = 500)
    private String advice;


    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "patient_id")
    private Set<ImageFile> image;
}