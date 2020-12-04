package com.educom.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educom.entity.User;
import com.educom.exception.ResourceNotFoundException;
import com.educom.repository.UserRepository;
import com.educom.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public User getUser(Long userId) throws ResourceNotFoundException {
		return (User) userRepository.findById(userId).get();
	}

	@Override
	@Transactional
	public void deleteUsers(Long userId) throws ResourceNotFoundException {
		userRepository.deleteById(userId);
	}
	
	@Override
	@Transactional
	public User findByUserNameAndUserPassword (String userName, String userPassword) {
		return 	userRepository.findByUserNameAndUserPassword(userName, userPassword);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	
	@Override
	public int calculateUserAge(String dateOfBirth) {
		int age = 0;
		try {
			Date birthdate = parseDate(dateOfBirth);
			LocalDate bd =LocalDate.of(birthdate.getYear()+1900, (birthdate.getMonth()+1), birthdate.getDate());
	    	LocalDate now =LocalDate.now();
	    	Period diff = Period.between(bd, now);
			age = diff.getYears();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return age;
	}
	
	@Override
	public Date parseDate(String date) throws ResourceNotFoundException{
			
	    	DateFormat dateFormart = new SimpleDateFormat("yyyy-MM-dd");		
			try {
		    	Date formatedDate = dateFormart.parse(date);
				return formatedDate;
			} catch (ParseException e) {
				throw new ResourceNotFoundException(e);
			}
			
		}
}
