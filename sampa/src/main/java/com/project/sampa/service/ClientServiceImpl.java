package com.project.sampa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sampa.model.Client;
import com.project.sampa.repository.ClientDataRepository;

@Service
public class ClientServiceImpl implements IClientService{

	@Autowired
	ClientDataRepository clientDataRepository;
	
	
	@Override
	public List<Client> findAll() {
		return clientDataRepository.findAll();
	}

	

	@Override
	public Client findByCode(String code) {
		
		return clientDataRepository.findByCode(code);
	}



	@Override
	public void createClient(Client client) throws Exception  {
		
		if(this.findByCode(client.getCode())==null) {
			clientDataRepository.save(client);
		}
		else {
			throw new Exception("already_exists");
		}
		
	}



	@Override
	public Optional<Client> findById(long id) {
		
		return clientDataRepository.findById(id);
	}



	@Override
	public void deleteClient(Client client) {
		clientDataRepository.delete(client);
	}



	@Override
	public void updateClient(Client client) {
		clientDataRepository.save(client);
	}

	
	
	
	
	
	
}
