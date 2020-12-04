package com.educom.service;

import java.util.List;

import com.educom.entity.EducomRole;
import com.educom.exception.ResourceNotFoundException;

public interface RoleService {

	public void saveEducomRole(EducomRole educomRole);

    public EducomRole getEducomRole(Long roleId) throws ResourceNotFoundException;

    public void deleteEducomRoleByRoleId(Long educomRoleId) throws ResourceNotFoundException;

    public void deleteEducomRole(EducomRole educomRole) throws ResourceNotFoundException;

	public List<EducomRole> getEducomRoles();

	EducomRole findEducomRoleByUUID(String roleUUID);

	List<EducomRole> findEducomRoleByIdCodeAndName(String keyword);
}
