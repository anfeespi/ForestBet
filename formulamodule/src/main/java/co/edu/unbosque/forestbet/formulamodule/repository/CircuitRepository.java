package co.edu.unbosque.forestbet.formulamodule.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.forestbet.formulamodule.model.Circuit;
import java.util.List;


public interface CircuitRepository extends CrudRepository<Circuit, Long>{
	List<Circuit> findByCircuitIdName(String circuitIdName);
}
