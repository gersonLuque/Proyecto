package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.UserDTO;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.IUserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository IUserRepository;
    @Autowired
    private IUserMapper IUserMapper;


    @Override
    public List<UserDTO> findAll() {
        List<User> users = IUserRepository.findAll();
        return IUserMapper.usersToUsersDto(users);
    }

    @Override
    public UserDTO findById(Long id) {
        try {
            User user = IUserRepository.findById(id).orElseThrow();
            return IUserMapper.userToUserDto(user);
        } catch (Exception e) {
            System.out.println("User not found or error occurred: " + e.getMessage());
            return null; // O maneja el error como prefieras
        }
    }
}
