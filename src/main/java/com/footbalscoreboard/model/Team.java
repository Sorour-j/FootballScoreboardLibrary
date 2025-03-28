package main.java.com.footbalscoreboard.model;

public class Team {
	
	private final String name; // the name of the team can not be changed
	
	// team can be created using name
	public Team(String name) {
		this.name = name;
	}
	
	// return the name of the team
	public String getName() {
		return name;
	}
}
