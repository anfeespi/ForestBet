package co.edu.unbosque.forestbet.master.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forestbet.master.util.HttpConnectionsAndRequests;

@RestController
@RequestMapping
public class BetController {
	
	@PostMapping("/bet/{documento}")
	public String doABet(@RequestParam(name = "money", required = true) String money, @RequestParam(name = "quote", required = true) String quote,@RequestParam(name = "document", required = true)  String document) {
		StringBuilder request = new StringBuilder("http://localhost:8081/bets/bet?");
		
		request.append("field=nvm");		
		request.append("&money="+money);
		request.append("&quote="+quote);
		request.append("&statusWin=false");
		request.append("&sport_id=1");
		request.append("&document="+document);
		
		String method = "POST";
		
		String response = HttpConnectionsAndRequests.doARequest(request.toString(), method);
		
		
		return response;
	}
}
