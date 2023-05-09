package com.patientrecord.service;

import com.patientrecord.domain.Role;
import com.patientrecord.domain.User;
import com.patientrecord.domain.enums.RoleType;
import com.patientrecord.dto.request.RegisterRequest;
import com.patientrecord.exception.ConflictException;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {


    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private RoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, RoleService roleService) {
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException(String.format(ErrorMessage.EMAIL_NOT_FOUND_MESSAGE, email)));
    }


    public void saveUser(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw new ConflictException(String.format(ErrorMessage.EMAIL_ALREADY_EXIST_MESSAGE, registerRequest.getEmail()));
        }

        Role role = roleService.findByType(RoleType.ROLE_PATIENT);

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

        User user = new User();

        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodedPassword);
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setAddress(registerRequest.getAddress());
        user.setCity(registerRequest.getCity());
        user.setRoles(roles);

        userRepository.save(user);

    }
}
