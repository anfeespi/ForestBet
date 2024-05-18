package co.edu.unbosque.forestbet.formulamodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forestbet.formulamodule.model.Circuit;
import co.edu.unbosque.forestbet.formulamodule.service.CircuitService;
import co.edu.unbosque.forestbet.formulamodule.util.HttpConnectionsAndRequests;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/circuits")
@CrossOrigin(origins = "*")
@Transactional
public class CircuitController {
	@Autowired
	private CircuitService circuitService;

	public CircuitController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/chargeCircuits")
	public ResponseEntity<String> chargeCircuits() {
		String request = "http://ergast.com/api/f1/current/circuits.json";
		String method = "GET";

		String response = HttpConnectionsAndRequests.doARequest(request, method);

		if (response.isBlank())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problema al cargar los datos");

		circuitService.chargeAllCircuits(response);

		return ResponseEntity.accepted().body("Cargados exitosamente");
	}

	@GetMapping("/showCircuits")
	public ResponseEntity<List<Circuit>> showCircuits() {
		return ResponseEntity.accepted().body(circuitService.showAllCircuits());
	}

}
