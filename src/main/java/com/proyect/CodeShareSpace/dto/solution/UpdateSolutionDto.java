package com.proyect.CodeShareSpace.dto.solution;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateSolutionDto {
    private Long solutionId;
    private boolean anonymous;
    private List<MultipartFile> files;
}
