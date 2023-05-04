package com.patientrecord.domain.enums;

import com.patientrecord.domain.Role;

public enum RoleType {

    ROLE_PATIENT("PATIENT"),

    ROLE_ADMIN("ADMINISTRATOR");

    private String name;

    private RoleType(String name){ this.name = name;}

    private String getName(){ return name ; }
}
