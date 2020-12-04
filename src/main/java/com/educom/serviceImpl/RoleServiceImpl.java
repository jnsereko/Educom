package com.educom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educom.entity.EducomRole;
import com.educom.exception.ResourceNotFoundException;
import com.educom.repository.RoleRepository;
import com.educom.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public void saveEducomRole(EducomRole educomRole) {
		roleRepository.save(educomRole);
	}

	@Override
	@Transactional
	public EducomRole getEducomRole(Long EducomRoleId) throws ResourceNotFoundException {
		return roleRepository.findById(EducomRoleId).get();
	}

	@Override
	@Transactional
	public void deleteEducomRoleByRoleId(Long EducomRoleId) throws ResourceNotFoundException {
		roleRepository.deleteById(EducomRoleId);
	}

	@Override
	@Transactional
	public void deleteEducomRole(EducomRole educomRole) throws ResourceNotFoundException {
		roleRepository.delete(educomRole);
	}

	@Override
	@Transactional
	public List<EducomRole> getEducomRoles() {
		return 	roleRepository.findAll();
	}
	@Override
	@Transactional
	public EducomRole findEducomRoleByUUID(String roleUUID) {
		return roleRepository.findEducomRoleByUUID(roleUUID);
	}
	
	@Override
	@Transactional
	public List<EducomRole> findEducomRoleByIdCodeAndName(String keyword){
		return roleRepository.findEducomRoleByIdCodeAndName(keyword);
	}
}
