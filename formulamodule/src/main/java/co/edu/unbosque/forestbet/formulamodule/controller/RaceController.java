package co.edu.unbosque.forestbet.formulamodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forestbet.formulamodule.model.Race;
import co.edu.unbosque.forestbet.formulamodule.service.RaceService;
import co.edu.unbosque.forestbet.formulamodule.util.HttpConnectionsAndRequests;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/races")
@CrossOrigin(origins = "*")
@Transactional
public class RaceController {
	@Autowired
	private RaceService raceService;
	
	public RaceController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/chargeRaces")
	public ResponseEntity<String> chargeAllTheRaces(){
		String request = "http://ergast.com/api/f1/current/races.json";
		String method = "GET";
		
		String response = HttpConnectionsAndRequests.doARequest(request, method);
		
		if(response.isBlank()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problema al hacer el request");
		
		raceService.chargeAllRaces(response);
		return ResponseEntity.accepted().body("Cargados con exito");
	}
	
	@GetMapping("/showRaces")
	public ResponseEntity<List<Race>> showRaces(){
		return ResponseEntity.accepted().body(raceService.showAllRaces());
	}
}
