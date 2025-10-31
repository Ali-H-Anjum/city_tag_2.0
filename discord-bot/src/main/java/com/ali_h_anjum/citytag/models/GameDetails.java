package com.ali_h_anjum.citytag.models;

public class GameDetails { //Need to fill with all the data, only using for team functionality for now
    private Team[] teams;
    private int numTeams;

    private Player[] allPlayers;
    private int numPlayers;

    public GameDetails(){
        teams = new Team[1];
        numTeams = 0;

        allPlayers = new Player[1];
        numPlayers = 0;
    }

    public void addTeam(Team team){
        if (numTeams == teams.length) {
            Team[] tmp = new Team[teams.length * 2];
            for (int i = 0; i < teams.length; i++){
                tmp[i] = teams[i];
            }
            teams = tmp;
        }
        teams[numTeams] = team;
        numTeams++;
    }

    public void addMember(Player member){
        if (numPlayers == allPlayers.length) {
            Player[] tmp = new Player[allPlayers.length * 2];
            for (int i = 0; i < allPlayers.length; i++){
                tmp[i] = allPlayers[i];
            }
            allPlayers = tmp;
        }
        allPlayers[numPlayers] = member;
        numPlayers++;
    }

    public int getNumPlayers(){
        return numPlayers;
    }
    
}
