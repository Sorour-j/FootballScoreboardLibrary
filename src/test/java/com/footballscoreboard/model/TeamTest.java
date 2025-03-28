package test.java.com.footballscoreboard.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.java.com.footbalscoreboard.model.Team;

public class TeamTest {

	
	 @Test
	    public void testTeamCreation() {
		//Test that a team is created correctly with the given name
		 	Team team = new Team("Mexico");
	        assertEquals("Mexico", team.getName());
	    }

	    @Test
	    public void testSetAndGetName() {
	    //Test the set and get methods
	        Team team = new Team("Canada");
	        assertEquals("Canada", team.getName());
	        team.setName("Canada");
	        assertEquals("Canada", team.getName());
	    }
	    
	    @Test
	    public void testTeamNameMustStartWithUppercase() {
	    // Ensure team name must start with upper-case
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            new Team("liverpool");
	        });
	    }
}
