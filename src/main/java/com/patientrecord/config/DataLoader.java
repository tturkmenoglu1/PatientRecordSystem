package com.patientrecord.config;

import com.patientrecord.domain.Gender;
import com.patientrecord.domain.Nationality;
import com.patientrecord.domain.Role;
import com.patientrecord.domain.enums.RoleType;
import com.patientrecord.repository.GenderRepository;
import com.patientrecord.repository.NationalityRepository;
import com.patientrecord.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {


    private final RoleRepository roleRepository;
    private final GenderRepository genderRepository;
    private final NationalityRepository nationalityRepository;

    @Override
    public void run(String... args) throws Exception {
//        roleRepository.save(new Role(1, RoleType.ROLE_PATIENT));
//        roleRepository.save(new Role(2, RoleType.ROLE_ADMIN));
//
//        genderRepository.save(new Gender(1L, "MALE"));
//        genderRepository.save(new Gender(2L,"FEMALE"));
//
//        nationalityRepository.save(new Nationality(1L, "TURKEY"));
//        nationalityRepository.save(new Nationality(2L, "GEORGIAN"));
//        nationalityRepository.save(new Nationality(3L, "AZERBAIJANI"));
//        nationalityRepository.save(new Nationality(4L, "RUSSIAN"));
//        nationalityRepository.save(new Nationality(5L, "ARABIAN"));

    }
}
