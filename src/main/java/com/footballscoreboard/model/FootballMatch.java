package main.java.com.footballscoreboard.model;

import main.java.com.footballscoreboard.exeptions.MatchException;

public class FootballMatch {
	
	private Team homeTeam;
	private Team awayTeam;
	private int homeScore;
	private int awayScore;
	private boolean isActive;
	
	public FootballMatch(Team homeTeam, Team awayTeam) {
		
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = 0;
		this.awayScore = 0;
		this.isActive = true;
	}
	
	public void updateScore(int homeScore, int awayScore) throws MatchException {
		validateMatchActive();
		validateGoals(homeScore);
		validateGoals(awayScore);
		
		this.homeScore = homeScore;
		this.awayScore = awayScore;
	}
	
	public int getTotalScore() {
		int totalScore = homeScore + awayScore;
		return totalScore;
	}
	
	public boolean isActive () {
		return isActive;
	}
	
	public void isFinished () {
		this.isActive = false;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public Team getAwayTeam() {
		return awayTeam;
	}
	
	public int getHomeTeamScore() {
		return homeScore;
	}
	
	public int getAwayTeamScore() {
		return awayScore;
	}
	
	private void validateMatchActive() throws MatchException {
        if (!isActive) {
            throw new MatchException.MatchAlreadyEndedException();
        }
    }
	
	 private void validateGoals(int goals) throws MatchException {
	        if (goals < 0) {
	            throw new MatchException.NegativeScoreException();
	        }
	    }
	
}
