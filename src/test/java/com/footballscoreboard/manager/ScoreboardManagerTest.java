package com.footballscoreboard.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.footballscoreboard.exeptions.MatchException;
import com.footballscoreboard.exeptions.ScoreboardException.TeamAlreadyPlayingException;
import com.footballscoreboard.manager.ScoreboardManager;
import com.footballscoreboard.model.FootballMatch;
import com.footballscoreboard.model.Team;

public class ScoreboardManagerTest {

	private ScoreboardManager board;
	private Team teamA, teamB, teamC, teamD;

	@BeforeEach
	public void setUp() {
		board = new ScoreboardManager();
		teamA = new Team("Mexico");
		teamB = new Team("Canada");
		teamC = new Team("Spain");
		teamD = new Team("Brazil");
	}

	@Test
	public void testAddMatch() throws TeamAlreadyPlayingException, MatchException {
		// Test adding a new match to the scoreboard
		FootballMatch match = board.startMatch(teamA, teamB);
		assertNotNull(match);
		assertEquals(1, board.getMatchCount());
	}

	@Test
	public void testAddMatchWithTeamAlreadyPlaying() throws TeamAlreadyPlayingException, MatchException {
		board.startMatch(teamA, teamB);
		assertThrows(TeamAlreadyPlayingException.class, () -> board.startMatch(teamA, teamC));
	}

	@Test
	public void testRemoveMatch() throws TeamAlreadyPlayingException, MatchException {
		// Test removing a match from scoreboard
		FootballMatch match = board.startMatch(teamA, teamB);
		board.finishMatch(match);
		assertEquals(0, board.getMatchCount());
	}

	@Test
	public void testFinishNonExistentMatch() throws MatchException {
		// Test removing not existed match from scoreboard
		FootballMatch match = new FootballMatch(teamA, teamB);
		assertThrows(IllegalArgumentException.class, () -> board.finishMatch(match));
	}

	@Test
	public void testGetSummary() throws MatchException, TeamAlreadyPlayingException {
		// Test the summary of matches
		FootballMatch match1 = board.startMatch(teamA, teamB);
		FootballMatch match2 = board.startMatch(teamC, teamD);

		board.updateScore(match1, 3, 1);
		board.updateScore(match2, 2, 2);

		List<FootballMatch> summary = board.getSummary();
		assertEquals(2, summary.size());
		assertEquals(match2, summary.get(0)); // Higher total score
		assertEquals(match1, summary.get(1));
	}

	@Test
	public void testUpdateScore() throws MatchException, TeamAlreadyPlayingException {
		// Test that the scores are updated correctly

		FootballMatch match = board.startMatch(new Team("Mexico"), new Team("Canada"));
		board.updateScore(match, 2, 1);

		assertEquals(2, match.getHomeTeamScore());
		assertEquals(1, match.getAwayTeamScore());
	}

	@Test
	public void testGetTotalScore() throws MatchException, TeamAlreadyPlayingException {
		// Test the sum of scores
		FootballMatch match = board.startMatch(new Team("Mexico"), new Team("Canada"));
		board.updateScore(match, 2, 1);
		assertEquals(3, match.getTotalScore());
	}

	@Test
	public void testInvalidNegativeScoreUpdate() throws MatchException, TeamAlreadyPlayingException {
		// Test the validity of score
		FootballMatch match = board.startMatch(new Team("Mexico"), new Team("Canada"));
		assertThrows(MatchException.NegativeScoreException.class, () -> {
			board.updateScore(match, -1, 0);
		});

	}

	@Test
	public void testInvalidLowerScoreUpdate() throws MatchException, TeamAlreadyPlayingException {
		// Test the validity of score
		FootballMatch match = board.startMatch(new Team("Mexico"), new Team("Canada"));
		board.updateScore(match, 2, 3);
		assertThrows(MatchException.LowerScoreException.class, () -> {
			board.updateScore(match, 1, 3);
		});
	}

	@Test
	public void testSameTeamMatch() throws MatchException {
		// The invalid match is a match between same team!
		Assertions.assertThrows(MatchException.SameTeamMatchException.class, () -> {
			board.startMatch(new Team("Mexico"), new Team("Mexico"));
		});
	}
}
