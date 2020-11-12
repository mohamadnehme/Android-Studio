package com.example.login;

public class Users {
    int id;
    String email,pass,fname,lname;
    public Users(){ }
    public Users(int id,String fname,String lname,String email,String pass){
        this.id=id;
        this.email=email;
        this.pass=pass;
        this.fname=fname;
        this.lname=lname;
    }
    public Users(String fname,String lname,String email,String pass){
        this.email=email;
        this.pass=pass;
        this.fname=fname;
        this.lname=lname;
    }
    public int getID(){
        return this.id;
    }
    // setting id
    public void setID(int id){
        this.id = id;
    }
    // getting name
    public String getEmail(){
        return this.email;
    }
    // setting name
    public void setEmail(String email){
        this.email = email;
    }
    // getting name
    public String getPass(){
        return this.pass;
    }
    // setting name
    public void setFname(String name){
        this.fname = fname;
    }
    public String getFname(){
        return this.fname;
    }
    public void setLname(String name){
        this.lname = lname;
    }
    public String getLname(){
        return this.lname;
    }
}
