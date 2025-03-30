package com.footballscoreboard.model;

public class Team {

	private final String name; // the name of the team can not be changed

	// team can be created using name
	public Team(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Team name must not be empty and must start with an uppercase letter");
		}
		// Check if the team name contains only alphabetic characters
		if (!name.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Team name must only contain alphabetic characters.");
		}

		if (!Character.isUpperCase(name.charAt(0)))
			name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();

		this.name = name;
	}

	// return the name of the team
	public String getName() {
		return name;
	}
}
