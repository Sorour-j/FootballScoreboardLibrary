package test.java.com.footballscoreboard.model;

import static org.junit.Assert.assertEquals;

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
	    public void testGetName() {
	    //Test the get method
	        Team team = new Team("Canada");
	        assertEquals("Canada", team.getName());

	    }
	    
	    @Test
	    public void testTeamNameMustStartWithUppercase() {
	    // Ensure team name must start with upper-case
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            new Team("mexico");
	        });
	    }
	    
	    @Test
	    public void testTeamNameMustContainsOnlyAlphabeticCharacters() {
	    // Ensure team name must start with upper-case
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            new Team("Sp@in");
	        });
	    }
}
