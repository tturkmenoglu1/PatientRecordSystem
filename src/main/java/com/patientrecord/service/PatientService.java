package com.patientrecord.service;

import com.patientrecord.domain.Gender;
import com.patientrecord.domain.Nationality;
import com.patientrecord.domain.Patient;
import com.patientrecord.dto.PatientDTO;
import com.patientrecord.dto.request.PatienceRequest;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.mapper.PatientMapper;
import com.patientrecord.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    private final ImageFileService imageFileService;

    private final PatientMapper patientMapper;

    private final NationalityService nationalityService;

    private final GenderService genderService;

    private final EntityManager entityManager;


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

    public void updatePatient(Long id, PatienceRequest patienceRequest) {
        Patient patient = getPatientById(id);
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


    public void removeByID(Long id) {
        Patient patient = getPatientById(id);

        //TODO: rezervasyon olma durumunu kontrol et

        patientRepository.delete(patient);
    }

    public PatientDTO findById(Long id) {
        Patient patient = getPatientById(id);

        return patientMapper.patientToPatientDTO(patient);
    }

    public Page<PatientDTO> findAllWitnPage(String query, String firstName, String lastName, String phoneNumber, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Patient> criteriaQuery = cb.createQuery(Patient.class);
        Root<Patient> root =criteriaQuery.from(Patient.class);

        List<Predicate> predicates = new ArrayList<>();
        Predicate finalPredicate = null;

        if (firstName != null && !firstName.isEmpty()){
            String likeSearchText = "%" + firstName.toLowerCase(Locale.US)+ "%";
            System.err.println(likeSearchText);
            predicates.add(cb.like(cb.lower(root.get("firstName")), likeSearchText));
        }

        if (lastName != null && !lastName.isEmpty()){
            String likeSearchText = "%" + lastName.toLowerCase(Locale.US)+ "%";
            System.err.println(likeSearchText);
            predicates.add(cb.like(cb.lower(root.get("lastName")), likeSearchText));
        }

        if (phoneNumber != null && !phoneNumber.isEmpty()){
            String likeSearchText = "%" + phoneNumber.toLowerCase(Locale.US)+ "%";
            System.err.println(likeSearchText);
            predicates.add(cb.like(cb.lower(root.get("phoneNumber")), likeSearchText));
        }

        finalPredicate = cb.and(predicates.toArray(new Predicate[0]));

        criteriaQuery.orderBy(pageable.getSort().stream()
                .map(order -> {
                    if (order.isAscending()) {
                        return cb.asc(root.get(order.getProperty()));
                    } else {
                        return cb.desc(root.get(order.getProperty()));
                    }
                })
                .collect(Collectors.toList()));

        criteriaQuery.where(finalPredicate);

        TypedQuery<Patient> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult((int)pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(Patient.class)));
        countQuery.where(finalPredicate);
        Long totalRecords = entityManager.createQuery(countQuery).getSingleResult();

        List<PatientDTO> patientDTOList = patientMapper.map(typedQuery.getResultList());
        return new PageImpl<>(patientDTOList,pageable,totalRecords);

    }

    public long countPatientRecords() {
        return patientRepository.count();
    }
}
