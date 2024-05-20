package co.edu.unbosque.forestbet.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.unbosque.forestbet.master.util.HttpConnectionsAndRequests;

@Controller
@RequestMapping
public class BetController {
	
	@GetMapping("/preBet/{race_id}")
	public String preBet(@PathVariable String race_id, Model model) {
		Long race = Long.parseLong(race_id.substring(0, race_id.length()-2));
		model.addAttribute("race_id", race);
		return "apuesta";
	}
	
	@PostMapping("/bet")
	public String doABet(@RequestParam(name = "money", required = true) String money, @RequestParam(name = "quote", required = true) String quote, @RequestParam(name = "race_id", required = true) String race_id, @RequestParam(name = "document", required = true)  String document, Model model) {
		StringBuilder request = new StringBuilder("http://localhost:8081/bets/bet?");
		
		request.append("field=nvm");		
		request.append("&money="+money);
		request.append("&quote="+quote);
		request.append("&statusWin=false");
		request.append("&sport_id="+race_id);
		request.append("&document="+document);
		
		String method = "POST";
		
		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);
		System.out.println(response);
		
		return "mainpage";
	}
}
