package com.patientrecord.mapper;

import com.patientrecord.domain.Gender;
import com.patientrecord.dto.GenderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenderMapper {

    GenderDTO genderToGenderDTO(Gender gender);

    Gender genderDTOToGender(GenderDTO genderDTO);

    List<GenderDTO> genderListToGenderDTOList(List<Gender> genders);
}
