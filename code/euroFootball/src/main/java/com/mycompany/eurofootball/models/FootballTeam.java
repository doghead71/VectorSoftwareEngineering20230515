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

    @Override
    public FootballTeam deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    contructors

    public FootballTeam(Long universalIdentifier,String name, String homeStadium, User user) {
        
        this.name = name;
        this.homeStadium = homeStadium;
        this.user = user;
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
    
    
}
