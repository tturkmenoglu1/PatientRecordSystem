package com.patientrecord.dto;

import com.patientrecord.domain.ImageFile;
import com.patientrecord.domain.enums.Gender;
import com.patientrecord.domain.enums.GroupName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PatientDTO {

    private GroupName groupName;

    @Size(max=30,message="Size is exceeded")
    @NotBlank(message = "Please provide first name")
    private String firstName;

    @Size(max=30,message="Size is exceeded")
    @NotBlank(message = "Please provide last name")
    private String lastName;


    private LocalDateTime birthDate;

    @Size(max=30,message="Size is exceeded")
    private String birthPlace;

    private Gender gender;


    @Size(max=100,message="Size is exceeded")
    private String email;

    @Size(max=15,message="Size is exceeded")
    private String phoneNumber;

    @Size(max=100,message="Size is exceeded")
    private String address;

    @Size(max=500,message="Size is exceeded")
    private String complain;

    @Size(max=3500,message="Size is exceeded")
    private String story;

    @Size(max=100,message="Size is exceeded")
    @NotBlank(message = "Plesase provide treat")
    private String treat;

    @Column(length = 300)
    private String medicine;

    @Column(length = 500)
    private String advice;


    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "patient_id")
    private Set<ImageFile> image;

}
