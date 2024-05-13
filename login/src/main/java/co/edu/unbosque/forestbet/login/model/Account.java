package co.edu.unbosque.forestbet.login.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String username;
	
	@Indexed
	private String encryptedPassword;
	
	@Indexed(unique = true)
	private Long idUser;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String username, String encryptedPassword, Long idUser) {
		super();
		this.username = username;
		this.encryptedPassword = encryptedPassword;
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", encryptedPassword=" + encryptedPassword + ", idUser="
				+ idUser + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
