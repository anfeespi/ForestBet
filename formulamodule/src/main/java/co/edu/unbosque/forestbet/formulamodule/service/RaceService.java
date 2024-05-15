package co.edu.unbosque.forestbet.formulamodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.formulamodule.model.Race;
import co.edu.unbosque.forestbet.formulamodule.repository.RaceRepository;

@Service
public class RaceService {
	@Autowired
	private RaceRepository raceRepository;
	
	public RaceService() {
		// TODO Auto-generated constructor stub
	}
	
	public void createRace(Race race) {
		raceRepository.save(race);
	}
	
	public List<Race> showAllRaces(){
		return (List<Race>) raceRepository.findAll();
	}
}
