package com.patientrecord.service;

import com.patientrecord.domain.Gender;
import com.patientrecord.dto.GenderDTO;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.mapper.GenderMapper;
import com.patientrecord.repository.GenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenderService {

    private final GenderRepository genderRepository;
    private final GenderMapper genderMapper;

    public List<GenderDTO> getAllGenderList(){
        List<Gender> genderList = genderRepository.findAll();
        return genderMapper.genderListToGenderDTOList(genderList);
    }

    public GenderDTO getGenderById(Long id) {
        Gender gender = findGenderById(id);
        return genderMapper.genderToGenderDTO(gender);
    }

    public Gender findGenderById(Long id) {
        return genderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No gender found with "+ id));
    }
}