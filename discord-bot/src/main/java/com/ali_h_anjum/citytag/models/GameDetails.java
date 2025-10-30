package com.ali_h_anjum.citytag.models;

public class GameDetails { //Need to fill with all the data, only using for team functionality for now
    private Team[] teams;
    private int numTeams;

    private Member[] allPlayers;
    private int numPlayers;

    public GameDetails(){
        teams = new Team[0];
        numTeams = 0;

        allPlayers = new Member[0];
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

    public void addMember(Member member){
        if (numPlayers == allPlayers.length) {
            Member[] tmp = new Member[allPlayers.length * 2];
            for (int i = 0; i < allPlayers.length; i++){
                tmp[i] = allPlayers[i];
            }
            allPlayers = tmp;
        }
        allPlayers[numPlayers] = member;
        numPlayers++;
    }
    
}
