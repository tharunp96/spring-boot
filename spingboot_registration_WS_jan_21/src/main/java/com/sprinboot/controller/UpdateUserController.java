package com.sprinboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.exception.ResourceNotFoundException;
import com.sprinboot.model.User;
import com.sprinboot.repository.UserRepository;

@RestController
@RequestMapping("/updateUserBy")
@Transactional
public class UpdateUserController {
	@Autowired
	UserRepository userRepository;

	@PostMapping(value = "/id/{id}")

	public ResponseEntity<User> updateuser(@PathVariable(value = "id") Integer userId,
			@Valid @RequestBody User userDetails) {
		User user;
		try {
			user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
			user.setFirstName(userDetails.getFirstName());
			user.setSurname(userDetails.getSurname());
			user.setEmail(userDetails.getEmail());
			user.setPincode(userDetails.getPincode());
			user.setPassword(userDetails.getPassword());
			user.setDob(userDetails.getDob());
			user.setJoiningdate(userDetails.getJoiningdate());
			return ResponseEntity.ok(userRepository.save(user));

		} catch (ResourceNotFoundException e) {
			return null;
		}

	}

}
