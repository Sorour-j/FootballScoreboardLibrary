package test.java.com.footballscoreboard.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.com.footbalscoreboard.manager.ScoreboardManager;
import main.java.com.footbalscoreboard.model.FootballMatch;
import main.java.com.footbalscoreboard.model.Team;
import main.java.footballscoreboard.exeptions.MatchException;
import main.java.footballscoreboard.exeptions.ScoreboardException.TeamAlreadyPlayingException;

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
	        FootballMatch match = board.startMatch(teamA, teamB);
	        assertNotNull(match);
	        assertEquals(1, board.getMatchCount());
	    }

	    @Test
	    void testAddMatchWithTeamAlreadyPlaying() throws TeamAlreadyPlayingException {
	        board.startMatch(teamA, teamB);
	        assertThrows(TeamAlreadyPlayingException.class, () -> board.startMatch(teamA, teamC));
	    }

	    @Test
	    void testRemoveMatch() throws TeamAlreadyPlayingException{
	    	// Test removing a match from scoreboard
	    	FootballMatch match = board.startMatch(teamA, teamB);
	        board.finishMatch(match);
	        assertEquals(0, board.getMatchCount());
	    }

	    @Test
	    void testFinishNonExistentMatch() {
	    	// Test removing not existed match from scoreboard
	    	FootballMatch match = new FootballMatch(teamA, teamB);
	    	//assertThrows(IllegalArgumentException.class, () -> board.startMatch(teamA, teamC));
	    }

	    @Test
	    void testGetSummary() throws MatchException, TeamAlreadyPlayingException {
	    	// Test the summary of matches
	    	FootballMatch match1 = board.startMatch(teamA, teamB);
	    	FootballMatch match2 = board.startMatch(teamC, teamD);
	        
	        match1.updateScore(3, 1);
	        match2.updateScore(2, 2);

	        List<FootballMatch> summary = board.getSummary();
	        assertEquals(2, summary.size());
	        assertEquals(match2, summary.get(0)); // Higher total score
	        assertEquals(match1, summary.get(1));
	    }
}
