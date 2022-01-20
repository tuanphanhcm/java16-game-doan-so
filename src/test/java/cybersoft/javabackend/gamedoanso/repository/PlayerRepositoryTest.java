package cybersoft.javabackend.gamedoanso.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import cybersoft.javabackend.gamedoanso.model.Player;

@TestInstance(Lifecycle.PER_CLASS)
public class PlayerRepositoryTest {
	private PlayerRepository repository;
	
	@BeforeAll
	public void setup() {
		repository = new PlayerRepository();
	}
	
	@BeforeEach
	private void addTestUser() {
		Player player = new Player();
		player.setUsername("testuser123");
		player.setName("Test User");
		player.setPassword("12345678");
		
		assertEquals(true, repository.save(player));
	}
	
	@AfterEach
	private void deleteTestUser() {
		assertEquals(true, repository.delete("testuser123"));
	}
	
	@Test
	public void findAllTest() {
		List<Player> players = repository.findAll();
		
		assertTrue(players.size() > 0);
	}
	
	@Test
	public void saveTest() {
		Player player = new Player();
		player.setUsername("testuser1234");
		player.setName("Test User");
		player.setPassword("12345678");
		
		assertEquals(true, repository.save(player));
		assertEquals(true, repository.delete("testuser1234"));
	}
	
	@Test
	public void deleteTest() {
		String username = "testuser123";
		
		boolean anotherResult = repository.delete(username);
		System.out.println("DELETE RESULT: " + anotherResult);
		assertTrue(anotherResult);
	}
}
