package com.educom.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educom.entity.EducomRole;

@Repository("roleRepository")
@Transactional
public interface RoleRepository extends JpaRepository<EducomRole, Long> {


	@Query("select u from EducomRole u where u.roleUUID = :roleUUID")
	 public EducomRole findEducomRoleByUUID(@Param("roleUUID") String roleUUID);
	
	@Query("select u from EducomRole u where concat(u.roleId, ' ', u.roleName) like %?1%")
	public List<EducomRole> findEducomRoleByIdCodeAndName(String keyword);
}
