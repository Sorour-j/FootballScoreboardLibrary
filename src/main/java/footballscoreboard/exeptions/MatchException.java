package main.java.footballscoreboard.exeptions;

public class MatchException extends FootballScoreboardException {
	    public MatchException(String message) {
	        super(message);
	        }
	    
	public static class MatchAlreadyEndedException extends MatchException {
        public MatchAlreadyEndedException() {
            super("Cannot modify a match that has already ended.");
        }
    }
	
    public static class NegativeScoreException extends MatchException {
        public NegativeScoreException() {
            super("Score cannot be negative.");
        }
    }
}
