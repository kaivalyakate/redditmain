package com.reddit.redditmain.Controller;

import java.util.ArrayList;
import java.util.List;

import com.reddit.redditmain.dto.Tasks;
import com.reddit.redditmain.Models.*;
import com.reddit.redditmain.repository.TodoListRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/tasks")
    public List<Tasks> getTodoList() {
        List<Task> t1 = todoListRepository.findAll();
        List<Tasks> t2 = new ArrayList<>();
        for (Task a1 : t1) {
            t2.add(modelMapper.map(a1, Tasks.class));
        }
        return t2;
    }
}
