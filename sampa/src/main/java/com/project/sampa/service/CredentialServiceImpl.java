package com.project.sampa.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sampa.model.Credential;
import com.project.sampa.model.User;
import com.project.sampa.repository.CredentialDataRepository;
import com.project.sampa.repository.UserDataRepository;


@Service
public class CredentialServiceImpl implements ICredentialService{

	@Autowired
	CredentialDataRepository credentialDataRepository;
	
	@Autowired
	UserDataRepository userDataRepository;
	
	@Override
	public List<Credential> findAll() {
		List<Credential> credentials=credentialDataRepository.findAll();		
		return credentials;
	}

	

	@Override
	public Credential findByUsername(String username)  {
		
		Credential cre =credentialDataRepository.findByUsername(username);
		
		return cre;
	}



	@Override
	public Credential createCredential(Credential cre) throws Exception {
		
		Credential credential =credentialDataRepository.findByUsername(cre.getUsername());

		if(credential==null) {
			User user= userDataRepository.save(cre.getUser());
			cre.setUserId(user.getId());
			System.out.println(user.getId());
			credential=credentialDataRepository.save(cre);
			return credential;
		}		
		else
			throw new Exception("credential_already_exists");
		
	}



	@Override
	public void deleteCredential(String username) throws Exception {
		Credential credential =credentialDataRepository.findByUsername(username);

		if(credential==null) {
			throw new Exception("credential_not_found");
		}		
		else {
			//User user=UserDataRepository.getById(credential.getUserId());
			//user.getTemplates().clear();
			
			
			credentialDataRepository.delete(credential);
			//UserDataRepository.delete(user);

		}
	}

	



	@Override
	public void updateCredential(Credential cre) throws Exception {
		Credential credential =credentialDataRepository.findByUsername(cre.getUsername());

		if(credential==null) {
			throw new Exception("credential not found");
		}		
		else {
			credentialDataRepository.save(cre);
			userDataRepository.save(cre.getUser())	;
			}
		
		
	}





	@Override
	public long CredentialCount() {
			return credentialDataRepository.count(); 
	}



	@Override
	public Credential findByUserId(long id) {
		
		return credentialDataRepository.findByUserId(id);
	}
	
	
	
	
	
	
}
