package com.sprinboot.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.model.User;
import com.sprinboot.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/registration", produces = { MediaType.APPLICATION_JSON_VALUE })

public class RegisterUserController {

	private UserServiceImpl userService;

	public RegisterUserController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registrationAccount(@RequestBody() User user) {
		try {
			userService.save(user);
		} catch (Exception ex) {
			if (ex instanceof ConstraintViolationException) {
				return "Email Id Already Exists";
			} else if (ex instanceof IllegalArgumentException) {
				return "Cannot Register as" + ex.getCause();
			} else if (ex instanceof ValidationException) {
				return "Cannot Register as---" + ex.getMessage();
			}
		}
		return "Registered Successfully";
	}
	//TODO:
}
