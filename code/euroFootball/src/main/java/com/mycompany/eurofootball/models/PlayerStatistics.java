package com.mycompany.eurofootball.models;

public class PlayerStatistics extends BaseModel<PlayerStatistics>{

    private FootballTeam team;
    private Footballer footballer;
    private int goals;
    private int assists;
    private int tackles;
    private int interceptions;
    private int cleanSheets;
    private int gameRating;

    @Override
    public PlayerStatistics deepClone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deepClone'");
    }
    
//     constructor

    public PlayerStatistics(FootballTeam team, Footballer footballer, int goals, int assists, int tackles, int interceptions, int cleanSheets, int gameRating) {
        this.team = team;
        this.footballer = footballer;
        this.goals = goals;
        this.assists = assists;
        this.tackles = tackles;
        this.interceptions = interceptions;
        this.cleanSheets = cleanSheets;
        this.gameRating = gameRating;
    }
    
//    getters and setters

    public FootballTeam getTeam() {
        return team;
    }

    public void setTeam(FootballTeam team) {
        this.team = team;
    }

    public Footballer getFootballer() {
        return footballer;
    }

    public void setFootballer(Footballer footballer) {
        this.footballer = footballer;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getTackles() {
        return tackles;
    }

    public void setTackles(int tackles) {
        this.tackles = tackles;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public int getGameRating() {
        return gameRating;
    }

    public void setGameRating(int gameRating) {
        this.gameRating = gameRating;
    }
    
    
}
