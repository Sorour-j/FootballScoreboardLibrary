package test.java.com.footballscoreboard.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.java.com.footbalscoreboard.model.FootballMatch;
import main.java.com.footbalscoreboard.model.Team;

public class FootbalMatchTest {

	@Test
    public void testFootballMatchCreation() {
		//Test that a match is created correctly with the given names
		FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
        assertEquals("Mexico", match.getHomeTeam());
        assertEquals("Canada", match.getAwayTeam());
        // Test that initial scores is set to 0
        assertEquals("0", match.getHomeTeamScore());
        assertEquals("0", match.getAwayTeamScore());
        // Test that Match is set as active when it is created
        assertEquals(true, match.isActive());
    }
	
	@Test
    public void testUpdateScore() {
		// Test that the scores are updated correctly
		FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
		match.updateScore(2 , 1);
		assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
	}
	
    @Test
    public void testGetTotalScore() {
    	// Test the sum of scores 
        FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
        match.updateScore(2, 1);
        assertEquals(3, match.getTotalScore());
    }
    
    @Test
    public void testInvalidScoreUpdate() {
        // Test the validity of score
    	FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
        assertThrows(IllegalArgumentException.class, () -> {
            match.updateScore(-1, 0);
        });
    }
}
