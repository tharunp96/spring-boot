package com.sprinboot.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprinboot.model.User;

public interface UserService {

	public User save(User user);

	public ResponseEntity<List<User>> getUserBySurname(String surname);

	public ResponseEntity<List<User>> getUserByPincode(Long pinCode);

	public ResponseEntity<List<User>> getUserByName(String firstName);

	public ResponseEntity<List<User>> sortUserInDescByDob();

	public ResponseEntity<List<User>> sortUserInAscByDob();

	ResponseEntity<List<User>> sortUserInAscByJoiningDate();

	ResponseEntity<List<User>> sortUserInDescByJoiningDate();

	ResponseEntity<List<User>> deleteUserById(Integer id);

	ResponseEntity<List<User>> softDeleteUserById(Integer id);

	ResponseEntity<List<User>> findByFirstNameOrPincodeOrSurname(String firstName, Long pincode, String surname);



}
