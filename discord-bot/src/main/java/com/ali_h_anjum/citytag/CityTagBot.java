package com.ali_h_anjum.citytag;

//import java.util.Scanner;

import com.ali_h_anjum.citytag.models.*;
//import com.ali_h_anjum.citytag.services.*;
import com.ali_h_anjum.citytag.config.*;

public class CityTagBot {
    private static GameDetails gameDetails;


    public static void main(String[] args) throws InterruptedException {
        gameDetails = new GameDetails();

        System.out.println("City Tag Bot by Ali-H-Anjum Starting...");
        String token = "";
        BotConfig bot = new BotConfig(token, gameDetails);

        System.out.println(gameDetails.getNumPlayers());
        



        
        
        // Test your game classes
        //testGameLogic();
        
        // Add Discord bot startup later
    }

    
    static void testGameLogic() {                     // Will have to be a lot of services classes I imagine
        // Test your ported Python classes here
        System.out.println("Testing game classes...");

        
        
        // This will work once you create Team.java in models/
        // Team team = new Team(1);
        // team.addMember("TestPlayer");
        // System.out.println(team.toString());

        //They got the channel id
        Player[] playerList = allPlayers(); //Everybody in channel is added to a big array of members; might be better as a hashmap

        //joinTeam command with "teamName" which creates and adds or just adds a member (whoever called the command) to a team
        int indexOfPlayer = 0; // = the member that used the command

        //organizeTeams(playerList[indexOfPlayer]);
        //Team[] teams =
        }

    

    static Player[] allPlayers() {
        //All player ids in the channel are used to create member objects
        //These member objects are added to a matrix of allPlayers
        //returns the matrix

        String[] allPlayerIds = {"1050265668018262108", "1050265668018262142", "2050265668018262142", "7542502656680182621"};
        // Placeholder for testing

        Player[] allPlayers = new Player[allPlayerIds.length];

        for(int i = 0; i < allPlayerIds.length; i++){
            allPlayers[i] = new Player(allPlayerIds[i]);  //Creates a member object from their ids and adds them to the array
        }

        return allPlayers;
    }

    static void organizeTeams(Player m){
        GameDetails info = new GameDetails();
        //if teamName in GameDetails.teams: t1.addMember(m);            See if t1 can be the teamName via this

        //if !teamName in GameDetails.teams: Team t1 = new Team("teamName"); GameDetails.addTeam(t1); t1.addMember(m);
        info.addTeam(new Team("Dragons"));

    }
}