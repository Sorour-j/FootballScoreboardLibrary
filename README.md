 
# ⚽ Football World Cup Scoreboard
 
This is a simple library for managing a Football World Cup scoreboard. It provides the following core functionalities:

  - Start a match by specifying two teams. The first team is considered the home team and the second is the away team
  - Update the score using two integers, the first one represents the home team's score, and the second one represents the away team's score
  - Finish a match, after which the score can no longer be updated.
  - Display a summary of all in-progress matches.

# 🤔 Assumptions

- Each team name must be provided, and it should not be empty. Also, team names should start with an uppercase letter (e.g., "Norway" not "norway").

- The score for both teams must always be a positive number. Negative scores are not accepted.

- Once a match is finished, no further changes can be made to the score.

- This library relies on user input, so it doesn’t handle real-time data or automatically update scores. You’ll need to input the scores manually.

- A team can only play one match at a time—they can’t be in two matches simultaneously.

- The summary of the ongoing matches will show the total score in order, with the most recent match appearing first if two matches have the same score.
