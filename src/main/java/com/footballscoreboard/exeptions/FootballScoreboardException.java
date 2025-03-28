package main.java.com.footballscoreboard.exeptions;
	/**
	 * Base exception for Football Scoreboard application.
	 */
	public class FootballScoreboardException extends Exception {
	    public FootballScoreboardException(String message) {
	        super(message);
	    }

	    public FootballScoreboardException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
