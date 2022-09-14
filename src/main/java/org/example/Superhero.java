package org.example;

public class Superhero {

    private String name = "";
    private String superheroName = "";
    private double strength;
    private String superPowers = "";
    private Boolean isHuman;
    private int creationYear = 0;

    private Boolean setHuman;

    private String isAHuman;

    public Superhero(){

    }
    public Superhero(String name, String superheroName, String superPowers, double strength, int creationYear, boolean isHuman){
        this.name = name;
        this.superheroName = superheroName;
        this.superPowers = superPowers;
        this.strength = strength;
        this.creationYear = creationYear;
        this.isHuman = isHuman;
        if (isHuman = true){
            isAHuman = "Ja";
        }else {
            isAHuman = "Nej";
        }

    }

    public void setName(String name){
        this.name = name;
    }

    public void setSuperheroName(String superheroName){
        this.superheroName = superheroName;
    }

    public void setStrength(double strength){
        this.strength = strength;
    }

    public void setSuperPowers(String superPowers){
        this.superPowers = superPowers;
    }

    public void setIsHuman(Boolean isHuman){
        if (isHuman = true){
            isAHuman = "Ja";
        }else {
            isAHuman = "Nej";
        }
    }

    public void setCreationYear(int creationYear){
        this.creationYear = creationYear;
    }

    public String getName(){
        return name;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public double getStrength(){
        return strength;
    }

    public String getSuperPowers(){
        return superPowers;
    }

    public int getCreationYear(){
        return creationYear;
    }

    public String getIsAHuman(){
        return isAHuman;
    }

    public String toString(){
        String toString = name + " " + superheroName + " " + superPowers + " " + strength + " " + creationYear + " " + isAHuman;
        return toString;
    }

    public String printSuperhero(){
        String printSuperhero = "Navn: " + name +
                "\nSuperhelte Navn: " + superheroName +
                "\nSuperkræfter: " + superPowers +
                "\nStyrke: " + strength +
                "\nSkabelses År: " + creationYear +
                "\nEr menneske: " + isAHuman;
        return printSuperhero;
    }
}

