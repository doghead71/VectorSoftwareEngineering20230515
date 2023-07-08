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
public class Footballer extends BaseModel<Footballer>{
    
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Boolean isInjured;
    private Boolean isSuspended;
    private String position;
    private int playerRating;
    private int bookingsLeft;
    private double passing;
    private double shooting;
    private double tackling;
    private double defDiscipline;
    private double goalkeeping;

    

    @Override
    public Footballer deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
//    constructor

    public Footballer(String firstName, String lastName, Date dateOfBirth, Boolean isInjured, Boolean isSuspended, String position, int playerRating, int bookingsLeft, double passing, double shooting, double tackling, double defDiscipline, double goalkeeping) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.isInjured = isInjured;
        this.isSuspended = isSuspended;
        this.position = position;
        this.playerRating = playerRating;
        this.bookingsLeft = bookingsLeft;
        this.passing = passing;
        this.shooting = shooting;
        this.tackling = tackling;
        this.defDiscipline = defDiscipline;
        this.goalkeeping = goalkeeping;
    }

    
//    getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getIsInjured() {
        return isInjured;
    }

    public void setIsInjured(Boolean isInjured) {
        this.isInjured = isInjured;
    }

    public Boolean getIsSuspended() {
        return isSuspended;
    }

    public void setIsSuspended(Boolean isSuspended) {
        this.isSuspended = isSuspended;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(int playerRating) {
        this.playerRating = playerRating;
    }

    

    public int getBookingsLeft() {
        return bookingsLeft;
    }

    public void setBookingsLeft(int bookingsLeft) {
        this.bookingsLeft = bookingsLeft;
    }

    public double getPassing() {
        return passing;
    }

    public void setPassing(double passing) {
        this.passing = passing;
    }

    public double getShooting() {
        return shooting;
    }

    public void setShooting(double shooting) {
        this.shooting = shooting;
    }

    public double getTackling() {
        return tackling;
    }

    public void setTackling(double tackling) {
        this.tackling = tackling;
    }

    public double getDefDiscipline() {
        return defDiscipline;
    }

    public void setDefDiscipline(double defDiscipline) {
        this.defDiscipline = defDiscipline;
    }

    public double getGoalkeeping() {
        return goalkeeping;
    }

    public void setGoalkeeping(double goalkeeping) {
        this.goalkeeping = goalkeeping;
    }
    
    
}
