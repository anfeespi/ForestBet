package co.edu.unbosque.forestbet.formulamodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.formulamodule.model.Circuit;
import co.edu.unbosque.forestbet.formulamodule.repository.CircuitRepository;

@Service
public class CircuitService {
	@Autowired
	private CircuitRepository circuitRepository;
	
	public CircuitService() {
		// TODO Auto-generated constructor stub
	}
	
	public void chargeAllCircuits(String json) {
		deleteCircuits();
		json = json.substring(json.indexOf("\"Circuits\":"), json.indexOf("]"));
		json = json.replace("\"Circuits\":", "").replace("[", "");
		String circuits[] = json.replace("{", "").split("},");
		
		for (String string : circuits) {
			Circuit aux = new Circuit();
			String attributes[] = string.split(",");
			aux.setCircuitIdName(attributes[0].replace("\"", "").replace("circuitId:", ""));
			aux.setUrl(attributes[1].replace("\"", "").replace("url:", "").replace("\\/", "/"));
			aux.setCircuitName(attributes[2].replace("\"", "").replace("circuitName:", ""));
			aux.setCity((attributes[5].replace("\"", "").replace("locality:", "").replace("}", "")));
			aux.setCountry(attributes[6].replace("\"", "").replace("country:", "").replace("}", ""));
			createCircuit(aux);
		}
	}
	
	public void createCircuit(Circuit circuit) {
		circuitRepository.save(circuit);
	}
	
	public List<Circuit> showAllCircuits(){
		return (List<Circuit>) circuitRepository.findAll();
	}
	
	public void deleteCircuits() {
		circuitRepository.deleteAll();
	}
}
