package org.tbd.fifth.group.volunteer.controllers;

import org.springframework.web.bind.annotation.*;
import org.tbd.fifth.group.volunteer.models.TaskModel;
import org.tbd.fifth.group.volunteer.services.TaskService;

@RestController
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    @ResponseBody
    public TaskModel createTask(@RequestBody TaskModel task) {
        return taskService.createTask(task);
    }

    @GetMapping("/task/{task_id}")
    @ResponseBody
    public TaskModel getTask(@PathVariable int task_id) {
        return taskService.getTask(task_id);
    }
}
