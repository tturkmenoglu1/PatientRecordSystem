package com.patientrecord.service;

import com.patientrecord.domain.ImageFile;
import com.patientrecord.domain.Patient;
import com.patientrecord.dto.PatientDTO;
import com.patientrecord.exception.ConflictException;
import com.patientrecord.exception.ResourceNotFoundException;
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

    private Patient getPatient(Long id) {
        return patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.PATIENT_NOT_FOUND_MESSAGE, id)));
    }


    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.map(patients);
    }

    public void updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient = getPatient(id);

        patient.setGroupName(patientDTO.getGroupName());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setBirthPlace(patientDTO.getBirthPlace());
        patient.setGender(patientDTO.getGender());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setAddress(patientDTO.getAddress());
        patient.setComplain(patientDTO.getComplain());
        patient.setStory(patientDTO.getStory());
        patient.setTreat(patientDTO.getTreat());
        patient.setMedicine(patientDTO.getMedicine());
        patient.setAdvice(patientDTO.getAdvice());

        patientRepository.save(patient);

    }


    public void removeByID(Long id) {
        Patient patient = getPatient(id);

        //TODO: rezervasyon olma durumunu kontrol et

    }
}
