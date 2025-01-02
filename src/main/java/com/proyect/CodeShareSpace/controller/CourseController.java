package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.UserDTO;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController { // Es necesario implementar la interfaz "service/interfaces/ICourseService"

    @Autowired
    private ICourseService iCourseService;

    public CourseController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @GetMapping("{courseId}/users")
    public ResponseEntity<List<UserDTO>> getUsersByCourse(@PathVariable Long courseId){
        List<UserDTO> users = iCourseService.findUsersByCourseId(courseId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
