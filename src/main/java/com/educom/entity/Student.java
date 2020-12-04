package com.educom.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="students")
public class Student extends User{

	@Column(name="student_id")
	private String studentId;
	
	@Column(name="basary")
	private Integer basary;

	@Column(name="tution_change")
	private Integer tutionChange;
	
	@ManyToOne
	@JoinColumn(name = "course_name", referencedColumnName = "student_course_id")
    private StudentCourse studentClass;
	
	@ManyToMany
	@JoinTable(name= "student_course_units", joinColumns = @JoinColumn(name = "student", referencedColumnName="user_id"),
						inverseJoinColumns= @JoinColumn(name="course_units", referencedColumnName="unit_id"))
	private Set<CourseUnit> subjects;
	
	public Student(Long userId) {
		super(userId);
		// TODO Auto-generated constructor stub
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param StudentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}	

	/**
	 * @return  studentId
	 */
	public String getStudentId() {
		return this.studentId;
	}
	/**
	 * @return the tution
	 */
	public Integer getTution() {
		return basary;
	}
	/**
	 * @param tution the tution to set
	 */
	public void setTution(Integer basary) {
		this.basary = basary;
	}
	/**
	 * @return the change
	 */
	public Integer getTutionChange() {
		return tutionChange;
	}
	/**
	 * @param change the change to set
	 */
	public void setTutionChange(Integer change) {
		this.tutionChange = change;
	}
	/**
	 * @return the studentClass
	 */
	public StudentCourse getStudentClass() {
		return studentClass;
	}
	/**
	 * @param studentClass the studentClass to set
	 */
	public void setStudentClass(StudentCourse studentClass) {
		this.studentClass = studentClass;
	}
	/**
	 * @return the subjects
	 */
	public Set<CourseUnit> getSubjects() {
		return subjects;
	}
	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(Set<CourseUnit> subjects) {
		this.subjects = subjects;
	}

	public Integer getBasary() {
		return basary;
	}

	public void setBasary(Integer basary) {
		this.basary = basary;
	}
}
