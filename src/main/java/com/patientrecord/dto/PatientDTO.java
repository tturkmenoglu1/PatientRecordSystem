package com.patientrecord.dto;


import com.patientrecord.domain.Gender;
import com.patientrecord.domain.Nationality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor

public class PatientDTO {

    private Long id;

    private Nationality nationality;

    @Size(max=30,message="Size is exceeded")
    @NotBlank(message = "Please provide first name")
    private String firstName;

    @Size(max=30,message="Size is exceeded")
    @NotBlank(message = "Please provide last name")
    private String lastName;

    private LocalDate birthDate;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getTreat() {
        return treat;
    }

    public void setTreat(String treat) {
        this.treat = treat;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
