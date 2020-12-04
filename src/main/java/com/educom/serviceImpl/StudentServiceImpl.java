package com.educom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educom.entity.Student;
import com.educom.exception.ResourceNotFoundException;
import com.educom.repository.StudentRepository;
import com.educom.service.StudentService;
import com.educom.util.EducomGenerator;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	@Transactional
	public Student getStudent(Long studentId) throws ResourceNotFoundException {
		return studentRepository.findById(studentId).get();
	}

	@Override
	@Transactional
	public void deleteStudent(Long studentId) throws ResourceNotFoundException {
		if(studentId!=null) {
			studentRepository.deleteById(studentId);
		}
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	@Transactional
	public Student findStudentByUserUUID(String userUUID) {
		return studentRepository.findStudentByUUID(userUUID);
	}

	@Override
	public void createStudentId(Student student) {
		String studentId = EducomGenerator.generateStudentId(student.getStudentClass().getCourseCode(), student.getUserId());
		student.setStudentId(studentId);
		studentService.saveStudent(student);
	}

	@Override
	public List<Student> findStudentByIdAndName(String keyword) {
		return studentRepository.findStudentByIdAndName(keyword);
	}
}


