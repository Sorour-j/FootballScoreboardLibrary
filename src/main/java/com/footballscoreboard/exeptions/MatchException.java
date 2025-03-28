package main.java.com.footballscoreboard.exeptions;

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
    
    public static class LowerScoreException extends MatchException {
        public LowerScoreException() {
            super("Decreasing the score is not allowed");
        }
    }
    
    public static class SameTeamMatchException extends MatchException {
        public SameTeamMatchException() {
            super("A team cannot play against itself!");
        }
    }
}
