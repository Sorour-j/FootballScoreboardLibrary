package com.footballscoreboard.exeptions;

public class FootballScoreboardException extends Exception {
	public FootballScoreboardException(String message) {
		super(message);
	}

	public FootballScoreboardException(String message, Throwable cause) {
		super(message, cause);
	}
}
