package com.footballscoreboard.exeptions;

public class ScoreboardException extends FootballScoreboardException {
	public ScoreboardException(String message) {
		super(message);
	}

	public static class TeamAlreadyPlayingException extends ScoreboardException {
		public TeamAlreadyPlayingException() {
			super("One of the teams is already palying in another match");
		}
	}
}
