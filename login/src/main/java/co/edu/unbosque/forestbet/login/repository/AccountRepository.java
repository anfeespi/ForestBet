package co.edu.unbosque.forestbet.login.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.unbosque.forestbet.login.model.Account;

public interface AccountRepository extends MongoRepository<Account, String>{
	List<Account> findByUsername(String username);
	boolean existsByUsername(String username);
	Account findByUsernameAndEncryptedPassword(String username, String encryptedPassword);
	void deleteByUsername(String username);
}
