package com.project.sampa.dto.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.sampa.dto.TemplateDTO;
import com.project.sampa.dto.UserCreateDTO;
import com.project.sampa.model.Authority;
import com.project.sampa.model.Credential;
import com.project.sampa.model.Template;
import com.project.sampa.model.User;

public class TemplateCreateMapper {
	 
	 
    public Template toEntity(TemplateDTO dto,long creator) {
    	Date date=new Date();
        Template template = new Template(dto.getName(),dto.state,date,creator);
        for (Authority auth : dto.getAuthority()) {
        	template.getAuths().add(auth);
			
		}
        
        return template;
    }
}
