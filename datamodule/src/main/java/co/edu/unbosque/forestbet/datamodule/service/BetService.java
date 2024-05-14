package co.edu.unbosque.forestbet.datamodule.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.forestbet.datamodule.model.Bet;
import co.edu.unbosque.forestbet.datamodule.repository.BetRepository;

@Service
public class BetService {
	@Autowired
	private BetRepository betRepository;
	
	public BetService() {
		// TODO Auto-generated constructor stub
	}
	
	public void doABet(Bet bet) {
		betRepository.save(bet);
	}
	
	public void retireBet(Long id) {
		betRepository.deleteById(id);
	}
	
	public Optional<Bet> searchBetById(Long id) {
		return betRepository.findById(id);
	}
}
