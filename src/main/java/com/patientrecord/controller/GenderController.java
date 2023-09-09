package com.patientrecord.controller;

import com.patientrecord.dto.GenderDTO;
import com.patientrecord.service.GenderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gender")
@RequiredArgsConstructor
public class GenderController {

    private final GenderService genderService;

    @GetMapping("/option")
    public ResponseEntity<List<GenderDTO>> getALlGendersForOption(){
        return ResponseEntity.ok(genderService.getAllGenderList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderDTO> getGenderById(@PathVariable Long id){
        return ResponseEntity.ok(genderService.getGenderById(id));
    }
}
