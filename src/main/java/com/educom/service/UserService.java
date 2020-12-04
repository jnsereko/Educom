package com.educom.service;

import java.util.Date;
import java.util.List;

import com.educom.entity.User;
import com.educom.exception.ResourceNotFoundException;

public interface UserService {

	void saveUser(User user);

	User getUser(Long userId) throws ResourceNotFoundException;

	void deleteUsers(Long userId) throws ResourceNotFoundException;

	User findByUserNameAndUserPassword(String userName, String userPassword);

	 List<User> getAllUsers();

	int calculateUserAge(String dateOfBirth);

	Date parseDate(String date) throws ResourceNotFoundException;	
}
