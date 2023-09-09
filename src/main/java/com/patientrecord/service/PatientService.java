package com.patientrecord.service;

import com.patientrecord.domain.Gender;
import com.patientrecord.domain.ImageFile;
import com.patientrecord.domain.Nationality;
import com.patientrecord.domain.Patient;
import com.patientrecord.dto.PatientDTO;
import com.patientrecord.dto.request.PatienceRequest;
import com.patientrecord.exception.ConflictException;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.mapper.PatientMapper;
import com.patientrecord.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    private final ImageFileService imageFileService;

    private final PatientMapper patientMapper;

    private final NationalityService nationalityService;

    private final GenderService genderService;

    public void savePatient(PatienceRequest patienceRequest) {

//        ImageFile imageFile = imageFileService.findImageById(imageId);
//        Integer usedPatientCount = patientRepository.findPatientCountByImageId(imageFile.getId());
//
//        if (usedPatientCount > 0){
//            throw new ConflictException(ErrorMessage.IMAGE_USED_MESSAGE);
//        }

        Patient patient = new Patient();
        Nationality nationality = nationalityService.findNationById(patienceRequest.getNationalityId());
        Gender gender = genderService.findGenderById(patienceRequest.getGenderId());

        patient.setNationality(nationality);
        patient.setFirstName(patienceRequest.getFirstName());
        patient.setLastName(patienceRequest.getLastName());
        patient.setBirthDate(patienceRequest.getBirthDate());
        patient.setBirthPlace(patienceRequest.getBirthPlace());
        patient.setGender(gender);
        patient.setEmail(patienceRequest.getEmail());
        patient.setPhoneNumber(patienceRequest.getPhoneNumber());
        patient.setAddress(patienceRequest.getAddress());
        patient.setComplain(patienceRequest.getComplain());
        patient.setStory(patienceRequest.getStory());
        patient.setTreat(patienceRequest.getTreat());
        patient.setMedicine(patienceRequest.getMedicine());
        patient.setAdvice(patienceRequest.getAdvice());

        patientRepository.save(patient);

    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.PATIENT_NOT_FOUND_MESSAGE, id)));
    }


    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.map(patients);
    }

    public void updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient = getPatientById(id);
        Nationality nationality = nationalityService.findNationById(patientDTO.getNationality().getId());
        Gender gender = genderService.findGenderById(patientDTO.getGender().getId());

        patient.setNationality(nationality);
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setBirthPlace(patientDTO.getBirthPlace());
        patient.setGender(gender);
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
        Patient patient = getPatientById(id);

        //TODO: rezervasyon olma durumunu kontrol et

        patientRepository.delete(patient);
    }

    public PatientDTO findById(Long id) {
        Patient patient = getPatientById(id);

        return patientMapper.patientToPatientDTO(patient);
    }
}
