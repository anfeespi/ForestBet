package co.edu.unbosque.forestbet.master.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import co.edu.unbosque.forestbet.master.model.Circuit;
import co.edu.unbosque.forestbet.master.model.Pilot;
import co.edu.unbosque.forestbet.master.model.Race;
import co.edu.unbosque.forestbet.master.model.Scuderia;
import co.edu.unbosque.forestbet.master.util.HttpConnectionsAndRequests;

@Controller
@RequestMapping
public class WikiController {

	public Integer chargeScuderias(Model model) {
		StringBuilder request = new StringBuilder("http://localhost:8082/scuderias/chargeScuderias");
		String method = "GET";

		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);

		if (response.equals("Cargadas exitosamente")) {
			return 202;
		}

		return 500;
	}

	public Integer showScuderias(Model model) {
		String method = "GET";
		StringBuilder requestPartTwo = new StringBuilder("http://localhost:8082/scuderias/showScuderias");

		String responsePartTwo = HttpConnectionsAndRequests.doARequest(requestPartTwo.toString(), method);

		Gson gson = new Gson();

		@SuppressWarnings("unchecked")
		ArrayList<Scuderia> scuderias = gson.fromJson(responsePartTwo, ArrayList.class);
		model.addAttribute("scuderias", scuderias);

		return 202;
	}

	public Integer chargePilots(Model model) {
		StringBuilder request = new StringBuilder("http://localhost:8082/pilots/chargePilots");
		String method = "GET";

		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);

		if (response.equals("Cargados con exito")) {
			return 202;
		}

		return 500;
	}

	public Integer showPilots(Model model) {
		StringBuilder requestPartTwo = new StringBuilder("http://localhost:8082/pilots/showPilots");
		String method = "GET";
		
		String responsePartTwo = HttpConnectionsAndRequests.doARequest(requestPartTwo.toString(), method);

		Gson gson = new Gson();

		@SuppressWarnings("unchecked")
		ArrayList<Pilot> pilots = gson.fromJson(responsePartTwo, ArrayList.class);

		model.addAttribute("pilots", pilots);

		return 202;
	}

	public Integer chargeCircuits(Model model) {
		StringBuilder request = new StringBuilder("http://localhost:8082/circuits/chargeCircuits");
		String method = "GET";

		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);

		if (response.equals("Cargados exitosamente")) {
			return 202;
		}

		return 500;
	}
	
	public Integer showCircuits(Model model) {
		StringBuilder requestPartTwo = new StringBuilder("http://localhost:8082/circuits/showCircuits");
		String method = "GET";
		
		String responsePartTwo = HttpConnectionsAndRequests.doARequest(requestPartTwo.toString(), method);

		Gson gson = new Gson();

		@SuppressWarnings("unchecked")
		ArrayList<Circuit> circuits = gson.fromJson(responsePartTwo, ArrayList.class);

		model.addAttribute("circuits", circuits);

		return 202;
	}
	
	public Integer chargeRaces(Model model) {
		StringBuilder request = new StringBuilder("http://localhost:8082/races/chargeRaces");
		String method = "GET";

		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);

		if (response.equals("Cargados con exito")) {
			return 202;
		}

		return 500;
	}
	
	public Integer showRaces(Model model) {
		StringBuilder requestPartTwo = new StringBuilder("http://localhost:8082/races/showRaces");
		String method = "GET";
		
		String responsePartTwo = HttpConnectionsAndRequests.doARequest(requestPartTwo.toString(), method);

		Gson gson = new Gson();

		@SuppressWarnings("unchecked")
		ArrayList<Race> races = gson.fromJson(responsePartTwo, ArrayList.class);

		model.addAttribute("races", races);

		return 202;
	}
	
	@GetMapping("/chargeTheWiki")
	public String chargeWiki(Model model) {
		chargeScuderias(model);
		chargePilots(model);
		chargeCircuits(model);
		chargeRaces(model);
		
		showScuderias(model);
		showPilots(model);
		showCircuits(model);
		showRaces(model);
		
		return "wiki";
	}

}
