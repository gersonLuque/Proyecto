package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.UserDTO;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class IUserMapperTest {

    private IUserMapper iUserMapper;

    @BeforeEach
    void init(){
        this.iUserMapper = Mockito.mock(IUserMapper.class);
    }

    @Test
    public void testUserToUserDto() {
        // Given
        User user = DataProvider.newUserMock();

        // When
        Mockito.when(iUserMapper.userToUserDto(any(User.class))).thenReturn(DataProvider.newUserDtoMock());
        UserDTO userDTO = iUserMapper.userToUserDto(user);

        // Then
        Mockito.verify(this.iUserMapper).userToUserDto(any(User.class));
        assertNotNull(userDTO);
        assertInstanceOf(UserDTO.class, userDTO);
        assertEquals(1L, userDTO.getUserId());
        assertEquals("josemanue", userDTO.getUsername());
        assertEquals("j123", userDTO.getPassword());
        assertEquals("Juan Pérez", userDTO.getCompleteName());
        assertEquals(Rol.STUDENT, userDTO.getRol());
        assertEquals(5, userDTO.getCourses().size());
    }

    @Test
    public void testUserDtoToUser() {
        // Given
        UserDTO userDTO = DataProvider.newUserDtoMock();

        // When
        Mockito.when(iUserMapper.userDtoToUser(any(UserDTO.class))).thenReturn(DataProvider.newUserMock());
        User user = iUserMapper.userDtoToUser(userDTO);

        // Then
        Mockito.verify(this.iUserMapper).userDtoToUser(any(UserDTO.class));
        assertNotNull(user);
        assertInstanceOf(User.class, user);
        assertEquals(10L, user.getUserId());
        assertEquals("anaFrank08", user.getUsername());
        assertEquals("cacahuete", user.getPassword());
        assertEquals("Ana Cisneros", user.getCompleteName());
        assertEquals(Rol.TEACHER, user.getRol());
        assertTrue(user.getCourses().isEmpty());
    }

    @Test
    public void testUsersToUsersDto() {
        // Given
        List<User> userList = new ArrayList<>(); // Da igual que este vacía, se devolverá la generada por el DataProvider

        // When
        Mockito.when(iUserMapper.usersToUsersDto(any(List.class))).thenReturn(DataProvider.newUsersDtoListMock());
        List<UserDTO> userDTOList = iUserMapper.usersToUsersDto(userList);

        // Then
        Mockito.verify(this.iUserMapper, Mockito.times(1)).usersToUsersDto(any(List.class));
        assertNotNull(userDTOList);
        assertFalse(userDTOList.isEmpty());
        assertEquals("alfredoRomeroma12", userDTOList.get(0).getUsername());
        assertEquals("ffff", userDTOList.get(3).getUsername());
    }

}
