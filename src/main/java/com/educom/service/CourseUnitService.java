package com.educom.service;

import java.util.List;

import com.educom.entity.CourseUnit;
import com.educom.exception.ResourceNotFoundException;

public interface CourseUnitService {

	public void saveCourseUnit(CourseUnit courseUnit);

    public CourseUnit getCourseUnit(Long courseUnitId) throws ResourceNotFoundException;

    public void deleteCourseUnit(Long courseUnitId) throws ResourceNotFoundException;

	public List<CourseUnit> getCourseUnits();

	CourseUnit findCourseUnitByUnitUUID(String unitUUID);

	public List<CourseUnit> findCourseUnitByIdCodeOrName(String keyword);
}
