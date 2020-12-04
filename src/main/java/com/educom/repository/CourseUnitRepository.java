package com.educom.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educom.entity.CourseUnit;
import com.educom.entity.StudentCourse;
import com.educom.entity.User;

@Repository("courseUnitRepository")
@Transactional
public interface CourseUnitRepository extends JpaRepository<CourseUnit, Long>{

	@Query("select u from CourseUnit u where u.unitUUID = :unitUUID")
	 public CourseUnit findCourseUnitByUnitUUID(@Param("unitUUID") String unitUUID);

	@Query("select u from CourseUnit u where concat(u.unitId, ' ', u.unitCode, ' ', u.unitName) like %?1%")
	public List<CourseUnit> findCourseUniteByIdCodeOrName(String keyword);
}
