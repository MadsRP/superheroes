package Database;

import java.util.ArrayList;

public class Superhero {

    private String name = "";
    private String superheroName = "";
    private double superStrengthNumber;
    private String superPowers = "";

    private Boolean isHuman;
    private int creationYear = 0;

    public Superhero(){

    }
    public Superhero(String name, String superheroName, String superPowers, double superStrengthNumber, int creationYear, boolean isHuman){
        this.name = name;
        this.superheroName = superheroName;
        this.superPowers = superPowers;
        this.superStrengthNumber = superStrengthNumber;
        this.creationYear = creationYear;
        this.isHuman = isHuman;

    }

    public void setName(String name){
        this.name = name;
    }

    public void setSuperheroName(String superheroName){
        this.superheroName = superheroName;
    }

    public void setSuperStrengthNumber(double superStrengthNumber){
        this.superStrengthNumber = superStrengthNumber;
    }

    public void setSuperPowers(String superPowers){
        this.superPowers = superPowers;
    }

    public void setIsHuman(Boolean isHuman){
       this.isHuman = isHuman;
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

    public double getSuperStrengthNumber(){
        return superStrengthNumber;
    }

    public String getSuperPowers(){
        return superPowers;
    }

    public int getCreationYear(){
        return creationYear;
    }

    public String printSuperheroShort(){
        String printSuperheroShort = "Navn: " + name +
                "\nSuperhelte Navn: " + superheroName;
        return printSuperheroShort;
    }

    public Boolean getHuman() {
        return isHuman;
    }

    public void setHuman(Boolean human) {
        isHuman = human;
    }

}

