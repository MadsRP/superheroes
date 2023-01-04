package Database;

import Database.Database;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private Scanner userInput = new Scanner(System.in);
    private Superhero superhero = new Superhero();
    private Database db = new Database();
    private FileWriter fw = new FileWriter(db.getSuperheroDatabase(), true);
    private BufferedWriter bw = new BufferedWriter(fw);
    private PrintWriter pw = new PrintWriter(bw);

    private BufferedReader bufferedReader = new BufferedReader(new FileReader(db.getSuperheroDatabase()));

    public Controller() throws IOException {
    }

    public ArrayList<Superhero> superheroList(){
        return db.superheroList();
    }



    public Superhero newSuperhero(String name, String superheroName, String superPowers, double superStrengthNumber, int creationYear, boolean isHuman){
        return db.newSuperhero(name, superheroName, superPowers, superStrengthNumber, creationYear, isHuman);
    }

    public void saveSuperhero(){
        db.saveSuperhero(db.getSuperheroes());
    }


    public void sletMedlem(int nr) {
        db.deleteSuperhero(nr);
    }

    public void searchSpecificHero(){
        db.searchSpecificHero();
    }

    public ArrayList<Superhero> sortByName(){
        return db.sortByName();
    }

    public ArrayList<Superhero> sortBySuperheroName(){
        return db.sortBySupername();
    }

    public ArrayList<Superhero> sortByPowers(){
        return db.sortByPowers();
    }
    public ArrayList<Superhero> sortByStrengthLevel(){
        return db.sortByStrengthLevel();
    }
    public ArrayList<Superhero> sortByCreationYear(){
        return db.sortByCreationYear();
    }
    public ArrayList<Superhero> sortByHuman(){
        return db.sortByIsHuman();
    }

    public void editSuperhero(int input, String newName, String newSuperheroName, String newSuperPowers, String newStrength, String newCreationYear, String newIsHuman) {
     db.editSuperhero(input, newName, newSuperheroName, newSuperPowers, newStrength, newCreationYear, newIsHuman);
    }
}
