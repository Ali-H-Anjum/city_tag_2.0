package com.ali_h_anjum.citytag;

//import java.util.Scanner;

import com.ali_h_anjum.citytag.models.*;
//import com.ali_h_anjum.citytag.services.*;
import com.ali_h_anjum.citytag.config.*;

public class CityTagBot {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("City Tag Bot by Ali-H-Anjum Starting...");
        String token = "MTQzMjcxNTM2ODAxMDM1MDU5Mg.Gzbhb8.3Xdnaso60fvtZyBxXJl3xekV3CbMY9LjGBfm8Q";
        BotConfig bot = new BotConfig(token);

        



        
        
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
        Member[] playerList = allPlayers(); //Everybody in channel is added to a big array of members; might be better as a hashmap

        //joinTeam command with "teamName" which creates and adds or just adds a member (whoever called the command) to a team
        int indexOfPlayer = 0; // = the member that used the command

        //organizeTeams(playerList[indexOfPlayer]);
        //Team[] teams =
        }

    

    static Member[] allPlayers() {
        //All player ids in the channel are used to create member objects
        //These member objects are added to a matrix of allPlayers
        //returns the matrix

        String[] allPlayerIds = {"1050265668018262108", "1050265668018262142", "2050265668018262142", "7542502656680182621"};
        // Placeholder for testing

        Member[] allPlayers = new Member[allPlayerIds.length];

        for(int i = 0; i < allPlayerIds.length; i++){
            allPlayers[i] = new Member(allPlayerIds[i]);  //Creates a member object from their ids and adds them to the array
        }

        return allPlayers;
    }

    static void organizeTeams(Member m){
        GameDetails info = new GameDetails();
        //if teamName in GameDetails.teams: t1.addMember(m);            See if t1 can be the teamName via this

        //if !teamName in GameDetails.teams: Team t1 = new Team("teamName"); GameDetails.addTeam(t1); t1.addMember(m);
        info.addTeam(new Team("Dragons"));

    }
}