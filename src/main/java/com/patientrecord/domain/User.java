package com.patientrecord.domain;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;

@Entity
@Table(name = "t_user")
public class User {

    @Column
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String city;

    private String phoneNumber;

    private Set<Role> roles = new HashSet<>();
}
