package com.sprinboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.model.User;
import com.sprinboot.service.UserServiceImpl;

@RestController
@RequestMapping("/sortUserBy")
public class SortUserController {
	private UserServiceImpl userService;

	public SortUserController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/{columnName}/{sortType}")
	public ResponseEntity<List<User>> sortUserInsortTypeByColumnName(@PathVariable("sortType") String sortType,
			@PathVariable("columnName") String columnName) {
		if (columnName.equals("dob")) {
			if (sortType.equals("asc")) {
				return userService.sortUserInAscByDob();
			} else if (sortType.equals("desc")) {
				return userService.sortUserInDescByDob();
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else if (columnName.equals("joiningDate")) {
			if (sortType.equals("asc")) {
				return userService.sortUserInAscByJoiningDate();
			} else if (sortType.equals("desc")) {
				return userService.sortUserInDescByJoiningDate();
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
