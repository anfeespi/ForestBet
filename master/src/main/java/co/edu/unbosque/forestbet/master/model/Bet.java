package co.edu.unbosque.forestbet.master.model;

public class Bet {
	private Long bet_id;
	private String field;
	private Double money;
	private Double quote;
	private Long sport_id;
	private Boolean statusWin;
	
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
