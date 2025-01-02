package com.proyect.CodeShareSpace.dto;

import com.proyect.CodeShareSpace.persistence.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long courseId;
    private String name;
    private Set<User> users = new HashSet<>();
}
