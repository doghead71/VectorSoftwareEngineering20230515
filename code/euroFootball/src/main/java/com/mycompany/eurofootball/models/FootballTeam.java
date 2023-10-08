/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.models;

/**
 *
 * @author calmin
 */
public class FootballTeam extends BaseModel<FootballTeam>{
    
    private String name;
    private String homeStadium;
    private User user;
    private League league;
    private double attack;
    private double defense;
    private double teamRating;

    @Override
    public FootballTeam deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    contructors

    public FootballTeam(String name, String homeStadium, User user, League league, double attack, double defense, double teamRating) {
        this.name = name;
        this.homeStadium = homeStadium;
        this.user = user;
        this.league = league;
        this.attack = attack;
        this.defense = defense;
        this.teamRating = teamRating;
    }

    
    
//    getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeStadium() {
        return homeStadium;
    }

    public void setHomeStadium(String homeStadium) {
        this.homeStadium = homeStadium;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getTeamRating() {
        return teamRating;
    }

    public void setTeamRating(double teamRating) {
        this.teamRating = teamRating;
    }
    
    
}
