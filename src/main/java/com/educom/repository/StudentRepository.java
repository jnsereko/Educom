package com.educom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.educom.entity.Student;

@Transactional
public interface StudentRepository extends UserBaseRepository<Student>{

	@Query("select u from Student u where u.userUUID = :userUUID")
	 public Student findStudentByUUID(@Param("userUUID") String userUUID);
	
	@Query("select u from Student u where concat(u.userId, ' ', u.firstName, ' ', ' ', u.lastName, ' ', u.studentId) like %?1%")	
	public List<Student> findStudentByIdAndName(String keyword);
}
