package co.edu.unbosque.forestbet.formulamodule.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pilots")
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pilot_id;
	private String driverId;
	private Long permanentNumber;
	private String code;
	private String url;
	private String name;
	private String lastname;
	private Date dateOfBirth;
	private String nationality;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scuderia_id", nullable = false, referencedColumnName = "scuderia_id")
	private Scuderia scuderia;
	
	public Pilot() {
		// TODO Auto-generated constructor stub
	}

	public Pilot(String driverId, Long permanentNumber, String code, String url, String name, String lastname,
			Date dateOfBirth, String nationality) {
		super();
		this.driverId = driverId;
		this.permanentNumber = permanentNumber;
		this.code = code;
		this.url = url;
		this.name = name;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}



	public Long getPilot_id() {
		return pilot_id;
	}

	public void setPilot_id(Long pilot_id) {
		this.pilot_id = pilot_id;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public Long getPermanentNumber() {
		return permanentNumber;
	}

	public void setPermanentNumber(Long permanentNumber) {
		this.permanentNumber = permanentNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Scuderia getScuderia() {
		return scuderia;
	}

	public void setScuderia(Scuderia scuderia) {
		this.scuderia = scuderia;
	}
	
}
