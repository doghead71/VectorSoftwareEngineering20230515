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
    

    @Override
    public Footballer deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
//    constructor

    public Footballer(String firstName, String lastName, Date dateOfBirth, Boolean isInjured, Boolean isSuspended, String position, int playerRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.isInjured = isInjured;
        this.isSuspended = isSuspended;
        this.position = position;
        this.playerRating = playerRating;
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
    
    
}
