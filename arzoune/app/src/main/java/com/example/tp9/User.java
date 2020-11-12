package com.example.tp9;

public class User {
    String email,name,password,score;
    public int id;
    public User(String email , String name , String password , String score){
        this.email=email;
        this.name=name;
        this.password=password;
        this.score=score;
    }
    public User(int id , String email , String name , String password , String score){
        this.email=email;
        this.name=name;
        this.password=password;
        this.score=score;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }

    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getScore(){
        return this.score;
    }
}

