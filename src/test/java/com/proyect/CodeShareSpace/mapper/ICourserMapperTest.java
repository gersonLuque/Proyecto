package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.CourseDTO;
import com.proyect.CodeShareSpace.persistence.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ICourserMapperTest {

    private ICourseMapper iCourseMapper;

    // Se inicializa en cada test
    @BeforeEach
    void init(){
        iCourseMapper = Mockito.mock(ICourseMapper.class);
    }

    @Test
    void testCourseToCourseDto() {
        // Given
        Course course = DataProvider.newCourseMock();

        // When
        Mockito.when(iCourseMapper.courseToCourseDto(any(Course.class))).thenReturn(DataProvider.newCourseDTOMock());
        CourseDTO courseDto = iCourseMapper.courseToCourseDto(course);

        // Then
        Mockito.verify(this.iCourseMapper, Mockito.times(1)).courseToCourseDto(any(Course.class)); // Verifica que llega una clase Course
        assertNotNull(courseDto);
        assertInstanceOf(CourseDTO.class, courseDto);
        assertEquals(1L, courseDto.getCourseId());
        assertEquals("Matemáticas", courseDto.getName());
    }

    @Test
    void testCourseDtoToCourse() {
        // Given
        CourseDTO courseDto = DataProvider.newCourseDTOMock();

        // When
        Mockito.when(iCourseMapper.courseDtoToCourse(any(CourseDTO.class))).thenReturn(DataProvider.newCourseMock());
        Course course = iCourseMapper.courseDtoToCourse(courseDto);

        // Then
        Mockito.verify(this.iCourseMapper).courseDtoToCourse(any(CourseDTO.class)); // Verifica que llega una clase CourseDTO
        assertNotNull(course);
        assertInstanceOf(Course.class, course);
        assertEquals(3L, course.getCourseId());
        assertEquals("Programación", course.getName());
    }


}
