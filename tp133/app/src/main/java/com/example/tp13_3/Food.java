package com.example.tp13_3;

public class Food {
    int _id;
    String _name;
    String _categorie;
    String _recette;

    public Food(){ }
// constructor 1 with id
    public Food(int id, String name, String _categorie , String _recette){
        this._id = id;
        this._name = name;
        this._categorie = _categorie;
        this._recette = _recette;
    }
    public Food(String name, String _categorie , String _recette){
        this._name = name;
        this._categorie = _categorie;
        this._recette = _recette;
    }
    // getting ID public
     int getID(){ return this._id; }
// setting id
    public void setID(int id){ this._id = id; }
// getting name
    public String getName(){ return this._name; }
// setting name
    public void setName(String name){ this._name = name; }
// gettingphone number
    public String get_categorie(){ return this._categorie; }
// setting phone number
    public void set_categorie(String categorie){ this._categorie = categorie; }

    public String get_recette(){ return this._recette;}

    public void set_recette(String _recette) {
        this._recette = _recette;
    }
}
