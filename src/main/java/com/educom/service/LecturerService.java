package com.educom.service;

import java.util.List;

import com.educom.entity.Lecturer;
import com.educom.exception.ResourceNotFoundException;

public interface LecturerService {

	void saveLecturer(Lecturer lecturer);

	Lecturer getLecturer(Long userId) throws ResourceNotFoundException;

	void deleteLecturee(Long userId) throws ResourceNotFoundException;

	List<Lecturer> getAllLecturers();

	void createLecturerId(Lecturer lecturer);

	Lecturer findLecturerByUserUUID(String userUUID);

	List<Lecturer> findLecturerByIdOrName(String keyword);

}
