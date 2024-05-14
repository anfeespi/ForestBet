package co.edu.unbosque.forestbet.datamodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.datamodule.model.Report;
import co.edu.unbosque.forestbet.datamodule.repository.ReportRepository;

@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepository;
	
	public ReportService() {
		// TODO Auto-generated constructor stub
	}
	
	public void doAReport(Report report) {
		reportRepository.save(report);
	}
}
