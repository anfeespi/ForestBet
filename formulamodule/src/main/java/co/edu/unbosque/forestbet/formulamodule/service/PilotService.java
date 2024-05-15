package co.edu.unbosque.forestbet.formulamodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.formulamodule.model.Pilot;
import co.edu.unbosque.forestbet.formulamodule.repository.PilotRepository;

@Service
public class PilotService {
	@Autowired
	private PilotRepository pilotRepository;
	
	public PilotService() {
		// TODO Auto-generated constructor stub
	}
	
	public void createPilot(Pilot pilot) {
		pilotRepository.save(pilot);
	}
	
	public List<Pilot> showAllPilots(){
		return (List<Pilot>) pilotRepository.findAll();
	}
}
