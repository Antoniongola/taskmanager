package com.ngolajr.taskmanager.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ngolajr.taskmanager.dto.TaskDto;
import com.ngolajr.taskmanager.model.Task;
import com.ngolajr.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
     private final TaskRepository taskRepository;

     public Task newTask(TaskDto dto){
        Task task = new Task();
        Task taskToPersist = task.taskDtoToTask(dto);
        
        return taskRepository.save(taskToPersist);
     }

     public Task getTask(long id){
      return taskRepository.findById(id).orElseThrow();
     }

     public List<Task> getAllTasks(){
      return taskRepository.findAll();
     }

     public Task updateTask(long id, TaskDto dto){
      Task task = new Task();
      Task updatedTask = task.taskDtoToTask(dto);
         if(taskRepository.existsById(id))
            return taskRepository.save(updatedTask);
         
         return null;
     }

     public void deleteTaskById(long id){
      if(taskRepository.existsById(id))
         taskRepository.deleteById(id);
     }

     public void deleteAllTasks(){
      taskRepository.deleteAll();
     }
}
