package com.project.sampa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sampa.model.User;


@Repository
public interface UserDataRepository extends JpaRepository<User, Long> {

	
}
