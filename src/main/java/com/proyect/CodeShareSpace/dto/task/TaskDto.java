package com.proyect.CodeShareSpace.dto.task;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class TaskDto {
    private Long taskId;
    private String description;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean visible;
    private String courseName;
    private String nameTeacher;
    private List<FileTasksDto> fileTasks;
}
