package main.java.com.footballscoreboard.model;

import main.java.com.footballscoreboard.exeptions.MatchException;

public class FootballMatch {
	
	private Team homeTeam;
	private Team awayTeam;
	private int homeTeamScore;
	private int awayTeamScore;
	
	public FootballMatch(Team homeTeam, Team awayTeam) throws MatchException {
		
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = 0;
		this.awayTeamScore = 0;
	}
	
	public int getTotalScore() {
		int totalScore = homeTeamScore + awayTeamScore;
		return totalScore;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public Team getAwayTeam() {
		return awayTeam;
	}
	
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	
	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	
	public void setAwayTeamScore(int awayTeamScore) {
		 this.awayTeamScore = awayTeamScore;
	}
}
