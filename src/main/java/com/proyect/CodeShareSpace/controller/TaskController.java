package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.dto.solution.SolutionDto;
import com.proyect.CodeShareSpace.dto.task.CreateTaskDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.dto.task.UpdateTaskDto;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin("*")
public class TaskController {
    @Autowired
    private ITaskService iTaskService;

    @Autowired
    private ISolutionService iSolutionService;

    @Autowired
    private IS3Service is3Service;

    @GetMapping("{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId){
        return new ResponseEntity<>(iTaskService.findById(taskId), HttpStatus.OK);
    }
    @GetMapping("{taskId}/solutions")
    public ResponseEntity<List<SolutionDto>> getSolutionsByTaskId(@PathVariable Long taskId){
        return new ResponseEntity<>(iSolutionService.getSolutionsByTaskId(taskId),HttpStatus.OK);
    }
    @GetMapping("{taskId}/solutions/{userId}")
    public ResponseEntity<SolutionDto> getSolutionByUserAndTask(@PathVariable Long taskId, @PathVariable Long userId){
        return ResponseEntity.ok(iSolutionService.getSolutionByUserAndTask(taskId,userId));
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@ModelAttribute CreateTaskDto createTaskDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iTaskService.createTask(createTaskDto));
    }

    @PutMapping
    public ResponseEntity<TaskDto> updateTask(@ModelAttribute UpdateTaskDto updateTaskDto){
        return ResponseEntity.ok(iTaskService.updateTask(updateTaskDto));
    }
}
