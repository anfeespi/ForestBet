package co.edu.unbosque.forestbet.master.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import co.edu.unbosque.forestbet.master.model.Bet;
import co.edu.unbosque.forestbet.master.model.Client;
import co.edu.unbosque.forestbet.master.util.HttpConnectionsAndRequests;

@Controller
@RequestMapping
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(name = "username", required = true) String username,@RequestParam(name = "password", required = true) String password, Model model) {
		StringBuilder request = new StringBuilder("http://localhost:8080/login");
		request.append("?username=" + username);
		request.append("&password=" + password);
		String method = "GET";

		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);
		
		try {
			Long id = Long.parseLong(response);
			model.addAttribute("client_id", id);
			return "mainpage";
		}catch (Exception e) {
			model.addAttribute("client_id", -1);
			return "redirect:/register.html";
		}
	}
	
	@GetMapping("/profile/{client_id}")
	public String chargeProfile(@PathVariable long client_id, Model model) {
		if(client_id != -1) {
			StringBuilder request = new StringBuilder("http://localhost:8081/clients/getClient?");
			request.append("id="+client_id);
			
			String method = "GET";
			
			String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);

			Gson gson = new Gson();
			
			Client client = gson.fromJson(response, Client.class);
			
			model.addAttribute("cliente", client);
			
			Set<Bet> bets = client.getBets();
			
			List<Bet> betsToReturn = new ArrayList<Bet>();
			
			for (Bet bet : bets) {
				betsToReturn.add(bet);
			}
			
			model.addAttribute("bets", betsToReturn);
			
			return "perfil";
		}else {
			return "login";
		}
	}
	
}
