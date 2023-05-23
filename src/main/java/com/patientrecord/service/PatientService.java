package com.patientrecord.service;

import com.patientrecord.domain.ImageFile;
import com.patientrecord.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private ImageFileService imageFileService;

    public void savePatient(String imageId, PatientDTO patientDTO) {

        ImageFile imageFile = imageFileService.findImageById(imageId);

    }
}
