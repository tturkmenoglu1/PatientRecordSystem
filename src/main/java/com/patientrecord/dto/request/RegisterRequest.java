package com.patientrecord.dto.request;

import com.patientrecord.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @Size(max=50)
    @NotBlank(message="Please provide your First Name")
    private String firstName;

    @Size(max=50)
    @NotBlank(message="Please provide your Last Name")
    private String lastName;

    @Size(min = 5, max=50)
    @Email(message="Please provide your email")
    private String email;

    @Size(min = 4, max=50, message = "Please provide a password with indicated size")
    @NotBlank(message="Please provide your password")
    private String password;

    @Size(max= 100)
    @NotBlank(message = "Please provide your address")
    private String address;

    @Size(max= 100)
    @NotBlank(message = "Please provide your city")
    private String city;

    @Size(max=14)
    @NotBlank(message = "Please provide your phone number")
    private String phoneNumber;


}
