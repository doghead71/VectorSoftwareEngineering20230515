/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.models;

/**
 *
 * @author Kraine
 */
public class TeamStatistics {
    
    private League league;
    private FootballTeam team;
    private int goalsScored;
    private int GoalsConceded;
    private int win;
    private int loss;
    private int draw;
    
//    constructor

    public TeamStatistics(League league, FootballTeam team, int goalsScored, int GoalsConceded, int win, int loss, int draw) {
        this.league = league;
        this.team = team;
        this.goalsScored = goalsScored;
        this.GoalsConceded = GoalsConceded;
        this.win = win;
        this.loss = loss;
        this.draw = draw;
    }
    
    
//    getters and setters

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public FootballTeam getTeam() {
        return team;
    }

    public void setTeam(FootballTeam team) {
        this.team = team;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return GoalsConceded;
    }

    public void setGoalsConceded(int GoalsConceded) {
        this.GoalsConceded = GoalsConceded;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
    
    
}
