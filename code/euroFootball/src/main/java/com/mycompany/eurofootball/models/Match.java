/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.models;

import java.util.Date;


/**
 *
 * @author Kraine
 */
public class Match extends BaseModel{
    private League league;
    private FootballTeam homeTeam;
    private FootballTeam awayTeam;
    private Date matchTime;
    private int matchWeek;
    private int awayTeamScore;
    private int homeTeamScore;

    @Override
    public BaseModel deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    constructor

    public Match(League league, FootballTeam homeTeam, FootballTeam awayTeam, LocalDate matchTime, int matchWeek, int awayTeamScore, int homeTeamScore) {
        this.league = league;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchTime = matchTime;
        this.matchWeek = matchWeek;
        this.awayTeamScore = awayTeamScore;
        this.homeTeamScore = homeTeamScore;
    }
    
    
//    getters and setters

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public FootballTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FootballTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FootballTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FootballTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public LocalDate getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDate matchTime) {
        this.matchTime = matchTime;
    }

    public int getMatchWeek() {
        return matchWeek;
    }

    public void setMatchWeek(int matchWeek) {
        this.matchWeek = matchWeek;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }
    
    
}
