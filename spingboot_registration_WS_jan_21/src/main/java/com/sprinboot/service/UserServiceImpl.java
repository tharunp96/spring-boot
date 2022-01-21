package com.sprinboot.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sprinboot.controller.delete.DeleteUserController;
import com.sprinboot.exception.ResourceNotFoundException;
import com.sprinboot.model.User;
import com.sprinboot.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {

		User savedUser = new User(user.getFirstName(), user.getSurname(), user.getEmail(), user.getPassword(),
				user.getPincode(), user.getDob(), user.getJoiningdate());

		return userRepository.save(savedUser);
	}

	@Override
	public ResponseEntity<List<User>> getUserByPincode(@PathVariable("pincode") Long pincode) {
		List<User> users = userRepository.getUserByPincode(pincode);

		if (users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<User>> getUserBySurname(String surname) {
		logger.info("GetUserBySurname In Service surname --->" + surname);
		logger.info("GetUserBySurname In Service userRepository--->" + userRepository);
		List<User> users = userRepository.getUserBySurname(surname);

		if (users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<User>> getUserByName(String firstName) {
		List<User> users = userRepository.getUserByName(firstName);

		if (users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<User>> sortUserInDescByDob() {
		List<User> sortedUsersByDOB = userRepository.findAll(Sort.by(Sort.Direction.DESC, "dob"));

		if (sortedUsersByDOB != null) {
			return new ResponseEntity<>(sortedUsersByDOB, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<List<User>> sortUserInAscByDob() {
		List<User> sortedUsersByDOB = userRepository.findAll(Sort.by(Sort.Direction.ASC, "dob"));

		if (sortedUsersByDOB != null) {
			return new ResponseEntity<>(sortedUsersByDOB, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<List<User>> sortUserInAscByJoiningDate() {
		List<User> sortedUsersByDOB = userRepository.findAll(Sort.by(Sort.Direction.ASC, "joiningdate"));

		if (sortedUsersByDOB != null) {
			return new ResponseEntity<>(sortedUsersByDOB, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<User>> sortUserInDescByJoiningDate() {
		List<User> sortedUsersByDOB = userRepository.findAll(Sort.by(Sort.Direction.DESC, "joiningdate"));

		if (sortedUsersByDOB != null) {
			return new ResponseEntity<>(sortedUsersByDOB, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<List<User>> deleteUserById(Integer id) {
		Logger logger = LoggerFactory.getLogger(DeleteUserController.class);
		try {

			logger.info("deleteUserById -->Deleting user");
			userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("user with id " + id + " not found "));
			userRepository.deleteUserById(id);
			logger.info("userRepository.findById(id)-->" + userRepository.findById(id));
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			logger.info("ResourceNotFoundException" + e.getStackTrace());
			return ResponseEntity.noContent().build();
		}
	}

	@Override
	public ResponseEntity<List<User>> softDeleteUserById(Integer id) {
		try {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("user with id " + id + " not found "));
			user.setDeleted(true);
			userRepository.save(user);
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			if (ex instanceof ResourceNotFoundException) {
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.noContent().build();
	}
    
	@Override 
	public ResponseEntity<List<User>> findByFirstNameOrPincodeOrSurname(String firstName,Long pincode, String surname) {
		// TODO Auto-generated method stub

		List<User> usersByNameOrPincodeOrPrice = userRepository.findByFirstNameOrPincodeOrSurname(firstName, pincode, surname);
		if (usersByNameOrPincodeOrPrice != null) {
			return new ResponseEntity<>(usersByNameOrPincodeOrPrice, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
