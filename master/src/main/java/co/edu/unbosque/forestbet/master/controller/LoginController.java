package co.edu.unbosque.forestbet.master.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forestbet.master.util.HttpConnectionsAndRequests;

@RestController
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
			return "index.html";
		}catch (Exception e) {
			model.addAttribute("client_id", -1);
			return "redirect:/register.html";
		}
	}
}
