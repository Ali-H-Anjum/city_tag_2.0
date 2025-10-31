package com.ali_h_anjum.citytag.models;

public class Player {
    private String name;
    private String id;

    public Player(String id, String name){
        this(id);
        this.name = name;
    }

    public Player(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
}
