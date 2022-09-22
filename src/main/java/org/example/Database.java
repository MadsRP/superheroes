package org.example;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Database {

    Superhero superhero = new Superhero();
    Scanner scanner = new Scanner(System.in);

    Superhero superman = new Superhero("Clark Kent", "Superman", "Flyve, superstyrke, røntgensyn", 50000.0, 1920, true);
    Superhero spiderman = new Superhero("Peter Parker", "Spiderman", "Superstyrke, webskydning, intelligens", 30000, 1940, true);
    Superhero theMartian = new Superhero("Jonzz", "Martian Manhuter", "Shapeshifting, Telepati, 'Martian Vision'", 45000, 1950, false);
    Superhero wolverine = new Superhero("James 'Logan' Howleet", "Wolverine", "Regeneration, adamantite skeleton", 432000, 1954, true);

    ArrayList<Superhero> superheroes = new ArrayList<>(List.of(superman, spiderman, theMartian, wolverine));
    ArrayList<Superhero> searchResult = new ArrayList<>();

    public void createNewHero() {

        System.out.println("Hvad hedder din superhelt?");
        superhero.setName(scanner.next());
        System.out.println("Hvad er din superheltes helte navn?");
        superhero.setSuperheroName(scanner.next());
        System.out.println("Hvad er din superhelts kræfter?");
        superhero.setSuperPowers(scanner.next());
        System.out.println("Hvad er din superhelts styrke tal?");
        superhero.setStrength(scanner.nextDouble());
        System.out.println("Hvornår var din superhelt kreeret?");
        superhero.setCreationYear(scanner.nextInt());
        System.out.println("Er din superhelt menneske? y/n");
        if (scanner.next().equals("y")) {
            superhero.setIsHuman(true);
        } else {
            superhero.setIsHuman(false);
        }
        superheroes.add(superhero);

        System.out.println(superhero.getSuperheroName() + " oprettet.");

    }

    public void printDatabase() {
        for (Superhero superhero : superheroes) {
            System.out.println("Navn: " + superhero.getName() +
                    "\nSuperhelte Navn: " + superhero.getSuperheroName() +
                    "\nSuperkræfter: " + superhero.getSuperPowers() +
                    "\nStyrke: " + superhero.getStrength() +
                    "\nSkabelses År: " + superhero.getCreationYear() +
                    "\nEr menneske: " + superhero.getIsAHuman());
        }
    }

    public void searchSuperheroList() {
        System.out.println("Venligst indtast søgning ud fra supernavn: ");
        String searchSuperhero = scanner.nextLine();
        int i;

        for (Superhero superhero : superheroes) {
            if (superhero.getSuperheroName().toLowerCase(Locale.ROOT).contains(searchSuperhero.toLowerCase())) {
                searchResult.add(superhero);
            }
        }
        if (!searchResult.isEmpty()) {
            for (i = 0; i < searchResult.size(); i++) {
                System.out.println(i+1 + ": " + searchResult.get(i));
            }
        }else{
            System.out.println("Der findens ingen personer i listen med navn: " + searchSuperhero);
        }

        searchResult.clear();
    }




    public void editSuperHeroStats() {

        searchSuperheroList();

        System.out.println("Ud fra listen ovenfra, hvilken vil du redigere i?");
        int chooseSuperhero = scanner.nextInt();
        scanner.nextLine();

        Superhero editSuperhero = searchResult.get(chooseSuperhero-1);
        System.out.println("Du redigere nu i " + editSuperhero.getSuperheroName());

        System.out.println("Hvis du bare trykker enter, vil dataen ikke blevet redigeret.");
        System.out.println("Skriv de nye værdier for " + editSuperhero.getSuperheroName());

        System.out.println("Navn: " + editSuperhero.getName());
        System.out.println("Vil du ændre på " + editSuperhero.getName() + "'s navn");
        String newName = scanner.nextLine();
        if (!newName.isEmpty())
        {
            editSuperhero.setName(newName);
        }else {
            System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s navn.");
        }

        System.out.println("Superhelte navn: " + editSuperhero.getSuperheroName());
        System.out.println("Vil du ændre superhelte navnet?");

        String newSuperheroName = scanner.nextLine();
        if (!newName.isEmpty())
        {
            editSuperhero.setSuperheroName(newSuperheroName);
        }else {
            System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s super helte navn.");
        }

        System.out.println("Superkræfter: " + editSuperhero.getSuperPowers());
        System.out.println("Vil du ændre superkræter?");
        String newSuperPowers = scanner.nextLine();
        if (!newName.isEmpty())
        {
            editSuperhero.setSuperPowers(newSuperPowers);
        }else {
            System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s superkræfter.");
        }

        System.out.println("Styrke: " + editSuperhero.getStrength());
        System.out.println("Vil du ændre styrken?");
        String newStrength = scanner.nextLine();
        if (!newStrength.isEmpty()){
            editSuperhero.setStrength(Double.parseDouble(newStrength));
        }else {
            System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s superhelte styrke.");
        }

        System.out.println("Skabelses År: " + editSuperhero.getCreationYear());
        System.out.println("Vil du ændre årret " + editSuperhero.getSuperheroName() + " blew skabt i?");

        String newCreationYear = scanner.nextLine();
        if (!newCreationYear.isEmpty()){
            editSuperhero.setCreationYear(Integer.parseInt(newCreationYear));
        }else {
            System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s skabelses år.");
        }


        System.out.println("Vil du ændre om " + editSuperhero.getName() + " er menneskelig?");
        System.out.println("y/n");
        String newIsHuman = scanner.nextLine();
        if (!newIsHuman.isEmpty()){
            if (newIsHuman.equals("y"))
            {
                editSuperhero.setIsHuman(true);
            } else{
                editSuperhero.setIsHuman(false);
            }
        }else {
            System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s status som menneske");
        }

        System.out.println("Du har nu redigeret i: " + editSuperhero.getName());
        System.out.println("Nedenfor er de nye værdier:");
        System.out.println(editSuperhero.printSuperhero());

        searchResult.clear();


    }

    public void deleteSuperhero(){
        searchSuperheroList();

        System.out.println("Ud fra listen ovenfra, hvilken superhelt kunne du tænke dig at slette?");
        int deleteSuperhero = scanner.nextInt();
        scanner.nextLine();
        System.out.println(superheroes.get(deleteSuperhero-1).getSuperheroName() + " er nu slettet");
        superheroes.remove(deleteSuperhero-1);

    }

}


