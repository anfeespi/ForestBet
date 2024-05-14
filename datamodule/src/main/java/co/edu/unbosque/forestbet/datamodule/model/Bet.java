package co.edu.unbosque.forestbet.datamodule.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bets")
public class Bet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bet_id;
	private String field;
	private Double money;
	private Double quote;
	private Long sport_id;
	private Boolean statusWin;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false, referencedColumnName = "client_id")
	private Client client;
	
	public Bet() {
		// TODO Auto-generated constructor stub
	}

	public Bet(String field, Double money, Double quote, Boolean statusWin, Long sport_id) {
		super();
		this.field = field;
		this.money = money;
		this.quote = quote;
		this.statusWin = statusWin;
		this.sport_id = sport_id;
	}

	public Long getBet_id() {
		return bet_id;
	}

	public void setBet_id(Long bet_id) {
		this.bet_id = bet_id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getQuote() {
		return quote;
	}

	public void setQuote(Double quote) {
		this.quote = quote;
	}

	public Long getSport_id() {
		return sport_id;
	}

	public void setSport_id(Long sport_id) {
		this.sport_id = sport_id;
	}

	public Boolean getStatusWin() {
		return statusWin;
	}

	public void setStatusWin(Boolean statusWin) {
		this.statusWin = statusWin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
