package com.ngolajr.taskmanager.model;

import com.ngolajr.taskmanager.dto.TaskDto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String creationDate;
    private String lastModifiedAt;

    public Task taskDtoToTask(TaskDto dto){
        return new Task(0,dto.title(), dto.content(), dto.creationDate(), dto.lastModifiedAt());
    }
}