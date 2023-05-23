package com.patientrecord.repository;

import com.patientrecord.domain.ImageFile;
import com.patientrecord.service.ImageFileService;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile,String> {

    @EntityGraph(attributePaths = "id") // imageFile ile ilgili datalar gelsin
    Optional<ImageFile> findImageById(String imageId);
}
