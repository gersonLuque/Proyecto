package com.proyect.CodeShareSpace;

import com.proyect.CodeShareSpace.dto.CourseDTO;
import com.proyect.CodeShareSpace.dto.UserDTO;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.persistence.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataProvider {

    //Método para crear un curso de prueba
    public static Course newCourseMock(){
        Course course = new Course();
        course.setCourseId(3L);
        course.setName("Programación");
        course.setUsers(new HashSet<>());  // Crear un conjunto vacío de usuarios
        return course;
    }

    public static CourseDTO newCourseDTOMock(){
        CourseDTO courseDto = new CourseDTO();
        courseDto.setCourseId(1L);
        courseDto.setName("Matemáticas");
        courseDto.setUsers(new HashSet<>());  // Crear un conjunto vacío de usuarios
        return courseDto;
    }

    public static User newUserMock(){
        User user = new User();
        user.setUserId(10L);
        user.setUsername("anaFrank08");
        user.setPassword("cacahuete");
        user.setCompleteName("Ana Cisneros");
        user.setRol(Rol.TEACHER);
        user.setCourses(new HashSet<>());
        return user;
    }

    public static UserDTO newUserDtoMock(){
        Set<Course> courseSet = newCoursesSet();

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1L);
        userDTO.setUsername("josemanue");
        userDTO.setPassword("j123");
        userDTO.setCompleteName("Juan Pérez");
        userDTO.setRol(Rol.STUDENT);
        userDTO.setCourses(courseSet); // Se agregan los cursos
        return userDTO;
    }

    public static List<UserDTO> newUsersDtoListMock(){
        UserDTO user1 = new UserDTO();
        user1.setUsername("alfredoRomeroma12");
        UserDTO user2 = new UserDTO();
        user2.setUsername("carlomagno");
        UserDTO user3 = new UserDTO();
        user3.setUsername("asd12");
        UserDTO user4 = new UserDTO();
        user4.setUsername("ffff");
        UserDTO user5 = new UserDTO();
        user5.setUsername("endend");
        return List.of(user1, user2, user3, user4, user5);
    }

    public static List<UserDTO> usersToSearchMock(){
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setUserId(1L);
        userDTO1.setUsername("cristianoRonaldo7");
        userDTO1.setPassword("bicho007");
        userDTO1.setRol(Rol.STUDENT);

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setUserId(2L);
        userDTO2.setUsername("frankSinatra");
        userDTO2.setPassword("borabora");
        userDTO2.setRol(Rol.TEACHER);

        return List.of(userDTO1, userDTO2);
    }

    private static Set<Course> newCoursesSet(){
        Course course1 = new Course(); course1.setName("SSII");
        Course course2 = new Course(); course2.setName("Programación");
        Course course3 = new Course(); course3.setName("Acceso a Datos");
        Course course4 = new Course(); course4.setName("Inglés");
        Course course5 = new Course(); course5.setName("Servicios y Procesos");
        return Set.of(course1, course2, course3, course4, course5);
    }

}
