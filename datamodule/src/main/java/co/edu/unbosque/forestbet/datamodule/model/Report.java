package co.edu.unbosque.forestbet.datamodule.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reports")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long report_id;
	private Date init_date;
	private Date end_date;
	private Integer sport_id;
	private Double income;
	private Double expenses;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(Date init_date, Date end_date, Integer sport_id, Double income, Double expenses) {
		super();
		this.init_date = init_date;
		this.end_date = end_date;
		this.sport_id = sport_id;
		this.income = income;
		this.expenses = expenses;
	}

	public Long getReport_id() {
		return report_id;
	}

	public void setReport_id(Long report_id) {
		this.report_id = report_id;
	}

	public Date getInit_date() {
		return init_date;
	}

	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Integer getSport_id() {
		return sport_id;
	}

	public void setSport_id(Integer sport_id) {
		this.sport_id = sport_id;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}
	
}
