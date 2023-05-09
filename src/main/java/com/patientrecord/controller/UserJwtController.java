package com.patientrecord.controller;

import com.patientrecord.dto.request.LoginRequest;
import com.patientrecord.dto.request.RegisterRequest;
import com.patientrecord.dto.response.LoginResponse;
import com.patientrecord.dto.response.PRResponse;
import com.patientrecord.dto.response.ResponseMessage;
import com.patientrecord.security.jwt.JwtUtils;
import com.patientrecord.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserJwtController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<PRResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest  )  {
        userService.saveUser(registerRequest);

        PRResponse response = new PRResponse();
        response.setMessage(ResponseMessage.REGISTERATION_SUCCESS_MESSAGE);
        response.setSuccess(true);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    // login
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody LoginRequest loginRequest)  {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        Authentication authentication  =  authenticationManager.
                authenticate(usernamePasswordAuthenticationToken);

        UserDetails userDetails  =  (UserDetails) authentication.getPrincipal() ;// mevcut giriş yapan kullanıcıyı getirir

        String jwtToken =   jwtUtils.generateJwtToken(userDetails);

        LoginResponse loginResponse = new LoginResponse(jwtToken);

        return new ResponseEntity<>(loginResponse,HttpStatus.OK);

    }
}
