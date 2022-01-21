package com.sprinboot.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sprinboot.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);

	@Query("select u from User AS u where u.surname = :surname")
	List<User> getUserBySurname(@Param("surname") String surname);

	@Query("select u from User AS u where u.pincode = :pincode")
	List<User> getUserByPincode(@Param("pincode") Long pincode);

	@Query("select u from User AS u where u.firstName = ?1")
	List<User> getUserByName(String firstName);

	@Modifying()
	@Query("DELETE FROM User u WHERE u.id = :id")
	void deleteUserById(@Param("id") Integer id);

	List<User> getUserByDob(LocalDate dob);

	List<User> findByFirstNameOrPincodeOrSurname(String firstName, Long pincode, String surname);

}
