package com.patientrecord.service;

import com.patientrecord.domain.ImageData;
import com.patientrecord.domain.ImageFile;
import com.patientrecord.exception.ResourceNotFoundException;
import com.patientrecord.exception.message.ErrorMessage;
import com.patientrecord.repository.ImageFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class ImageFileService {

    @Autowired
    private ImageFileRepository imageFileRepository;

    public ImageFile findImageById(String imageId) {
        return imageFileRepository.findImageById(imageId).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.IMAGE_NOT_FOUND_MESSAGE,imageId)));

    }

    public String saveImage(MultipartFile file) {
        ImageFile imageFile = null;

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            ImageData imData= new ImageData(file.getBytes());
            imageFile = new ImageFile(fileName, file.getContentType(), imData);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        imageFileRepository.save(imageFile);

        return imageFile.getId();
    }
}
