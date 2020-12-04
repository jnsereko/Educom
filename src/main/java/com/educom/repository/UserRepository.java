package com.educom.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.educom.entity.User;

@Repository("userRepository")
@Transactional
public interface UserRepository extends UserBaseRepository<User> {

	@Query("select u from User u where u.userName = :userName and u.userPassword = :userPassword")
	 public User findByUserNameAndUserPassword(@Param("userName") String userName, 
			 				@Param("userPassword") String userPassword);

}
