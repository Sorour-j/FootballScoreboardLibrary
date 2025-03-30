package com.footballscoreboard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.footballscoreboard.exeptions.MatchException;
import com.footballscoreboard.model.FootballMatch;
import com.footballscoreboard.model.Team;

public class FootbalMatchTest {

	@Test
	public void testFootballMatchCreation() throws MatchException {
		// Test that a match is created correctly with the given names
		FootballMatch match = new FootballMatch(new Team("Mexico"), new Team("Canada"));
		assertEquals("Mexico", match.getHomeTeam().getName());
		assertEquals("Canada", match.getAwayTeam().getName());
		// Test that initial scores is set to 0
		assertEquals(0, match.getHomeTeamScore());
		assertEquals(0, match.getAwayTeamScore());
	}

	@Test
	public void testSameTeamMatch() throws MatchException {
		// The invalid match is a match between same team!
		Assertions.assertThrows(MatchException.SameTeamMatchException.class, () -> {
			new FootballMatch(new Team("Mexico"), new Team("Mexico"));
		});
	}
}
