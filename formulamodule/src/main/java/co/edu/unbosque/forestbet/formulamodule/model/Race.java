package co.edu.unbosque.forestbet.formulamodule.model;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "races")
public class Race {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long race_id;
	private Integer season;
	private Integer round;
	private String name;
	private Date race_date;
	private Time race_time;
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "circuit_id", referencedColumnName = "circuit_id")
	private Circuit circuit;
	
	public Race() {
		// TODO Auto-generated constructor stub
	}

	public Race(Integer season, Integer round, String name, Date race_date, Time race_time, Circuit circuit) {
		super();
		this.season = season;
		this.round = round;
		this.name = name;
		this.race_date = race_date;
		this.race_time = race_time;
		this.circuit = circuit;
	}

	public Long getRace_id() {
		return race_id;
	}

	public void setRace_id(Long race_id) {
		this.race_id = race_id;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRace_date() {
		return race_date;
	}

	public void setRace_date(Date race_date) {
		this.race_date = race_date;
	}

	public Time getRace_time() {
		return race_time;
	}

	public void setRace_time(Time race_time) {
		this.race_time = race_time;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}
	
}
