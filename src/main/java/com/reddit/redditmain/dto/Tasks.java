package com.reddit.redditmain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonPropertyOrder({ "id", "task", "addTime" })
public class Tasks {
    @JsonProperty("id")
    private String id;
    @JsonProperty("task")
    private String task;
    @JsonProperty("addTime")
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
