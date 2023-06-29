/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.eurofootball;

import com.mycompany.eurofootball.models.FootballTeam;
import com.mycompany.eurofootball.models.Match;
import com.mycompany.eurofootball.services.GameStrategyFactory;
import com.mycompany.eurofootball.services.MatchGenerator;
import com.mycompany.eurofootball.services.MatchGeneratorFactory;
import com.mycompany.eurofootball.services.GameStrategy;

/**
 *
 * @author calmin
 */
public class EuroFootball {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //sample game flow
        MatchGenerator matchGenerator = MatchGeneratorFactory.getMatchGenerator();
        Match match = matchGenerator.generateMatch();
        GameStrategy gameStrategy = GameStrategyFactory.getGameStrategy();
        gameStrategy.playGame(match);
        
        
    }
}
