package com.mycompany.eurofootball.models;

public class SquadList {
    private Footballer footballer;
    private FootballTeam footballTeam;



    //constructor

    public SquadList(Footballer footballer, FootballTeam footballTeam) {
        this.footballer = footballer;
        this.footballTeam = footballTeam;
    }
    
    //getters and setters

    public Footballer getFootballer() {
        return footballer;
    }

    public void setFootballer(Footballer footballer) {
        this.footballer = footballer;
    }

    public FootballTeam getFootballTeam() {
        return footballTeam;
    }

    public void setFootballTeam(FootballTeam footballTeam) {
        this.footballTeam = footballTeam;
    }
    
}
