package com.patientrecord.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String groupName;

    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 30, nullable = false)
    private String lastName;

    @Column(length = 30, nullable = false)
    private String birthPlace;

    @Column(length = 30, nullable = false)
    private String birthDate;

    @Column(length = 30, nullable = false)
    private String gender;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 500, nullable = false)
    private String complain;

    @Column(length = 3500, nullable = false)
    private String story;

    @Column(length = 100, nullable = false)
    private String treat;

    @Column(length = 300, nullable = false)
    private String medicine;

    @Column(length = 500, nullable = false)
    private String advice;

}