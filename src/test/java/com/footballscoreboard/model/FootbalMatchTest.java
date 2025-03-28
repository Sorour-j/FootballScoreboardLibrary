package test.java.com.footballscoreboard.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.java.com.footballscoreboard.exeptions.MatchException;
import main.java.com.footbalscoreboard.model.FootballMatch;
import main.java.com.footbalscoreboard.model.Team;

public class FootbalMatchTest {

	@Test
    public void testFootballMatchCreation() {
		//Test that a match is created correctly with the given names
		FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
        assertEquals("Mexico", match.getHomeTeam().getName());
        assertEquals("Canada", match.getAwayTeam().getName());
        // Test that initial scores is set to 0
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
        // Test that Match is set as active when it is created
        assertEquals(true, match.isActive());
    }
	
	@Test
    public void testUpdateScore() throws MatchException {
		// Test that the scores are updated correctly
		FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
		match.updateScore(2 , 1);
		assertEquals(2, match.getHomeTeamScore());
        assertEquals(1, match.getAwayTeamScore());
	}
	
    @Test
    public void testGetTotalScore() throws MatchException {
    	// Test the sum of scores 
        FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
        match.updateScore(2, 1);
        assertEquals(3, match.getTotalScore());
    }
    
    @Test
    public void testInvalidScoreUpdate() throws MatchException{
        // Test the validity of score
    	FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
        assertThrows(MatchException.NegativeScoreException.class, () -> {
            match.updateScore(-1, 0);
        });
    }
}
