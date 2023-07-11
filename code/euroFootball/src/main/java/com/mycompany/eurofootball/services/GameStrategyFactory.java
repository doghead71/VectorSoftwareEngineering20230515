/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.services;

/**
 *
 * @author calmin
 */
public class GameStrategyFactory {
    
    public static GameStrategy getGameStrategy(){
        //throw new UnsupportedOperationException("not supported yet");
        
        //generate a random number
        int randomNumber = 0;
        GameStrategy gameStrategy = null;
        switch(randomNumber){
            case 0: gameStrategy = new PossessionBasedGameStrategyImpl();
            case 1: gameStrategy =  new PriorHeadResultsGameStrategyImpl();
            case 2: gameStrategy =  new LeaguePositionStrategyImpl();
        }
        
        return gameStrategy;
    }
    
}
