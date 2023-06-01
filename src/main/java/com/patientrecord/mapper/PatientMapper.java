package com.patientrecord.mapper;

import com.patientrecord.domain.ImageFile;
import com.patientrecord.domain.Patient;
import com.patientrecord.dto.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PatientMapper {



    @Mapping(target = "id", ignore = true)
    Patient patientDTOToPatient(PatientDTO patientDTO);

    PatientDTO patientToPatientDTO(Patient patient);

//    @Mapping(source="image", target="id", qualifiedByName = "getImageAsString")
    List<PatientDTO> map(List<Patient> patients);


    @Named("getImageAsString")
    public static Set<String> getImageIds(Set<ImageFile> imageFiles) {
        Set<String> imgs = new HashSet<>();
        imgs = imageFiles.stream().map(imFile->imFile.getId().
                        toString()).
                collect(Collectors.toSet());
        return imgs;
    }
}
