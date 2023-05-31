package com.patientrecord.service;

import com.patientrecord.domain.ImageFile;
import com.patientrecord.domain.Patient;
import com.patientrecord.dto.PatientDTO;
import com.patientrecord.exception.ConflictException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.mapper.PatientMapper;
import com.patientrecord.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ImageFileService imageFileService;

    @Autowired
    private PatientMapper patientMapper;

    public void savePatient(PatientDTO patientDTO) {

//        ImageFile imageFile = imageFileService.findImageById(imageId);
//        Integer usedPatientCount = patientRepository.findPatientCountByImageId(imageFile.getId());
//
//        if (usedPatientCount > 0){
//            throw new ConflictException(ErrorMessage.IMAGE_USED_MESSAGE);
//        }

        Patient patient = patientMapper.patientDTOToPatient(patientDTO);

        patientRepository.save(patient);

    }

    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.map(patients);
    }
}
