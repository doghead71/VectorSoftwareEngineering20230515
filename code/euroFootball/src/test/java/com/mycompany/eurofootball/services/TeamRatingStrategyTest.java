/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.eurofootball.services;

import com.mycompany.eurofootball.models.FootballTeam;
import com.mycompany.eurofootball.models.Match;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Kraine
 */
public class TeamRatingStrategyTest{
    
    
    @Mock
    private Match match;
    
    
    
    public TeamRatingStrategyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of playGame method, of class TeamRatingStrategy.
     */
    @Test
    public void testPlayGame() {
        System.out.println("Play Game");
        FootballTeam homeTeam = Mockito.mock(FootballTeam.class);
        FootballTeam awayTeam = Mockito.mock(FootballTeam.class);
        
        match = Mockito.mock(Match.class);
        
        Mockito.when(match.getHomeTeam()).thenReturn(homeTeam);
        Mockito.when(match.getAwayTeam()).thenReturn(awayTeam);
        
        TeamRatingStrategy instance = new TeamRatingStrategy();
        instance.playGame(match);
        
        assertTrue(instance.getHomeTeamScore() >= 0 && instance.getAwayTeamScore()>=0);
        
    }

    /**
     * Test of setMatchRatingHome method, of class TeamRatingStrategy.
     */
    @Test
    public void testSetMatchRatingHome() {
        System.out.println("Set Match Rating Home");
        double teamRating = 60.0;
        double opponentRating = 40.0;
        TeamRatingStrategy instance = new TeamRatingStrategy();
        instance.setMatchRatingHome(teamRating, opponentRating);
        
        double expResult = 0.6;
        double result = instance.getMatchRatingHome();
        assertEquals(expResult, result,0.01);
    }

    /**
     * Test of setMatchRatingAway method, of class TeamRatingStrategy.
     */
    @Test
    public void testSetMatchRatingAway() {
        System.out.println("Set Match Rating Away");
        double teamRating = 40.0;
        double opponentRating = 60.0;
        TeamRatingStrategy instance = new TeamRatingStrategy();
        instance.setMatchRatingAway(teamRating, opponentRating);
        
        double expResult = 0.4;
        double result = instance.getMatchRatingAway();
        assertEquals(expResult, result,0.01);
    }

    /**
     * Test of totalShots method, of class TeamRatingStrategy.
     */
    @Test
    public void testTotalShots() {
        System.out.println("Total Shots");
        double matchRating = 1;
        TeamRatingStrategy instance = new TeamRatingStrategy();
        int result = instance.totalShots(matchRating);
        
        assertTrue(result>=5 && result<=25);
    }

    /**
     * Test of attemptShot method, of class TeamRatingStrategy.
     */
    @Test
    public void testAttemptShot() {
        System.out.println("Attempt Shot");
        TeamRatingStrategy instance = new TeamRatingStrategy();
        int result = instance.attemptShot();
        
        assertTrue(result==0 || result==1);
    }

    /**
     * Test of goalsScored method, of class TeamRatingStrategy.
     */
    @Test
    public void testGoalsScored() {
        System.out.println("Goals Scored");
        double matchRating = 0.5;
        TeamRatingStrategy instance = new TeamRatingStrategy();
        int result = instance.goalsScored(matchRating);
        
        assertTrue(result>=0);
        
        
    }
    
}
