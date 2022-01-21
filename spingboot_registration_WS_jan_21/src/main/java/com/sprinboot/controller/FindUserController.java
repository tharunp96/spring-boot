package com.sprinboot.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.model.User;
import com.sprinboot.service.UserServiceImpl;

@RestController
@RequestMapping("/findUserby")
public class FindUserController {
	private UserServiceImpl userService;

	Logger logger = LoggerFactory.getLogger(FindUserController.class);

	public FindUserController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/{columnName}/{searchstring}")
	public ResponseEntity<List<User>> findUserByColumnName(@PathVariable("searchstring") String searchstring,
			@PathVariable("columnName") String columnName) {
		if (null != columnName && columnName.equals("surname")) {
			return userService.getUserBySurname(searchstring);
		} else if (null != columnName && columnName.equals("pincode")) {
			return userService.getUserByPincode(Long.valueOf(searchstring));
		}

		else if (null != columnName && columnName.equals("firstName")) {
			return userService.getUserByName(searchstring);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/firstnameorpicodeorsurname")
	public ResponseEntity<List<User>> findByFirstNameOrPincodeOrSuranme(@RequestParam String firstName, 
				@RequestParam Long pincode,	
				@RequestParam String surname) {
		return userService.findByFirstNameOrPincodeOrSurname(firstName, pincode, surname);
	}
	
}
