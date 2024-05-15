package co.edu.unbosque.forestbet.formulamodule.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "scuderias")
public class Scuderia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scuderia_id;
	private String constructorId;
	private String url;
	private String name;
	private String nationality;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "scuderia", cascade = CascadeType.ALL)
	private Set<Pilot> pilots;
	
	public Scuderia() {
		// TODO Auto-generated constructor stub
	}

	public Scuderia(String constructorId, String url, String name, String nationality) {
		super();
		this.constructorId = constructorId;
		this.url = url;
		this.name = name;
		this.nationality = nationality;
	}

	public Long getScuderia_id() {
		return scuderia_id;
	}

	public void setScuderia_id(Long scuderia_id) {
		this.scuderia_id = scuderia_id;
	}

	public String getConstructorId() {
		return constructorId;
	}

	public void setConstructorId(String constructorId) {
		this.constructorId = constructorId;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Set<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(Set<Pilot> pilots) {
		this.pilots = pilots;
	}

	@Override
	public String toString() {
		return "Scuderia [scuderia_id=" + scuderia_id + ", constructorId=" + constructorId + ", url=" + url + ", name="
				+ name + ", nationality=" + nationality + ", pilots=" + pilots + "]";
	}
	
}
