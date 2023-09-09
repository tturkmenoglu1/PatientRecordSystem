package com.patientrecord.dto.request;

import com.patientrecord.domain.Gender;
import com.patientrecord.domain.Nationality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatienceRequest {

        private Long nationalityId;

        @Size(max=30,message="Size is exceeded")
        @NotBlank(message = "Please provide first name")
        private String firstName;

        @Size(max=30,message="Size is exceeded")
        @NotBlank(message = "Please provide last name")
        private String lastName;


        private LocalDateTime birthDate;

        @Size(max=30,message="Size is exceeded")
        private String birthPlace;

        private Long genderId;

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
