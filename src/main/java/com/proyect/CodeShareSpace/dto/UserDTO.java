package com.proyect.CodeShareSpace.dto;

import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private String completeName;
    private Rol rol;
    private Set<Course> courses;
}
