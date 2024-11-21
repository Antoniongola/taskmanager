package com.ngolajr.taskmanager.model;

import com.ngolajr.taskmanager.dto.TaskDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    @CurrentTimestamp
    private String lastModifiedAt;

    public Task taskDtoToTask(TaskDto dto){
        Task task = new Task();
        if(dto.lastModifiedAt().isEmpty())
            task.setLastModifiedAt(dto.lastModifiedAt());

        return new Task(0,dto.title(), dto.content(), dto.lastModifiedAt());
    }
}
