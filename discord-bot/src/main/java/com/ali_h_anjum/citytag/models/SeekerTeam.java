package com.ali_h_anjum.citytag.models;

public class SeekerTeam extends Team {
    public SeekerTeam(String teamName){
        super(teamName);
        super.setIsSeeker(true);
    }   
}
