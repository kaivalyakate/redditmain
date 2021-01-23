package com.reddit.redditmain.Models;

import java.time.LocalTime;

import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@Document(collection = "Task")
public class Task {

    @Id
    private String id;
    @NonNull
    private String task;
    @NonNull
    private String addTime;

    public void setId(String id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getId() {
        return this.id;
    }

    public String getTask() {
        return this.task;
    }

    public String getAddTime() {
        return this.addTime;
    }

}
