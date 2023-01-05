package Database;

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
    //CRUD
    public ArrayList<Superhero> superheroList(){
        return db.superheroList();
    }

    public Superhero newSuperhero(String name, String superheroName, String superPowers, double superStrengthNumber, int creationYear, boolean isHuman){
        return db.newSuperhero(name, superheroName, superPowers, superStrengthNumber, creationYear, isHuman);
    }

    public void saveSuperhero(){
        db.saveSuperhero(db.getSuperheroes());
    }
    public void editSuperhero(int input, String newName, String newSuperheroName, String newSuperPowers, String newStrength, String newCreationYear, String newIsHuman) {
        db.editSuperhero(input, newName, newSuperheroName, newSuperPowers, newStrength, newCreationYear, newIsHuman);
    }

    public void sletMedlem(int nr) {
        db.deleteSuperhero(nr);
    }

    public void searchSpecificHero(){
        db.searchSpecificHero();
    }


    //SORTERS
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
    //NAMESORT
    public ArrayList<Superhero> sortByNameThenSuperHeroName(){
        return db.sortByNameThenSuperName();
    }
    public ArrayList<Superhero> sortByNameThenSuperPowers(){
        return db.sortByNameThenSuperPowers();
    }
    public ArrayList<Superhero> sortByNameThenStrength(){
        return db.sortByNameThenStrengthLevel();
    }
    public ArrayList<Superhero> sortByNameThenCreationYear(){
        return db.sortByNameThenCreationYear();
    }
    public ArrayList<Superhero> sortByNameThenHuman(){
        return db.sortByNameThenHuman();
    }

    //SUPERNAMESORT

    public ArrayList<Superhero> sortBySuperHeroNameThenName(){
        return db.sortBySuperheroNameThenName();
    }

    public ArrayList<Superhero> sortBySuperHeroNameThenSuperPowers(){
        return db.sortByNameThenSuperPowers();
    }
    public ArrayList<Superhero> sortBySuperHeroNameThenStrength(){
        return db.sortByNameThenStrengthLevel();
    }

    public ArrayList<Superhero> sortBySuperHeroNameThenCreationYear(){
        return db.sortByNameThenCreationYear();
    }

    public ArrayList<Superhero> sortBySuperHeroNameThenHuman(){
        return db.sortByNameThenHuman();
    }

    //POWERSSORT

    public ArrayList<Superhero> sortBySuperPowerThenName(){
        return db.sortByPowersThenName();
    }
    public ArrayList<Superhero> sortBySuperPowerThenSuperHeroName(){
        return db.sortByPowersThenSuperHeroName();
    }
    public ArrayList<Superhero> sortBySuperPowerThenStrength(){
        return db.sortByPowersThenStrength();
    }
    public ArrayList<Superhero> sortBySuperPowerThenCreationYear(){
        return db.sortByPowersThenCreationYear();
    }
    public ArrayList<Superhero> sortBySuperPowerThenHuman(){
        return db.sortByPowersThenHuman();
    }

    //STRENGTHSORT

    public ArrayList <Superhero> sortByStrengthThenName(){
        return db.sortByStrengthThenName();
    }

    public ArrayList <Superhero> sortByStrengthThenSuperHeroName(){
        return db.sortByStrengthThenSuperheroName();
    }

    public ArrayList <Superhero> sortByStrengthThenPowers(){
        return db.sortByStrengthThenPowers();
    }

    public ArrayList <Superhero> sortByStrengthThenCreationYear(){
        return db.sortByStrengthThenCreationYear();
    }

    public ArrayList <Superhero> sortByStrengthThenHuman(){
        return db.sortByStrengthThenHuman();
    }

    //CREATIONYEARSORT
    public ArrayList <Superhero> sortByCreationYearThenName(){
        return db.sortByCreationYearThenName();
    }
    public ArrayList <Superhero> sortByCreationYearThenSuperHeroName(){
        return db.sortByCreationYearThenSuperHeroName();
    }
    public ArrayList <Superhero> sortByCreationYearThenPowers(){
        return db.sortByCreationYearThenPowers();
    }
    public ArrayList <Superhero> sortByCreationYearThenStrength(){
        return db.sortByCreationYearThenStrength();
    }
    public ArrayList <Superhero> sortByCreationYearThenHuman(){
        return db.sortByCreationYearThenHuman();
    }

    //HUMANSORT

    public ArrayList <Superhero> sortByHumanThenName(){
        return db.sortByHumanThenName();
    }
    public ArrayList <Superhero> sortByHumanThenSuperHeroName(){
        return db.sortByHumanThenSuperHeroName();
    }
    public ArrayList <Superhero> sortByHumanThenPowers(){
        return db.sortByHumanThenSuperPowers();
    }
    public ArrayList <Superhero> sortByHumanThenStrength(){
        return db.sortByHumanThenStrength();
    }
    public ArrayList <Superhero> sortByHumanThenCreationYear(){
        return db.sortByHumanThenCreationYear();
    }






}
