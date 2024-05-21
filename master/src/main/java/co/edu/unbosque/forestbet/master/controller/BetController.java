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
	public String doABet(@RequestParam(name = "money", required = true) String money, @RequestParam(name = "race_id", required = true) String race_id, @RequestParam(name = "pilot_id", required = true) String pilot_id, @RequestParam(name = "document", required = true)  String document, Model model) {
		StringBuilder request = new StringBuilder("http://localhost:8081/bets/bet?");
		
		String quote = "";
		
		int pid = Integer.parseInt(pilot_id) % 20;
		
		switch (pid) {
		case 1:
			quote = "151.0";
			break;
		case 2:
			quote = "21.0";
			break;
		case 3:
			quote = "21.0";
			break;
		case 4:
			quote = "81.0";
			break;
		case 5:
			quote = "26.0";
			break;
		case 6:
			quote = "151.0";
			break;
		case 7:
			quote = "4.5";
			break;
		case 8:
			quote = "151.0";
			break;
		case 9:
			quote = "6.0";
			break;
		case 10:
			quote = "81.0";
			break;
		case 11:
			quote = "11.0";
			break;
		case 12:
			quote = "8.0";
			break;
		case 13:
			quote = "81.0";
			break;
		case 14:
			quote = "21.0";
			break;
		case 15:
			quote = "10.0";
			break;
		case 16:
			quote = "251.0";
			break;
		case 17:
			quote = "51.0";
			break;
		case 18:
			quote = "67.0";
			break;
		case 19:
			quote = "2.75";
			break;
		case 20:
			quote = "201.0";
			break;
		default:
			quote = "1.0";
			break;
		}
		
		
		request.append("field="+pilot_id);		
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
