package com.educom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educom.entity.Lecturer;
import com.educom.entity.Student;
import com.educom.exception.ResourceNotFoundException;
import com.educom.repository.LecturerRepository;
import com.educom.service.LecturerService;
import com.educom.util.EducomGenerator;

@Service
public class LecturerServiceImpl implements LecturerService{
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
	@Autowired
	private LecturerService lecturerService;

	@Override
	@Transactional
	public void saveLecturer(Lecturer lecturer) {
		lecturerRepository.save(lecturer);
	}

	@Override
	@Transactional
	public Lecturer getLecturer(Long userId) throws ResourceNotFoundException {
		return lecturerRepository.findById(userId).get();
	}

	@Override
	@Transactional
	public void deleteLecturee(Long userId) throws ResourceNotFoundException {
		lecturerRepository.deleteById(userId);
	}

	@Override
	public List<Lecturer> getAllLecturers() {
		return lecturerRepository.findAll();
	}
	
	
	@Override
	@Transactional
	public Lecturer findLecturerByUserUUID(String userUUID) {
		return lecturerRepository.findLecturerByUUID(userUUID);
	}
	
	@Override
	public void createLecturerId(Lecturer lecturer) {
		String lecturerId = EducomGenerator.generateLecturerId(lecturer.getWorkingHours(), lecturer.getFirstName(), lecturer.getUserId());
    	lecturer.setLecturerId(lecturerId);
    	lecturerService.saveLecturer(lecturer);
	}

	@Override
	public List<Lecturer> findLecturerByIdOrName(String keyword) {
		return lecturerRepository.findLecturerByIdOrName(keyword);
	}
	
}
