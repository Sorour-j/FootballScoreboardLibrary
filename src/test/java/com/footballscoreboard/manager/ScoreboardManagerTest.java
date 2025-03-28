package test.java.com.footballscoreboard.manager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import main.java.com.footbalscoreboard.manager.ScoreboardManager;
import main.java.com.footbalscoreboard.model.FootballMatch;
import main.java.com.footbalscoreboard.model.Team;

public class ScoreboardManagerTest {
	
private ScoreboardManager scoreboar;
	
private ScoreboardManager board;
private Team teamA, teamB, teamC, teamD;

	    @Before
	    void setUp() {
	        board = new ScoreboardManager();
	        teamA = new Team("Mexico");
	        teamB = new Team("Canada");
	        teamC = new Team("Spain");
	        teamD = new Team("Brazil");
	    }

	    @Test
	    void testAddMatch() throws TeamAlreadyPlayingException {
	    	// Test adding a new match to the scoreboard
	        FootballMatch match = board.addMatch(teamA, teamB);
	        assertNotNull(match);
	        assertEquals(1, board.getMatchCount());
	    }

	    @Test
	    void testAddMatchWithTeamAlreadyPlaying() throws TeamAlreadyPlayingException {
	        board.addMatch(teamA, teamB);
	        assertThrows(TeamAlreadyPlayingException.class, () -> board.addMatch(teamA, teamC));
	    }

	    @Test
	    void testRemoveMatch(){
	    	// Test removing a match from scoreboard
	    	FootballMatch match = board.addMatch(teamA, teamB);
	        assertTrue(board.removeMatch(match));
	        assertEquals(0, board.getMatchCount());
	    }

	    @Test
	    void testRemoveNonExistentMatch() {
	    	// Test removing not existed match from scoreboard
	    	FootballMatch match = new FootballMatch(teamA, teamB);
	        assertFalse(board.removeMatch(match));
	    }

	    @Test
	    void testGetSummary() {
	    	// Test the summary of matches
	    	FootballMatch match1 = board.addMatch(teamA, teamB);
	    	FootballMatch match2 = board.addMatch(teamC, teamD);
	        
	        match1.updateScore(3, 1);
	        match2.updateScore(2, 2);

	        List<FootballMatch> summary = board.getSummary();
	        assertEquals(2, summary.size());
	        assertEquals(match2, summary.get(0)); // Higher total score
	        assertEquals(match1, summary.get(1));
	    }

	    @Test
	    void testGetMatchByTeam() throws TeamAlreadyPlayingException {
	    	// Test if a match can be found by one of the teams involved in it
	    	FootballMatch match = board.addMatch(teamA, teamB);
	        assertEquals(match, board.getMatchByTeam(teamA));
	        assertEquals(match, board.getMatchByTeam(teamB));
	        assertNull(board.getMatchByTeam(teamC));
	    }

	    @Test
	    void testUpdateScore() throws TeamAlreadyPlayingException {
	    	// Test updating score in the board
	    	FootballMatch match = board.addMatch(teamA, teamB);
	        board.updateScore(teamA, teamB, 2, 1);
	        assertEquals(2, match.getHomeScore());
	        assertEquals(1, match.getAwayScore());
	    }

	    @Test
	    void testUpdateScoreForNonExistentMatch() {
	        assertThrows(IllegalArgumentException.class, () -> board.updateScore(teamA, teamB, 2, 1));
	    }
}
