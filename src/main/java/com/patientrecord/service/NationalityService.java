package com.patientrecord.service;

import com.patientrecord.domain.Nationality;
import com.patientrecord.dto.NationalityDTO;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.mapper.NationalityMapper;
import com.patientrecord.repository.NationalityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NationalityService {

    private final NationalityRepository nationalityRepository;

    private final NationalityMapper nationalityMapper;

    public List<NationalityDTO> getAllNationsList() {
        return nationalityMapper.listToDTOList(nationalityRepository.findAll());
    }

    public NationalityDTO getNAtionById(Long id) {
        Nationality nationality = findNationById(id);
        return nationalityMapper.nationalityToNationalityDTO(nationality);
    }

    public Nationality findNationById(Long id) {
        return nationalityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No gender found with "+ id));
    }
}
