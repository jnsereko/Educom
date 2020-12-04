package com.educom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.educom.util.EducomGenerator;

@Entity
@Table(name="educom_roles")
public class EducomRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "educom_role_id")
	private Long roleId;
	
	@Column(name="educom_role_name")
	private String roleName;
	
	@Column(name="educom_role_uuid")
	private String roleUUID;
	
	@ManyToOne
	@JoinColumn(name="lecturer", referencedColumnName="user_id")
	private Lecturer lecturer;
	
	
	public EducomRole() {
		setRoleUUID(EducomGenerator.generateUuid().toString());
	}
	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleUUID
	 */
	public String getRoleUUID() {
		return roleUUID;
	}
	/**
	 * @param roleUUID the roleUUID to set
	 */
	public void setRoleUUID(String roleUUID) {
		this.roleUUID = roleUUID;
	}
	/**
	 * @return the lecturer
	 */
	public Lecturer getLecturer() {
		return lecturer;
	}
	/**
	 * @param lecturer the lecturer to set
	 */
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
}
