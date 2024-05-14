package co.edu.unbosque.forestbet.datamodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.datamodule.model.Client;
import co.edu.unbosque.forestbet.datamodule.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public ClientService() {
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser(Client client) {
		clientRepository.save(client);
	}
	
	public Client searchByDocument(String document) {
		return clientRepository.findByDocument(document).get(0);
	}
	
	public void deleteUser(Long id) {
		clientRepository.deleteById(id);
	}
}
