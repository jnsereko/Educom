package com.educom.entity;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.educom.util.EducomGenerator;

@Entity
@Table(name="course_units")
public class CourseUnit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "unit_id")
	private Long unitId;
	
	@Column(name = "unit_code")
	private String unitCode;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "unit_uuid")
	private String unitUUID;
		
    @ManyToMany(mappedBy="subjects")
	private Set<Student> students;
	
	@ManyToMany(mappedBy = "courseUnits")
	private Set<Lecturer> lecturers;
	
	@ManyToMany(mappedBy="subjects")
	private Set<StudentCourse> studentCourse;

	
	public CourseUnit() {
		setUnitUUID(EducomGenerator.generateUuid().toString());
	}
	
	/**
	 * @return the unitUUID
	 */
	public String getUnitUUID() {
		return unitUUID;
	}

	/**
	 * @param unitUUID the unitUUID to set
	 */
	public void setUnitUUID(String unitUUID) {
		this.unitUUID = unitUUID;
	}



	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(Set<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Set<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	@Override
	public String toString() {
		return "CourseUnit [unitId=" + unitId + ", unitCode=" + unitCode + ", unitName=" + unitName + "]";
	}

}
