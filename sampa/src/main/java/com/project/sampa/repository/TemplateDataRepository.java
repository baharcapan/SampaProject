package com.project.sampa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sampa.model.Template;

@Repository
public interface TemplateDataRepository extends JpaRepository<Template, Long> {
	Template findByName(String name);
	
}
