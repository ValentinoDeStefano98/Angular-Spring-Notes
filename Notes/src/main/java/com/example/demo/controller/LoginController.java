package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.LoginRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User userData){
		
		System.out.println(userData);
		
		User user=loginRepository.findByEmail(userData.getEmail());
		
		if(user.getPassword().equals(userData.getPassword())) {
			return ResponseEntity.ok(user);
		}
		
		return (ResponseEntity<User>) ResponseEntity.internalServerError();
		
	}

}
