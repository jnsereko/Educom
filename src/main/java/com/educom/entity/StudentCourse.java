package com.educom.entity;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.educom.util.EducomGenerator;

@Entity
@Table(name="student_courses")
public class StudentCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_course_id")
	private Long studentclassId;
	
	@Column(name = "student_course_name")
	private String studentClassName;
	
	@Column(name = "course_code")
	private String courseCode;
	
	@Column(name = "course_uuid")
	private String courseUUID;

	@Column(name="tution")
	private Integer tution;
	
	@ManyToMany(mappedBy="classesTaught")
	private Set<Lecturer> lecturers;
	
	@ManyToMany
	@JoinTable(name= "class_subjects", joinColumns = @JoinColumn(name = "class", referencedColumnName="student_course_id"),
						inverseJoinColumns= @JoinColumn(name="class_course_units", referencedColumnName="unit_id"))
	private Set<CourseUnit> subjects;
	
	@OneToMany(mappedBy="studentClass")
	@OrderBy("student_id asc")
	private Set<Student> students;
	
	public StudentCourse() {
		setCourseUUID(EducomGenerator.generateUuid().toString());
	}
	
	/**
	 * @return the studentclassId
	 */
	public Long getStudentclassId() {
		return studentclassId;
	}
	/**
	 * @param studentclassId the studentclassId to set
	 */
	public void setStudentclassId(Long studentclassId) {
		this.studentclassId = studentclassId;
	}
	/**
	 * @return the studentClassName
	 */
	public String getStudentClassName() {
		return studentClassName;
	}
	/**
	 * @param studentClassName the studentClassName to set
	 */
	public void setStudentClassName(String studentClassName) {
		this.studentClassName = studentClassName;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public Integer getTution() {
		return tution;
	}
	public void setTution(Integer tution) {
		this.tution = tution;
	}
	public Set<Lecturer> getLecturers() {
		return lecturers;
	}
	public void setLecturers(Set<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}
	public Set<CourseUnit> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<CourseUnit> subjects) {
		this.subjects = subjects;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	/**
	 * @return the courseUUID
	 */
	public String getCourseUUID() {
		return courseUUID;
	}
	/**
	 * @param courseUUID the courseUUID to set
	 */
	public void setCourseUUID(String courseUUID) {
		this.courseUUID = courseUUID;
	}
}