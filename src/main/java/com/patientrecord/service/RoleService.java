package com.patientrecord.service;

import com.patientrecord.domain.Role;
import com.patientrecord.domain.enums.RoleType;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByType(RoleType roleType) {

        return roleRepository.findByType(roleType).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.ROLE_NOT_FOUND_MESSAGE, roleType.name())));
    }
}
