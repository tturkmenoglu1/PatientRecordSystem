package com.patientrecord.repository;

import com.patientrecord.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

//    @Query("SELECT count(*) FROM Patient p JOIN p.image img WHERE img.id = :id")
//    Integer findPatientCountByImageId(@Param("id") String id);


}
