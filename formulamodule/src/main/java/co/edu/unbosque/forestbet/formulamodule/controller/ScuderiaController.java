package co.edu.unbosque.forestbet.formulamodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forestbet.formulamodule.model.Scuderia;
import co.edu.unbosque.forestbet.formulamodule.service.ScuderiaService;
import co.edu.unbosque.forestbet.formulamodule.util.HttpConnectionsAndRequests;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/scuderias")
@CrossOrigin(origins = "*")
@Transactional
public class ScuderiaController {
	@Autowired
	private ScuderiaService scuderiaService;

	public ScuderiaController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/chargeScuderias")
	public ResponseEntity<String> chargeScuderias() {
		String request = "http://ergast.com/api/f1/current/constructors.json";
		String method = "GET";

		String response = HttpConnectionsAndRequests.doARequest(request, method);

		if (response.isBlank())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problema al hacer el request");

		scuderiaService.chargeAllScuderias(response);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cargadas exitosamente");
	}

	@GetMapping("/showScuderias")
	public ResponseEntity<List<Scuderia>> showScuderias() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(scuderiaService.showAllScuderias());
	}
}
