/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.models;





/**
 *
 * @author Kraine
 */
public class League extends BaseModel<League>{
   
    private String name;
    

    @Override
    public League deepClone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    constructor

    public League(String name) {
        this.name = name;
    }
    
//    getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
