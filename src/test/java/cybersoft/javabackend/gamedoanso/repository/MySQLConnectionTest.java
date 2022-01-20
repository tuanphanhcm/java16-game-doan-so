package cybersoft.javabackend.gamedoanso.repository;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class MySQLConnectionTest {
	
	@Test
	public void getConnectionTest() {
		assertNotEquals(MySQLConnection.getConnection(), null);
	}
}
