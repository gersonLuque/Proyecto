package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.CourseDTO;
import com.proyect.CodeShareSpace.dto.UserDTO;
import com.proyect.CodeShareSpace.mapper.ICourseMapper;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.ICourseRepository;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository ICourseRepository;
    @Autowired
    private IUserMapper IUserMapper;
    @Autowired
    private ICourseMapper iCourseMapper;

    @Override
    public List<UserDTO> findUsersByCourseId(Long courseId) {
        List<User> users = ICourseRepository.findUsersByCourseId(courseId);
        return IUserMapper.usersToUsersDto(users);
    }

    @Override
    public CourseDTO findById(Long courseId) {
        Optional<Course> course = ICourseRepository.findById(courseId);
        return iCourseMapper.courseToCourseDto(course.get());
    }
}
