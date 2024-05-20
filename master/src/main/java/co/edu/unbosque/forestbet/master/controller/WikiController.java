package co.edu.unbosque.forestbet.master.controller;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.edu.unbosque.forestbet.master.model.Pilot;
import co.edu.unbosque.forestbet.master.model.Scuderia;
import co.edu.unbosque.forestbet.master.util.HttpConnectionsAndRequests;

@RestController
@RequestMapping
public class WikiController {
	
	@GetMapping("/showScuderias")
	public String showScuderias(Model model) {
		StringBuilder request = new StringBuilder("http://localhost:8082/scuderias/chargeScuderias");
		String method = "GET";
		
		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);
		
		if(response.equals("Cargadas exitosamente")) {
			StringBuilder requestPartTwo = new StringBuilder("http://localhost:8082/scuderias/showScuderias");
			
			String responsePartTwo = HttpConnectionsAndRequests.doARequest(requestPartTwo.toString(), method);
			
			Gson gson = new Gson();
			
			@SuppressWarnings("unchecked")
			ArrayList<Scuderia> scuderias = gson.fromJson(responsePartTwo, ArrayList.class);
			System.out.println(scuderias.toString());
			model.addAttribute("scuderias", scuderias);
			
			return "202";			
		}else {
			return "500";
		}
	}
	
	@GetMapping("/showPilots")
	public String showPilots(Model model) {
		showScuderias(model);
		
		StringBuilder request = new StringBuilder("http://localhost:8082/pilots/chargePilots");
		String method = "GET";
		
		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);
		
		if(response.equals("Cargados con exito")) {
			StringBuilder requestPartTwo = new StringBuilder("http://localhost:8082/pilots/showPilots");
			
			String responsePartTwo = HttpConnectionsAndRequests.doARequest(requestPartTwo.toString(), method);
			
			Gson gson = new Gson();
			
			@SuppressWarnings("unchecked")
			ArrayList<Pilot> pilots = gson.fromJson(responsePartTwo, ArrayList.class);
			
			System.out.println(pilots.toString());
			
			model.addAttribute("pilots", pilots);
			
			return "202";			
		}else {
			return "500";
		}
	}
	
	
//	public String showPilots() {
//		
//	}
	
}
