package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.UserDTO;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseControllerTest {

    @Mock
    private ICourseService iCourseService;
    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    void init(){
        this.iCourseService = Mockito.mock(ICourseService.class);
        this.courseController = new CourseController(iCourseService);
    }

    @Test
    public void testGetUsersByCourse(){
        // Given
        Long id = 1L;

        // When
        Mockito.when(this.iCourseService.findUsersByCourseId(Mockito.anyLong())).thenReturn(DataProvider.usersToSearchMock());
        ResponseEntity<List<UserDTO>> userDTOList = courseController.getUsersByCourse(id);

        // Then
        Mockito.verify(this.iCourseService).findUsersByCourseId(Mockito.anyLong());
        assertNotNull(userDTOList);
        assertTrue(userDTOList.hasBody());
        assertEquals("cristianoRonaldo7", userDTOList.getBody().get(0).getUsername());
    }

}
