package co.edu.unbosque.forestbet.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.login.model.Account;
import co.edu.unbosque.forestbet.login.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	public AccountRepository accountRepository;
	
	public boolean createAccount(Account account) {
		if(accountRepository.existsByUsername(account.getUsername())) {
			return false;
		}
		
		accountRepository.save(account);
		
		return true;
	}
	
	public void deleteAccount(String username) {
		accountRepository.deleteByUsername(username);
	}
	
	public Long login(String username, String password) {
		if(accountRepository.existsByUsername(username)) {
			Account acc = accountRepository.findByUsernameAndEncryptedPassword(username, password);
			return acc==null?-1:acc.getIdUser();
		}
		
		return (long) -1;
	}
}
