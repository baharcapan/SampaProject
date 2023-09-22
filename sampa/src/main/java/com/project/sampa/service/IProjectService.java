package com.project.sampa.service;

import java.util.List;
import java.util.Optional;

import com.project.sampa.model.Client;
import com.project.sampa.model.Project;
import com.project.sampa.model.SiteMap;

public interface IProjectService {

	void createProject(Project project);
	List<Project> findAll();
	Optional<Project> findById(long id);
	void updateProject(Project project);
	void deleteProject(Project project);
	
	
}
