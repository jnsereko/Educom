package com.educom.service;

import java.util.List;

import com.educom.entity.StudentCourse;
import com.educom.exception.ResourceNotFoundException;

public interface StudentCourseService {

	public void saveStudentCourse(StudentCourse studentCourse);

    public StudentCourse getStudentCourse(Long studentCourseId) throws ResourceNotFoundException;

    public void deleteStudentCourseById(Long studentCourseId) throws ResourceNotFoundException;

	public void saveCustomer(StudentCourse course);

	public List<StudentCourse> getStudentCourses();

	StudentCourse findStudentCourseByUUID(String courseUUID);

	public List<StudentCourse> findStudentCourseByIdCodeAndName(String keyword);
}
