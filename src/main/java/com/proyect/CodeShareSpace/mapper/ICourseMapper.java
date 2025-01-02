package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.CourseDTO;
import com.proyect.CodeShareSpace.persistence.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ICourseMapper {

    ICourseMapper INSTANCE = Mappers.getMapper(ICourseMapper.class);

    Course courseDtoToCourse(CourseDTO courseDto);

    CourseDTO courseToCourseDto(Course course);

}
