package com.sprinboot.controller.delete;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.model.User;
import com.sprinboot.service.UserServiceImpl;
@RestController
@RequestMapping("/softDeleteUser")
public class SoftDeleteUserController {

	private UserServiceImpl userService;

	public SoftDeleteUserController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	}
    @DeleteMapping("id/{id}")
	public ResponseEntity<List<User>> softDeleteById(@PathVariable("id") Integer id) {
		return userService.softDeleteUserById(id);
	}

}
