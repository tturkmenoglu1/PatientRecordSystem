package com.patientrecord.domain.enums;

public enum GenderName {

    MALE("MALE"),

    FEMALE("FEMALE");

    private String name;

    private GenderName(String name){ this.name = name;}

    private String getName(){ return name ; }
}
