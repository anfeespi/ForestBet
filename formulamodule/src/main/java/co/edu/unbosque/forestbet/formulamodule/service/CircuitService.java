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
	
	public void createCircuit(Circuit circuit) {
		circuitRepository.save(circuit);
	}
	
	public List<Circuit> showAllCircuits(){
		return (List<Circuit>) circuitRepository.findAll();
	}
}
