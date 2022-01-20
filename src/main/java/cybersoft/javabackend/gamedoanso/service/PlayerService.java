package cybersoft.javabackend.gamedoanso.service;

import java.util.List;

import cybersoft.javabackend.gamedoanso.model.Player;
import cybersoft.javabackend.gamedoanso.repository.PlayerRepository;

public class PlayerService {
	private PlayerRepository repository;
	
	public PlayerService() {
		repository = new PlayerRepository();
	}
	
	public List<Player> findAll() {
		return repository.findAll();
	}
	
	public boolean save(Player player) {
		// validation logic
		
		return repository.save(player);
	}
	
	public boolean delete(String username) {
		// validation logic
		
		return repository.delete(username);
	}
}
