 
# Football Scoreboard
 
This is a simple library for managing a Football World Cup scoreboard. It provides the following core functionalities:

  - Start a match by specifying two teams. The first team is considered the home team and the second is the away team
  - Update the score using two integers, the first one represents the home team's score, and the second one represents the away team's score
  - Finish a match, after which the score can no longer be updated.
  - Display a summary of all in-progress matches.

# Assumptions and validations

- Each team name must be provided, and it should not be empty. Also, team names must only contain the alphabetic characters.

- The score for both teams must always be a positive number. Negative scores are not accepted.

- The score cannot be set to a lower value than the last updated score.
  
- Once a match is finished, no further changes can be made to the score.

- A team can only play one match at a time—they can’t be in two matches simultaneously.
  
-  A team cannot play against itself in a match.

- The summary of the ongoing matches will show the total score in order, with the most recent match appearing first if two matches have the same score.
  
- This library relies on user input, so it doesn’t handle real-time data or automatically update scores. You’ll need to input the scores manually.


# How to Use the Library

As this is a Maven project, you only need to add the following dependency to your project's pom.xml file to use the library:

```xml
<dependency>
  <groupId>com</groupId>
  <artifactId>footballscoreboard</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```
# Example Usage

Here's a simple example demonstrating how to start matches, update scores, finish a match and display the scoreboard summary:
```java

ScoreboardManager board = new ScoreboardManager();
FootballMatch match = board.startMatch(new Team("Mexico"), new Team("Canada"));
FootballMatch match2 = board.startMatch(new Team("Spain"), new Team("Brazil"));
FootballMatch match3 = board.startMatch(new Team("Germany"), new Team("France"));

board.updateScore(match, 0, 2);
board.updateScore(match2, 1, 2);
board.updateScore(match3, 1, 1);

board.finishMatch(match3);

for (FootballMatch m : board.getSummary()) {
    System.out.println(m.getHomeTeam().getName() + " " + m.getHomeTeamScore() + " - " +
                       m.getAwayTeam().getName() + " " + m.getAwayTeamScore());
}
```
# Expected Output
The output of the example is as follows:

``` enginx
Spain 1 - Brazil 2
Mexico 0 - Canada 2
```