package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Note;
import com.example.demo.model.User;
import com.example.demo.repository.NoteRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class NotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository, NoteRepository noteRepository) {
		return args -> {
			
			User user = new User("Anna", "anna@gmail.com", "ciaociao");
			
			userRepository.save(user);
			
			noteRepository.save(new Note("Fare la spesa", user));
			
		};
	}*/

}
