package co.edu.unbosque.forestbet.formulamodule.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "circuits")
public class Circuit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long circuit_id;
	private String circuitIdName;
	private String url;
	private String circuitName;
	private String city;
	private String country;
	@JsonBackReference
	@OneToOne(mappedBy = "circuit")
	private Race race;
	
	public Circuit() {
		// TODO Auto-generated constructor stub
	}

	public Circuit(String circuitId, String url, String circuitName, String city, String country) {
		super();
		this.circuitIdName = circuitId;
		this.url = url;
		this.circuitName = circuitName;
		this.city = city;
		this.country = country;
	}

	public Long getCircuit_id() {
		return circuit_id;
	}

	public void setCircuit_id(Long circuit_id) {
		this.circuit_id = circuit_id;
	}

	public String getCircuitIdName() {
		return circuitIdName;
	}

	public void setCircuitIdName(String circuitId) {
		this.circuitIdName = circuitId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCircuitName() {
		return circuitName;
	}

	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
}
