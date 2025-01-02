package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.UserDTO;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserControllerTest {

    @Mock
    private IUserService iUserService;
    @InjectMocks
    private UserController userController;

    @BeforeEach
    void init(){
        this.iUserService = Mockito.mock(IUserService.class);
        this.userController = new UserController(iUserService);
    }

    @Test
    public void testFindById(){
        // Given
        Long id = 5L;

        // When
        Mockito.when(iUserService.findById(Mockito.anyLong())).thenReturn(DataProvider.newUserDtoMock());
        UserDTO userDTO = userController.findById(id).getBody();

        // Then
        Mockito.verify(this.iUserService).findById(Mockito.anyLong());
        assertNotNull(userDTO);
        assertInstanceOf(UserDTO.class, userDTO);
        assertEquals("josemanue", userDTO.getUsername());
        assertEquals(1L, userDTO.getUserId());
        assertEquals(Rol.STUDENT, userDTO.getRol());
    }

}
