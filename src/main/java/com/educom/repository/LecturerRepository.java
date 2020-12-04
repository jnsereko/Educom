package com.educom.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educom.entity.Lecturer;

@Transactional
public interface LecturerRepository extends UserBaseRepository<Lecturer>{

	@Query("select u from Lecturer u where u.userUUID = :userUUID")
	public Lecturer findLecturerByUUID(@Param("userUUID") String userUUID);

	@Query("select u from Lecturer u where concat(u.userId, ' ', u.firstName,' ', u.lastName, ' ', u.lecturerId) like %?1%")
	public List<Lecturer> findLecturerByIdOrName(String keyword);
}
