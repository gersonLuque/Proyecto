package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.UserDTO;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    UserDTO userToUserDto(User user);

    User userDtoToUser(UserDTO userDto);

    List<UserDTO> usersToUsersDto(List<User> users);

}
