package com.patientrecord.dto;

import com.patientrecord.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String address;

    private String city;

    private String phoneNumber;

    private Boolean builtIn;

    private List<Role> roles;
}
