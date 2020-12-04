package com.educom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educom.entity.CourseUnit;
import com.educom.exception.ResourceNotFoundException;
import com.educom.repository.CourseUnitRepository;
import com.educom.service.CourseUnitService;

@Service
public class CourseUnitServiceImpl implements CourseUnitService{
	
	@Autowired
	private CourseUnitRepository courseUnitRepository;

	@Override
	@Transactional
	public void saveCourseUnit(CourseUnit courseUnitService) {
		courseUnitRepository.save(courseUnitService);
	}

	@Override
	@Transactional
	public CourseUnit getCourseUnit(Long courseUnitId) throws ResourceNotFoundException {
		return courseUnitRepository.findById(courseUnitId).get();
	}

	@Override
	@Transactional
	public void deleteCourseUnit(Long courseUnitId) throws ResourceNotFoundException {
		courseUnitRepository.deleteById(courseUnitId);
	}

	@Override
	@Transactional
	public List<CourseUnit> getCourseUnits() {
		return courseUnitRepository.findAll();
	}
	
	@Override
	@Transactional
	public CourseUnit findCourseUnitByUnitUUID(String unitUUID) {
		return courseUnitRepository.findCourseUnitByUnitUUID(unitUUID);
	}

	@Override
	public List<CourseUnit> findCourseUnitByIdCodeOrName(String keyword) {
		return courseUnitRepository.findCourseUniteByIdCodeOrName(keyword);
	}
}
