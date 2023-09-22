package com.project.sampa.dto.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.sampa.dto.UserUpdateDTO;
import com.project.sampa.model.Client;
import com.project.sampa.model.Credential;
import com.project.sampa.model.Template;
import com.project.sampa.model.User;

import lombok.Data;



@Data
public class UserUpdateMapper {

	
	 
    public List<Object> toEntity(UserUpdateDTO dto,User user,Credential cre,long updater) {
    	Date date=new Date();
    	List <Template> templateList =new  ArrayList<Template>();
    	for (Template temp : dto.getTemplates()) {
				templateList.add(temp);
		
		}
    	
    	
    	List <Client> clientList =new  ArrayList<Client>();
    	for (Client client : dto.getClients()) {
				clientList.add(client);
		
		}
    	
    
    	
    	User newUser=new User(user.getId(),dto.getEmail(),dto.getFirstName(),dto.getLastName(),
    			dto.isState(),user.getLastLogin(),
    			user.getCreated(),date,user.getCreator(),
    			updater,user.getClients());
    	newUser.setTemplates(templateList);
    	newUser.setClients(clientList);
       Credential credential= new Credential(cre.getId(),dto.getUsername(),cre.getPassword(),cre.getUserId(),newUser);
        cre.setUsername(dto.getUsername());
    	
        for (Template temp : newUser.getTemplates()) {
			System.out.println(temp.name);
			
	}
       
        List <Object> list=new ArrayList<Object>();
        
        list.add(newUser);
        list.add(credential);
        return list;
    }
}
