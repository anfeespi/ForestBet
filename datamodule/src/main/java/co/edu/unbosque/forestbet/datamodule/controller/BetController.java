package co.edu.unbosque.forestbet.datamodule.controller;

import java.util.List;

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
import co.edu.unbosque.forestbet.datamodule.service.BetService;
import co.edu.unbosque.forestbet.datamodule.service.ClientService;

@RestController
@RequestMapping("/bets")
@CrossOrigin(origins = "*")
@Transactional
public class BetController {
	@Autowired
	private BetService betService;
	@Autowired
	private ClientService clientService;

	public BetController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/bet")
	public ResponseEntity<String> createABet(@RequestParam String field, @RequestParam Double money,
			@RequestParam Double quote, @RequestParam Boolean statusWin, @RequestParam Long sport_id,
			@RequestParam String document) {
		Bet bet = new Bet(field, money, quote, statusWin, sport_id);
		Client client = clientService.searchByDocument(document);
		if (client == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Documento no encontrado");
		
		if (client.getMoney() < money)
			return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("No hay suficiente dinero");
		
		client.setMoney(client.getMoney() - money);
		bet.setClient(client);
		betService.doABet(bet);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Creado con éxito");
	}
	
	@GetMapping("/getAllBets")
	public ResponseEntity<List<Bet>> getBets(){
		return ResponseEntity.accepted().body(betService.showAll());
	}
}
