package co.edu.unbosque.forestbet.master.model;

import java.util.Set;

public class Client {
	private Long client_id;
	private String email;
	private String name;
	private String lastname;
	private String document;
	private Double money;
	
	private Set<Bet> bets;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String email, String name, String lastname, String document, Double money) {
		super();
		this.email = email;
		this.name = name;
		this.lastname = lastname;
		this.document = document;
		this.money = money;
	}

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Set<Bet> getBets() {
		return bets;
	}

	public void setBets(Set<Bet> bets) {
		this.bets = bets;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", email=" + email + ", name=" + name + ", lastname=" + lastname
				+ ", money=" + money + "]";
	}
}
