package test.java.com.footballscoreboard.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.java.com.footballscoreboard.exeptions.MatchException;
import main.java.com.footballscoreboard.model.FootballMatch;
import main.java.com.footballscoreboard.model.Team;

public class FootbalMatchTest {

	@Test
    public void testFootballMatchCreation() throws MatchException {
		//Test that a match is created correctly with the given names
		FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
        assertEquals("Mexico", match.getHomeTeam().getName());
        assertEquals("Canada", match.getAwayTeam().getName());
        // Test that initial scores is set to 0
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
    }
	@Test
    public void testSameTeamMatch() throws MatchException{
        // The invalid match is a match between same team!
    	 Assertions.assertThrows(MatchException.SameTeamMatchException.class, () -> {
    		 new FootballMatch(new Team("Mexico"), new Team("Mexico"));
	        });
    }
}
