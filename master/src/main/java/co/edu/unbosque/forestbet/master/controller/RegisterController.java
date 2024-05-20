package co.edu.unbosque.forestbet.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.unbosque.forestbet.master.util.HttpConnectionsAndRequests;

@Controller
@RequestMapping
public class RegisterController {
	
	@PostMapping("/registerUser")
	public String register(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "lastname", required = true) String lastname, @RequestParam(name = "email", required = true) String email, @RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password, @RequestParam(name = "document", required = true) String document, @RequestParam(name = "money", required = true) String money, Model model) {
		StringBuilder requestData = new StringBuilder("http://localhost:8081/clients/register?");
		requestData.append("email="+email.replace("@", "%40"));
		requestData.append("&name="+name);
		requestData.append("&lastname="+lastname);
		requestData.append("&document="+document);
		requestData.append("&money="+money);
		String method = "POST";
		
		String responseData = HttpConnectionsAndRequests.doARequest(requestData.toString(), method);
		
		String id = responseData.split("-")[1];
		
		StringBuilder requestLogin = new StringBuilder("http://localhost:8080/signup?");
		requestLogin.append("username="+username);
		requestLogin.append("&encryptedPassword="+password);
		requestLogin.append("&idUser="+id);
		String responseLogin = HttpConnectionsAndRequests.doARequest(requestLogin.toString(), method);
		System.out.println(responseLogin);
		return "mainpage";
	}
}
