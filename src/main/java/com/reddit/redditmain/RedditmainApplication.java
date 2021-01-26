package com.reddit.redditmain;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.reddit.redditmain.repository.TodoListRepository;
import com.reddit.redditmain.Models.*;
import com.reddit.redditmain.dto.Tasks;

import org.modelmapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class RedditmainApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RedditmainApplication.class, args);
	}

	@Bean
	@Scope("prototype")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}

// MongoDB User Password - bgAQvCWTXkSrZdCC