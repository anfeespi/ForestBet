package co.edu.unbosque.forestbet.datamodule.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forestbet.datamodule.model.Bet;
import co.edu.unbosque.forestbet.datamodule.model.Client;
import co.edu.unbosque.forestbet.datamodule.service.ClientService;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
@Transactional
public class ClientController {
	@Autowired
	private ClientService clientService;

	public ClientController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/register")
	public ResponseEntity<String> createClient(@RequestParam String email, @RequestParam String name,
			@RequestParam String lastname,@RequestParam String document,@RequestParam Double money) {
		Client client = new Client(email, name, lastname, document, money);
		String response = clientService.registerUser(client);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
	
	@GetMapping("/getClient")
	public ResponseEntity<Client> getClient(@RequestParam Long id){
		Client client = clientService.searchById(id);
		return ResponseEntity.accepted().body(client);
	}
	
	@GetMapping("/getBetsByClient")
	public ResponseEntity<List<Bet>> getBetsByClient(@RequestParam Long id){
		Client client = clientService.searchById(id);
		
		Set<Bet> bets = client.getBets();
		
		List<Bet> betsToReturn = new ArrayList<Bet>();
		
		for (Bet bet : bets) {
			betsToReturn.add(bet);
		}
		
		return ResponseEntity.accepted().body(betsToReturn);
	}
}
