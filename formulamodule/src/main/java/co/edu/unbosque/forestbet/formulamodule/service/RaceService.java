package co.edu.unbosque.forestbet.formulamodule.service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.formulamodule.model.Circuit;
import co.edu.unbosque.forestbet.formulamodule.model.Race;
import co.edu.unbosque.forestbet.formulamodule.repository.CircuitRepository;
import co.edu.unbosque.forestbet.formulamodule.repository.RaceRepository;

@Service
public class RaceService {
	@Autowired
	private RaceRepository raceRepository;
	@Autowired
	private CircuitRepository circuitRepository;
	
	public RaceService() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings({ "deprecation" })
	public void chargeAllRaces(String json) {
		deleteRaces();
		json = json.substring(json.indexOf("\"Races\":"), json.indexOf("]"));
		json = json.replace("\"Races\":", "").replace("[", "").replace("},{", "___");
		String races[] = json.replace("{", "").split("___");
		
		for (String string : races) {
			Race aux = new Race();
			String attributes[] = string.split(",");
			aux.setSeason(Integer.parseInt(attributes[0].replace("\"", "").replace("season:", "")));
			aux.setRound(Integer.parseInt(attributes[1].replace("\"", "").replace("round:", "")));
			aux.setName(attributes[3].replace("\"", "").replace("raceName:", ""));
			
			String circuitid = attributes[4].replace("\"", "").replace("Circuit:circuitId:", "");
			
			Circuit circuit = circuitRepository.findByCircuitIdName(circuitid).get(0);
			
			aux.setCircuit(circuit);
			
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			try {
				String[] dt = attributes[11].replace("\"", "").replace("date:", "").split("-");
				aux.setRace_date(format.parse(dt[2] + "/" + dt[1] + "/" + dt[0]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String[] t = attributes[12].replace("\"", "").replace("time:", "").split(":");
			aux.setRace_time(new Time(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2].substring(0, 2))));
			
			createRace(aux);
		}
	}
	
	public void createRace(Race race) {
		raceRepository.save(race);
	}
	
	public List<Race> showAllRaces(){
		return (List<Race>) raceRepository.findAll();
	}
	
	public void deleteRaces() {
		raceRepository.deleteAll();
	}
}
