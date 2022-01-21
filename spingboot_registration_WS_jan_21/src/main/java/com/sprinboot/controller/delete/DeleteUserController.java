package com.sprinboot.controller.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.exception.ResourceNotFoundException;
import com.sprinboot.repository.UserRepository;
import com.sprinboot.service.UserServiceImpl;

@RestController
@RequestMapping("/deleteUserBy")
public class DeleteUserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
		return userService.deleteUserById(id);
	}
}
