package Database;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import ComparatorPackage.*;

public class Database {
    private static FileHandler fh = new FileHandler();
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public Database()  throws FileNotFoundException{

    }

    public Superhero newSuperhero(String name, String superheroName, String superPowers, double superStrengthNumber, int creationYear, boolean isHuman){
        Superhero superhero = new Superhero(name, superheroName, superPowers, superStrengthNumber, creationYear, isHuman);
        superheroes.add(superhero);
        return superhero;
    }


    public void saveSuperhero(ArrayList<Superhero> saveSuperHero){
        fh.saveSuperhero(saveSuperHero);
    }

    public ArrayList<Superhero> superheroList(){
        return fh.superheroList();
    }


    public void superheroListPrint(){
        for (int i = 0; i < superheroList().size(); i++) {
            System.out.println(i + 1 + ") " + superheroList().get(i).getName() + ", " + superheroList().get(i).getSuperheroName());
        }
    }



    public void deleteSuperhero(int input){
        ArrayList<String> tempSuperhero = new ArrayList<>();
        try (Scanner scanner = new Scanner(getSuperheroDatabase())) {
            while (scanner.hasNext()) {
                tempSuperhero.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        tempSuperhero.remove(input-1);

        try {PrintWriter pw = new PrintWriter(getSuperheroDatabase());
            for (String medlem : tempSuperhero){
                pw.println(medlem);
            }pw.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void searchSpecificHero(){
        Scanner userInput = new Scanner(System.in);
        superheroListPrint();
        System.out.println("Hvilken superhelt kunne du tænke dig at se?");
        int input = userInput.nextInt()-1;
        try {
            if (input > superheroList().size()) {
                System.out.println("Venligst indtast et tal fra listen.");
            } else {
                System.out.println("Navn: " + superheroList().get(input).getName());
                System.out.println("Superheltenavn: " + superheroList().get(input).getSuperheroName());
                System.out.println("Kræfter: " + superheroList().get(input).getSuperPowers());
                System.out.println("Styrkeniveau: " + superheroList().get(input).getSuperStrengthNumber());
                System.out.println("Navn: " + superheroList().get(input).getCreationYear());
                if (superheroList().get(input).getHuman()){
                    System.out.println("Menneske: Ja");
                } else {
                    System.out.println("Menneske: Nej");
                }
            }
        } catch (NumberFormatException e){
            System.out.println("Venligst indtast et nummer.");
        }

    }




    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(ArrayList<Superhero> superheroes) {
        this.superheroes = superheroes;
    }


    public File getSuperheroDatabase() {
        return fh.getSuperheroDatabase();
    }

    public void setSuperheroDatabase() {
        fh.setSuperheroDatabase(fh.getSuperheroDatabase());
    }

    //SORTING

    public ArrayList sortByName(){
        ArrayList<Superhero> tempSuperhero = new ArrayList<>((superheroList()));
        Collections.sort(tempSuperhero, new NameComparator());
        return tempSuperhero;
    }

    public ArrayList sortBySupername(){
        ArrayList<Superhero> tempSuperhero = new ArrayList<>((superheroList()));
        Collections.sort(tempSuperhero, new SuperheroNameComparator());
        return tempSuperhero;
    }
    public ArrayList sortByPowers(){
        ArrayList<Superhero> tempSuperhero = new ArrayList<>((superheroList()));
        Collections.sort(tempSuperhero, new SuperPowersComparator());
        return tempSuperhero;
    }
    public ArrayList sortByStrengthLevel(){
        ArrayList<Superhero> tempSuperhero = new ArrayList<>((superheroList()));
        Collections.sort(tempSuperhero, new StrengthComparator());
        return tempSuperhero;
    }
    public ArrayList sortByCreationYear(){
        ArrayList<Superhero> tempSuperhero = new ArrayList<>((superheroList()));
        Collections.sort(tempSuperhero, new CreationYearComparator());
        return tempSuperhero;
    }
    public ArrayList sortByIsHuman(){
        ArrayList<Superhero> tempSuperhero = new ArrayList<>((superheroList()));
        Collections.sort(tempSuperhero, new NameComparator());
        return tempSuperhero;
    }


    public void editSuperhero(int input, String newName, String newSuperheroName, String newSuperPowers, String newStrength, String newCreationYear, String newIsHuman) {

        Superhero superhero = superheroList().get(input-1);
        if (newName.isEmpty()){
            superhero.setName(superhero.getName());
        } else {
            superhero.setName(newName);
        }
        if (newSuperheroName.isEmpty()){
            superhero.setSuperheroName(superhero.getName());
        } else {
            superhero.setSuperheroName(newSuperheroName);
        }
        if (newSuperPowers.isEmpty()){
            superhero.setSuperPowers(superhero.getSuperPowers());
        } else {
            superhero.setSuperPowers(newSuperPowers);
        }

        if (newSuperPowers.isEmpty()){
            superhero.setSuperPowers(superhero.getSuperPowers());
        } else {
            double newStrengthNumber;
            try{
                newStrengthNumber = DecimalFormat.getNumberInstance().parse(newStrength).doubleValue();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if (newCreationYear.isEmpty()){
            superhero.setCreationYear(superhero.getCreationYear());
        } else {
            double newCreationYearNumber;
            try{
                newCreationYearNumber = DecimalFormat.getNumberInstance().parse(newStrength).intValue();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if (newIsHuman.isEmpty()){
            superhero.setIsHuman(superhero.getHuman());
        } else if (newIsHuman.equals("y")){
            superhero.setIsHuman(true);
        }else if (newIsHuman.equals("n")) {
            superhero.setIsHuman(false);
        }

        ArrayList<Superhero> tempSuperhero = new ArrayList<>();
        tempSuperhero.addAll(superheroList());
        tempSuperhero.remove(input-1);
        tempSuperhero.add(input-1, superhero);

        PrintWriter output = null;
        PrintWriter clearFile = null;
        try {
            clearFile = new PrintWriter(new FileWriter(fh.getSuperheroDatabase(), false));
            clearFile.print("");
            clearFile.close();
            output = new PrintWriter(new FileWriter(fh.getSuperheroDatabase(), true));
            fh.saveSuperhero(tempSuperhero);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}






