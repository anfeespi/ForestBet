package co.edu.unbosque.forestbet.datamodule.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.forestbet.datamodule.model.Bet;

public interface BetRepository extends CrudRepository<Bet, Long>{

}
