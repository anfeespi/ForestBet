package co.edu.unbosque.forestbet.datamodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.datamodule.model.Client;
import co.edu.unbosque.forestbet.datamodule.repository.ClientRepository;
import co.edu.unbosque.forestbet.datamodule.util.MailSender;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public ClientService() {
		// TODO Auto-generated constructor stub
	}

	public String registerUser(Client client) {
		if (!validateEmail(client.getEmail(), client.getName()))
			return "Couldn't validate email";
		clientRepository.save(client);
		long id = clientRepository.count();
		return "Registro exitoso -"+id;
	}

	public Client searchByDocument(String document) {
		return clientRepository.findByDocument(document).size()==0?null:clientRepository.findByDocument(document).get(0);
	}
	
	public Client searchById(Long id) {
		return clientRepository.findById(id).get();
	}

	public void deleteUser(Long id) {
		clientRepository.deleteById(id);
	}

	public boolean validateEmail(String email, String name) {
		return MailSender.sendEmail(email, name);
	}
}
