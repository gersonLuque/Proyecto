package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.course.CourseCreateDto;
import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.exception.CourseNotFoundException;
import com.proyect.CodeShareSpace.mapper.ICourseMapper;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.model.Course;
import com.proyect.CodeShareSpace.model.File.FileBase;
import com.proyect.CodeShareSpace.model.Task;
import com.proyect.CodeShareSpace.model.User;
import com.proyect.CodeShareSpace.repository.CourseRepository;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import com.proyect.CodeShareSpace.service.interfaces.IStorageService;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private IUserMapper IUserMapper;
    @Autowired
    private ICourseMapper iCourseMapper;
    @Autowired
    private ITaskService iTaskService;
    @Autowired
    private IStorageService iStorageService;

    @Override
    public List<UserDto> findUsersByCourseId(Long courseId) {
        List<User> users = courseRepository.findUsersByCourseId(courseId);
        return IUserMapper.usersToUsersDto(users);
    }

    @Override
    public CourseDto findById(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return iCourseMapper.courseToCourseDto(course.get());
    }

    @Override
    public List<CourseDto> findAll() {
        return iCourseMapper.coursesToCourseDtos(courseRepository.findAll());
    }

    @Override
    public List<CourseDto> findByUserId(Long userId) {
        List<Course> courses = courseRepository.findByUsers_UserId(userId);
        return iCourseMapper.coursesToCourseDtos(courses);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto){
        Course course = courseRepository.findById(courseDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Curso no encontrado"));

        course.setName(courseDto.getName());
        return iCourseMapper.courseToCourseDto(courseRepository.save(course));
    }

    @Override
    public CourseDto createCourse(CourseCreateDto courseCreateDto) {
        Course course = new Course();
        course.setName(courseCreateDto.getName());
        return iCourseMapper.courseToCourseDto(courseRepository.save(course));
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Curso no encontrado"));
        List<FileBase> filesCourse = getFilesFromCourse(course);
        iStorageService.delete(filesCourse);
        courseRepository.delete(course);
    }
    public List<FileBase> getFilesFromCourse(Course course){
        List<FileBase> result = new ArrayList<>();
        for (Task task : course.getTasks()){
            result.addAll(iTaskService.getFilesFromTask(task));
        }
        return result;
    }
}
