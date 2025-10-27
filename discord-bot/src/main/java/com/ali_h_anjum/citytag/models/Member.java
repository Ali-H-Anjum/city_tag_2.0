package com.ali_h_anjum.citytag.models;

public class Member {
    private String name;
    private int id;

    public Member(int id, String name){
        this(id);
        this.name = name;
    }

    public Member(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
}
