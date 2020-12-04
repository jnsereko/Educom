package com.educom.service;

import java.util.List;

import com.educom.entity.Student;
import com.educom.exception.ResourceNotFoundException;

public interface StudentService {

	public void saveStudent(Student student);

    public Student getStudent(Long userId) throws ResourceNotFoundException;

    public void deleteStudent(Long userId) throws ResourceNotFoundException;

	public List<Student> getAllStudents();

	Student findStudentByUserUUID(String userUUID);

	public void createStudentId(Student student);

	public List<Student> findStudentByIdAndName(String keyword);
}
