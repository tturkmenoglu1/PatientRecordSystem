package com.patientrecord.mapper;

import com.patientrecord.domain.User;
import com.patientrecord.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);
}
