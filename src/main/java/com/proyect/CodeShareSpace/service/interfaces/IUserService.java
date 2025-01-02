package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    UserDTO findById(Long id);
}
