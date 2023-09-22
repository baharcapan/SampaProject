package com.project.sampa.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ProjectCreateDTO {
	
	
	String projectName;
	
	long taskCount;
	
	long siteMapId;
	
	

}
