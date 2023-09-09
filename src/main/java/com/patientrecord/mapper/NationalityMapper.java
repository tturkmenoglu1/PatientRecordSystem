package com.patientrecord.mapper;

import com.patientrecord.domain.Nationality;
import com.patientrecord.dto.NationalityDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NationalityMapper {

    Nationality nationalityDTOTONationality(NationalityDTO nationalityDTO);

    NationalityDTO nationalityToNationalityDTO(Nationality nationality);

    List<NationalityDTO> listToDTOList(List<Nationality> nationalities);
}
