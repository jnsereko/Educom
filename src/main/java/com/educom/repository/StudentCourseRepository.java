package com.educom.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educom.entity.Student;
import com.educom.entity.StudentCourse;

@Repository("studentCourseRepository")
@Transactional
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
	
	@Query("select u from StudentCourse u where u.courseUUID = :courseUUID")
	public StudentCourse findStudentCourseByUUID(@Param("courseUUID") String courseUUID);

	@Query("select u from StudentCourse u where concat(u.studentclassId, ' ', u.studentClassName, ' ', u.courseCode) like %?1%")
	public List<StudentCourse> findStudentCourseByIdCodeAndName(String keyword);
}
