package org.example;

import java.util.Scanner;

public class UserInterface {
    Database database = new Database();
    Scanner scanner = new Scanner(System.in);


    public void velkomst() {
        System.out.printf("Velkommen til din personlige database over superhelte\n" +
                "1. Opret ny superhelt.\n" +
                "2. Liste af superhelte.\n" +
                "3. Søg efter specifik superhelt i database.\n" +
                "4. Søg efter flere superhelte samtidigt\n" +
                "5. Rediger superhelt\n" +
                "9. Luk database\n");
    }

    public void menu(){

        while (true) {
            String menuChooser = scanner.next();
            if (menuChooser.equals("1")) {
                database.createNewHero();
            } else if (menuChooser.equals("2")) {
                database.printDatabase();
            } else if (menuChooser.equals("3")) {
                database.searchSuperhero();
            } else if (menuChooser.equals("4")) {
                database.searchSuperheroList();}
            else if (menuChooser.equals("5")) {
                database.editSuperHeroStats();
            } else if (menuChooser.equals("9")) {
                break;
            }
            System.out.println("Vælg venligst hvad du vil nu:\n" +
                    "1. Opret ny superhelt.\n" +
                    "2. Liste af superhelte.\n" +
                    "3. Søg efter superhelt fra database.\n" +
                    "4. Søg efter flere superhelte samtidigt\n" +
                    "5. Rediger superhelt\n" +
                    "9. Luk database");
        }
    }
}
