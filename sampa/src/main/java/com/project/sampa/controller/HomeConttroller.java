package com.project.sampa.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.sampa.model.Client;
import com.project.sampa.model.Credential;
import com.project.sampa.model.Project;
import com.project.sampa.model.SiteMap;
import com.project.sampa.model.User;
import com.project.sampa.service.ICredentialService;
import com.project.sampa.service.IUserService;
import com.project.sampa.service.UserServiceImpl;

@Controller
public class HomeConttroller {


	@Autowired
	IUserService userService;
	
	@Autowired
	ICredentialService credentialService;
	
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login.html";
    }
	
	
	@GetMapping({"/", "/dashboard","","welcome"})
    public ModelAndView welcome(Model model,Authentication authentication) throws Exception {
		String username=authentication.getName();
		ModelAndView mav = new ModelAndView();
		Date date = new Date();
		Credential credential=credentialService.findByUsername(username);
		User user=credential.getUser();
		user.setLastLogin(date);
		credential.setUser(user);
		credentialService.updateCredential(credential);
		userService.updateUser(user);
		
		long projectCount=0;
		for (Client client : credentialService.findByUsername(username).getUser().getClients()) {
			for (SiteMap siteMap : client.getSitemaps()) {
				projectCount+=siteMap.getProjects().size();
				
			}
			
		}
		long taskCount=0;
		
		for (Client client : credentialService.findByUsername(username).getUser().getClients()) {
			for (SiteMap siteMap : client.getSitemaps()) {
				for (Project project : siteMap.getProjects()) {
					taskCount+=project.taskCount;
					
				}
				
			}
			
		}
		
		
		mav.addObject("currentUser",credentialService.findByUsername(username).getUser());
		mav.addObject("clients",credentialService.findByUsername(username).getUser().getClients());
		mav.addObject("projectCount",projectCount);
		mav.addObject("clientCount",credentialService.findByUsername(username).getUser().getClients().size());
		mav.addObject("totalTasks",taskCount);
		mav.setViewName("index.html");
		return mav;
		
    }
	
	
	
	
	
	
	
	
}
