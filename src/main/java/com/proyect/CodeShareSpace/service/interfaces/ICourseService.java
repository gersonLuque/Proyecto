package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.CourseDTO;
import com.proyect.CodeShareSpace.dto.UserDTO;

import java.util.List;

public interface ICourseService {
    List<UserDTO> findUsersByCourseId(Long courseId);
    CourseDTO findById(Long courseId);
}
