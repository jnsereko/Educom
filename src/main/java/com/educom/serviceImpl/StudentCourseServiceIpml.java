package com.educom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educom.entity.EducomRole;
import com.educom.entity.StudentCourse;
import com.educom.exception.ResourceNotFoundException;
import com.educom.repository.StudentCourseRepository;
import com.educom.service.StudentCourseService;

@Service
public class StudentCourseServiceIpml implements StudentCourseService{
	
	@Autowired
	private StudentCourseRepository studentCourseRepository;

	@Override
	@Transactional
	public void saveStudentCourse(StudentCourse studentCourse) {
		studentCourseRepository.save(studentCourse);
	}

	@Override
	@Transactional
	public StudentCourse getStudentCourse(Long studentCourseId) throws ResourceNotFoundException {
		return studentCourseRepository.findById(studentCourseId).get();
	}

	@Override
	@Transactional
	public void deleteStudentCourseById(Long studentCourseId) throws ResourceNotFoundException {
		studentCourseRepository.deleteById(studentCourseId);
	}

	@Override
	@Transactional
	public void saveCustomer(StudentCourse course) {
		studentCourseRepository.save(course);
	}

	@Override
	@Transactional
	public List<StudentCourse> getStudentCourses() {
		return studentCourseRepository.findAll();
	}
	
	@Override
	@Transactional
	public StudentCourse findStudentCourseByUUID(String courseUUID) {
		return studentCourseRepository.findStudentCourseByUUID(courseUUID);
	}

	@Override
	@Transactional
	public List<StudentCourse> findStudentCourseByIdCodeAndName(String keyword) {
		return studentCourseRepository.findStudentCourseByIdCodeAndName(keyword);
	}
}
