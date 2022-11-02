package org.example;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Database {
    private File superheroDatabase = new File("C:\\Users\\mosen\\IdeaProjects\\superheroes\\SuperheroDatabase.txt");
    private Superhero superman = new Superhero("Clark Kent", "Superman", "Flyve, superstyrke, røntgensyn", 50000.0, 1920, true);
    private Superhero spiderman = new Superhero("Peter Parker", "Spiderman", "Superstyrke, webskydning, intelligens", 30000, 1940, true);
    private Superhero theMartian = new Superhero("Jonzz", "Martian Manhuter", "Shapeshifting, Telepati, 'Martian Vision'", 45000, 1950, false);
    private Superhero wolverine = new Superhero("James 'Logan' Howleet", "Wolverine", "Regeneration, adamantite skeleton", 432000, 1954, true);
    private ArrayList<Superhero> superheroes = new ArrayList<>(List.of(superman, spiderman, theMartian, wolverine));
    private ArrayList<Superhero> searchResult = new ArrayList<>();

    public Database()  throws FileNotFoundException{

    }



    public ArrayList<Superhero> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(ArrayList<Superhero> searchResult) {
        this.searchResult = searchResult;
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(ArrayList<Superhero> superheroes) {
        this.superheroes = superheroes;
    }


    public File getSuperheroDatabase() {
        return superheroDatabase;
    }

    public void setSuperheroDatabase(File superheroDatabase) {
        this.superheroDatabase = superheroDatabase;
    }
    }






