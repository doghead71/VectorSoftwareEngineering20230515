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
 * @author kalder
 */
public class HomeAdvantage implements GameStrategy {
    
    private FootballTeam teamA = new FootballTeam();
    private FootballTeam teamB = new FootballTeam();

    @Override
    public void playGame(Match match) {
        teamA=match.getHomeTeam();
        teamB=match.getAwayTeam();
        
        int homeAttempts = goalAttempts();
        int awayAttempts = goalAttempts();
        
        while(awayAttempts>homeAttempts){
            awayAttempts = goalAttempts();
        }
        
        int homeGoals = goalsScored(homeAttempts);
        int awayGoals = goalsScored(awayAttempts);
        
    }
    
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    public int goalAttempts(){
        int xG = getRandomNumber(1,20);
        
        return xG;        
    }
        
    public int scoreGoal(){
        int y=0;
        int goal=0;        
        int randomNum=getRandomNumber(0,1);
        
        if (y==randomNum) goal=1;
        
        return goal;
    }
    
    public int goalsScored(int xG){
        int totalGoals = 0;
        
        for(int i=1;i<=xG;i++){
            totalGoals += scoreGoal();
        }
        
        return totalGoals;
    }
    
    
}
