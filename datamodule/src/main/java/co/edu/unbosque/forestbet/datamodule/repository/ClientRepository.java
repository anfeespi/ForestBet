package co.edu.unbosque.forestbet.datamodule.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.forestbet.datamodule.model.Client;
import java.util.List;


public interface ClientRepository extends CrudRepository<Client, Long>{
	List<Client> findByDocument(String document);
}
