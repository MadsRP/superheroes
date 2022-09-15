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

        System.out.println(superhero);

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

    public void searchSuperhero() {
        System.out.println("Venligst indtast søgning ud fra supernavn: ");
        String searchSuperhero = scanner.next();
        boolean couldntFind = false;


        if (searchSuperhero.isEmpty()) {
            System.out.println("Indtast venligt noget.");
        }

        for (Superhero superhero : superheroes) {
            if (superhero.getSuperheroName().toLowerCase(Locale.ROOT).contains(searchSuperhero.toLowerCase())) {
                if (superheroes.size() > 1) {
                    superheroes.remove(superheroes.size() - 1);
                    System.out.println(superhero.printSuperhero());
                } else if (superheroes.size() == 1) {
                    System.out.println(superhero.printSuperhero());
                } else {
                    couldntFind = true;
                }
                if (couldntFind == true) {
                    System.out.println("Kunne ikke finde superhelt med dette navn.");
                    break;
                }
            }
        }

    }
}
