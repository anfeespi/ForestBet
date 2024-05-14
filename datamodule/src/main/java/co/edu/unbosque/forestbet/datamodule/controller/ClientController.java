package co.edu.unbosque.forestbet.datamodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forestbet.datamodule.model.Client;
import co.edu.unbosque.forestbet.datamodule.service.ClientService;

@RestController
@RequestMapping("/bets")
@CrossOrigin(origins = "*")
@Transactional
public class ClientController {
	@Autowired
	private ClientService clientService;

	public ClientController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * CAMBIARLO PARA VALIDAR EXISTENCIA DE DOCUMENTO Y VALIDACION DEL EMAIL, Y NO SE PUEDE APOSTAR SIN DINERO
	 *
	 */
	@PostMapping("/register")
	public ResponseEntity<String> createClient(@RequestParam String email, @RequestParam String name,
			@RequestParam String lastname,@RequestParam String document,@RequestParam Double money) {
		Client client = new Client(email, name, lastname, document, money);
		clientService.registerUser(client);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Creado con exito");
	}
}
