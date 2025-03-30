package com.footballscoreboard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.footballscoreboard.model.Team;

public class TeamTest {

	@Test
	public void testTeamCreation() {
		// Test that a team is created correctly with the given name
		Team team = new Team("Mexico");
		assertEquals("Mexico", team.getName());
	}

	@Test
	public void testGetName() {
		// Test the get method
		Team team = new Team("Canada");
		assertEquals("Canada", team.getName());

	}

	@Test
	public void testTeamNameMustStartWithUppercase() {
		// Ensure team name must start with upper-case and rest must be lower-case
		Team team = new Team("meXico");
		assertEquals("Mexico", team.getName());
	}

	@Test
	public void testTeamNameMustContainsOnlyAlphabeticCharacters() {
		// Ensure team name must start with upper-case
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Team("Sp@in");
		});
	}
}
