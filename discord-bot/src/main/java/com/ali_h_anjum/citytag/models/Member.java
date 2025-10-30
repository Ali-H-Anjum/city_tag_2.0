package com.ali_h_anjum.citytag.models;

public class Member {
    private String name;
    private String id;

    public Member(String id, String name){
        this(id);
        this.name = name;
    }

    public Member(String id){
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
