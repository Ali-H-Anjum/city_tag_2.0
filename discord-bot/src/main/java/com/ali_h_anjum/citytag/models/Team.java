package com.ali_h_anjum.citytag.models;

public class Team {
    private String teamName;
    private int points;

    private Player[] members;
    private int numMembers;

    //private Challenge[] completedChallenges;
    //private Power[] boughtPowers;
    //Will add later ^^^

    private boolean isSeeker;

    public Team(String teamName){ //maybe require at least one member in the constructor
        this.teamName = teamName;
        points = 20;

        members = new Player[0];
        numMembers = 0;
    }

    public String getTeamName(){
        return teamName;
    }

    public int getPoints(){
        return points;
    }

    public boolean getIsSeeker(){
        return isSeeker;
    }

    public Player getMember(int i){
        return members[i];
    }

    public int getNumMembers(){
        return numMembers;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void setIsSeeker(boolean isSeeker){
        this.isSeeker = isSeeker;
    }

    public void addMember(Player member){
        if (numMembers == members.length) {
            Player[] tmp = new Player[members.length * 2];
            for (int i = 0; i < members.length; i++){
                tmp[i] = members[i];
            }
            members = tmp;
        }
        members[numMembers] = member;
        numMembers++;
    }
}
