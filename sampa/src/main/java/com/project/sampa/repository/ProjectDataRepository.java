package com.project.sampa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sampa.model.Project;

@Repository
public interface ProjectDataRepository extends JpaRepository<Project, Long> {

	
}
