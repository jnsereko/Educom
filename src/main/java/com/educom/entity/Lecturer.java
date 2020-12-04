package com.educom.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="lecturers")
public class Lecturer extends User{
	
	@Column(name="lecture_id")
	private String lecturerId;
	
	@Column(name = "salary")
	private Integer salary;
	
	/**
	 * @return the lecturerId
	 */
	public String getLecturerId() {
		return lecturerId;
	}
	/**
	 * @param lecturerId the lecturerId to set
	 */
	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
	}
	@Column(name = "salary_change")
	private Integer salaryChange;	

	@Column(name = "working_hours")
	private int workingHours;
	
	@ManyToMany
	@JoinTable(name= "lecturer_course_units", joinColumns = @JoinColumn(name = "lecturer_unit", referencedColumnName="user_id"),
						inverseJoinColumns= @JoinColumn(name="course_units_taught", referencedColumnName="unit_id"))
	private Set<CourseUnit> courseUnits;
	
	@ManyToMany
	@JoinTable(name= "lecturer_classes", joinColumns = @JoinColumn(name = "lecturer_class", referencedColumnName="user_id"),
						inverseJoinColumns= @JoinColumn(name="classes_taught", referencedColumnName="student_course_id"))
	private Set<StudentCourse> classesTaught;
	
	@OneToMany(mappedBy="lecturer")
	private Set<EducomRole> roles;
	
	public Lecturer (Long userId) {
		super(userId);
	}
	public Lecturer() {
		super();
	}
	/**
	 * @return the classesTaught
	 */
	public Set<StudentCourse> getClassesTaught() {
		return classesTaught;
	}
	/**
	 * @param classesTaught the classesTaught to set
	 */
	public void setClassesTaught(Set<StudentCourse> classesTaught) {
		this.classesTaught = classesTaught;
	}
	
	public Integer getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(Integer workingHours) {
		this.workingHours = workingHours;
	}
	public Set<CourseUnit> getCourseUnits() {
		return courseUnits;
	}
	public void setCourseUnits(Set<CourseUnit> courseUnits) {
		this.courseUnits = courseUnits;
	}
	public Set<EducomRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<EducomRole> roles) {
		this.roles = roles;
	}
	/**
	 * @return the salary
	 */
	public Integer getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	/**
	 * @return the change
	 */
	public Integer getSalaryChange() {
		return salaryChange;
	}
	/**
	 * @param change the change to set
	 */
	public void setSalaryChange(Integer salaryChange) {
		this.salaryChange = salaryChange;
	}

	/**
	 * @param workingHours the workingHours to set
	 */
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

}
