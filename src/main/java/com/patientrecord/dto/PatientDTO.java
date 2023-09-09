package com.patientrecord.dto;


import com.patientrecord.domain.Gender;
import com.patientrecord.domain.Nationality;
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

    private Nationality nationality;

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

    @Size(max=300,message="Size is exceeded")
    private String treat;

    @Size(max=100,message="Size is exceeded")
    private String medicine;

    @Size(max=500,message="Size is exceeded")
    private String advice;

//    private Set<String> image;

}
