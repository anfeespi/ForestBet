package co.edu.unbosque.forestbet.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forestbet.login.model.Account;
import co.edu.unbosque.forestbet.login.service.AccountService;

@RestController
@RequestMapping(name = "/account")
@Transactional
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	public AccountService accountService;

	@GetMapping("/login")
	public ResponseEntity<Long> doLogin(@RequestParam String username, @RequestParam String password) {
		if (accountService.login(username, password) != -1)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.login(username, password));
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body((long) -1);
	}

	@PostMapping("/delete")
	public ResponseEntity<String> deleteAccount(@RequestParam String username) {
		try {
			accountService.deleteAccount(username);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Eliminado exitosamente!");
	}

	@PostMapping("/signup")
	public ResponseEntity<String> createAccount(@RequestParam String username, @RequestParam String encryptedPassword,
			@RequestParam Long idUser) {
		Account acc = new Account(username, encryptedPassword, idUser);

		if (accountService.createAccount(acc)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Registrado con éxito!");
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo completar el registro");
	}
}
