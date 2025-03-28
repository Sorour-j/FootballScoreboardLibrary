package main.java.com.footballscoreboard.manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import main.java.com.footballscoreboard.exeptions.MatchException;
import main.java.com.footballscoreboard.exeptions.ScoreboardException;
import main.java.com.footballscoreboard.exeptions.ScoreboardException.TeamAlreadyPlayingException;
import main.java.com.footballscoreboard.model.FootballMatch;
import main.java.com.footballscoreboard.model.Team;

public class ScoreboardManager {
	
	private List<FootballMatch> matches;
	
	
	public ScoreboardManager() {
		this.matches = new ArrayList<FootballMatch>();
	}
	
	// Start a new match by name of playing teams
	public FootballMatch startMatch (Team homeTeam, Team awayTeam) throws TeamAlreadyPlayingException, MatchException {
		if (isTeamPlaying(homeTeam) || isTeamPlaying(awayTeam))
			 throw new ScoreboardException.TeamAlreadyPlayingException();
		
		FootballMatch match = new FootballMatch (homeTeam, awayTeam);
		matches.add(match);
		return match;
	}
	
	// Finish a specific match
	public void finishMatch(FootballMatch match) {
		if (matches.contains(match)) {
			match.isFinished();
			matches.remove(match);	
		}
		else
			throw new IllegalArgumentException("Match not found on the scoreboard");
	}

	
	// Display the scoreboard, sort the matched by total score
	public List<FootballMatch> getSummary(){
		List<FootballMatch> summary = new ArrayList<>(matches);
		// Sort the matches with total score, if equal compare the indexes to find the most resent one
        summary.sort(Comparator.comparingInt(FootballMatch::getTotalScore)
        		.reversed()
        		.thenComparing(summary::indexOf, Comparator.reverseOrder()));
        return summary;
		
	}
	
	public int getMatchCount() {
		return matches.size();
	}
	// Check if the team is playing in any active match
	private boolean isTeamPlaying(Team team) {
		return matches.stream().anyMatch(m -> m.getHomeTeam().getName().equals(team.getName()) || m.getAwayTeam().getName().equals(team.getName()));
	}

}
