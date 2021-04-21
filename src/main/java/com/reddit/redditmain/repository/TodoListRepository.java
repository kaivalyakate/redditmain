package com.reddit.redditmain.repository;

import com.reddit.redditmain.Models.Task;
import com.reddit.redditmain.dto.*;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoListRepository extends MongoRepository<Task, String> {
    
}
