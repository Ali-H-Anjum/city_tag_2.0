package com.ali_h_anjum.citytag.models;

public class HiderTeam extends Team {
    public HiderTeam(String teamName){
        super(teamName);
        super.setIsSeeker(false);;
    }
}
