package main.java.com.footballscoreboard.model;

public class Team {
	
	private final String name; // the name of the team can not be changed
	
	// team can be created using name
	public Team(String name) {
		if (name == null || name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Team name must not be empty and must start with an uppercase letter");
        }
		// Check if the team name contains only alphabetic characters
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Team name must only contain alphabetic characters.");
        }
        
		this.name = name;
	}
	
	// return the name of the team
	public String getName() {
		return name;
	}
}
