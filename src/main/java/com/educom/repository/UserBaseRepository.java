package com.educom.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.JpaRepository;
import com.educom.entity.User;


@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T, Long> {

}
