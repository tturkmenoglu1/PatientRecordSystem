package com.patientrecord.service;

import com.patientrecord.domain.Role;
import com.patientrecord.domain.User;
import com.patientrecord.domain.enums.RoleType;
import com.patientrecord.dto.UserDTO;
import com.patientrecord.dto.request.RegisterRequest;
import com.patientrecord.exception.ConflictException;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.mapper.UserMapper;
import com.patientrecord.repository.UserRepository;

import com.patientrecord.security.SecurityUtils;
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

    private UserMapper userMapper;

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

    public User getCurrentUser() {
        String email = SecurityUtils.getCurrentUserLogin().orElseThrow(()->
                new ResourceNotFoundException(ErrorMessage.PRINCIPAL_FOUND_MESSAGE));
        return getUserByEmail(email);

    }

    public UserDTO getPrincipal() {
        User user=getCurrentUser();
        return userMapper.userToUserDTO(user);
    }
}
