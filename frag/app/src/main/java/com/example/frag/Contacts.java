package com.example.frag;

public class Contacts {
    int id;
    String name,ph;
    public Contacts(int id,String name,String ph){
        this.id = id;
        this.ph = ph;
        this.name = name;
    }
    public Contacts(String name,String ph){
        this.ph = ph;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPh() {
        return ph;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }
}
