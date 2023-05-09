package com.patientrecord.service;

import com.patientrecord.domain.User;
import com.patientrecord.dto.request.RegisterRequest;
import com.patientrecord.exception.ConflictException;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException(String.format(ErrorMessage.EMAIL_NOT_FOUND_MESSAGE, email)));
    }


    public void saveUser(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw new ConflictException(ErrorMessage.EMAIL_ALREADY_EXIST_MESSAGE, registerRequest.getEmail());
        }
    }
}
