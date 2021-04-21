package com.reddit.redditmain.Controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.reddit.redditmain.dto.Tasks;
import com.reddit.redditmain.Models.*;
import com.reddit.redditmain.repository.TodoListRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TaskController {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/tasks")
    public List<Tasks> getTodoList() {
        List<Task> t1 = todoListRepository.findAll();
        List<Tasks> t2 = new ArrayList<>();
        for (Task a : t1) {
            t2.add(modelMapper.map(a, Tasks.class));
        }
        return t2;
    }

    @PostMapping(value = "/tasks")
    public ResponseEntity<Object> addTask(@RequestBody Task task) {
        // TODO: process POST request
        if (task.getTask() != null && !task.getTask().equals("")) {
            task.setId(generateRandomAlphaString());
            todoListRepository.save(task);
            return ResponseEntity.ok().body("Added");
        }
        return ResponseEntity.badRequest().body("Null Task");
    }

    @PutMapping(value = "path/{id}")
    public ResponseEntity<Object> putTask(@PathVariable String id, @RequestBody Task task) {
        // TODO: process PUT request
        if (todoListRepository.existsById(id)) {
            todoListRepository.deleteById(id);
            todoListRepository.save(task);
            return ResponseEntity.ok().body("Updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Found Not");
    }

    public String generateRandomAlphaString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 25;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return generatedString;
    }

}
