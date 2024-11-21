package com.ngolajr.taskmanager.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ngolajr.taskmanager.dto.TaskDto;
import com.ngolajr.taskmanager.model.Task;
import com.ngolajr.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("")
    public ResponseEntity<Task> newTask(@RequestBody TaskDto dto) {
        return ResponseEntity.ok(taskService.newTask(dto));
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        return ResponseEntity.ok(taskService.getTask(Long.parseLong(id)));
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody TaskDto dto) {
        return ResponseEntity.ok(taskService.updateTask(Long.parseLong(id), dto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        taskService.deleteTaskById(Long.parseLong(id));
    }

    @DeleteMapping("/all")
    public void deleteAllTasks(){
        taskService.deleteAllTasks();
    }
}
