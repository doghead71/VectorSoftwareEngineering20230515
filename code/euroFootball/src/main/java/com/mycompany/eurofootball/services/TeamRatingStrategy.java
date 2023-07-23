/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.models.FootballTeam;
import com.mycompany.eurofootball.models.Match;
import java.util.Random;

/**
 *
 * @author Kraine
 */
public class TeamRatingStrategy implements GameStrategy {
    
//    match rating is a number between 0 and 1 representing the team's strength
//    relative to the opponent's strength
    private double matchRatingHome;
    private double matchRatingAway;
    
    private FootballTeam homeTeam = new FootballTeam();
    private FootballTeam awayTeam = new FootballTeam();

    @Override
    public void playGame(Match match) {
        homeTeam = match.getHomeTeam();
        awayTeam = match.getAwayTeam();
        
        int homeTeamGoals = goalsScored(homeTeam.getTeamRating());
        int awayTeamGoals = goalsScored(awayTeam.getTeamRating());  
        match.setHomeTeamScore(homeTeamGoals);
        match.setAwayTeamScore(awayTeamGoals);
    }
    
    //generate random number
        private int getRandomNumber(int min, int max){
        Random rand = new Random();
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return randomNumber;
    }
    
     // set match rating for teams
    public void setMatchRatingHome(double teamRating, double opponentRating){
        matchRatingHome = teamRating / (teamRating + opponentRating);
    }
    
    public void setMatchRatingAway(double teamRating, double opponentRating){
        matchRatingAway = teamRating / (teamRating + opponentRating);
    }
    
    
//    total shots is a random number between 5 and 25 multiplied by the team's match rating.
    protected int totalShots(double matchRating){
        return (int) (getRandomNumber(5,25) * matchRating);
    }
    
    
    protected int attemptShot(){
//        A goal is scored when attempt == goal
        int score= 0;
        int attempt = getRandomNumber(1,5);
        int goal = getRandomNumber(1,5);
        if(attempt==goal) score = 1;
        return score;
    }
    
    
//    executes the generated number of shots and records how many resulted in goals
    public int goalsScored(double matchRating){
        int goals = 0;
        for(int i = 1;i<=totalShots(matchRating);i++){
            goals += attemptShot();
        }
        return goals;
    }
    
}
