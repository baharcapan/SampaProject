package com.project.sampa.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ProjectUpdateDTO {

	long id;
	
	String projectName;
	
	long taskCount;
	
}
