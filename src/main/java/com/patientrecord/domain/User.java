package com.patientrecord.domain;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String city;

    private String phoneNumber;

    @OneToMany
    private Set<Role> roles = new HashSet<>();
}
