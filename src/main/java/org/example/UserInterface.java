package org.example;

import java.util.Scanner;

public class UserInterface {
    Database database = new Database();
    Scanner scanner = new Scanner(System.in);


    public void velkomst() {
        System.out.printf("Velkommen til din personlige database over superhelte\n" +
                "1. Opret ny superhelt.\n" +
                "2. Liste af superhelte.\n" +
                "3. Søg efter superhelte fra database ud fra superhelte navn\n" +
                "4. Rediger superhelt\n" +
                "5. Slet superhelt\n" +
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
                database.searchSuperheroList();}
            else if (menuChooser.equals("4")) {
                database.editSuperHeroStats();
            }else if (menuChooser.equals("5")) {
                    database.deleteSuperhero();
            } else if (menuChooser.equals("9")) {
                break;
            }
            System.out.println("Vælg venligst hvad du vil nu:\n" +
                    "1. Opret ny superhelt.\n" +
                    "2. Liste af superhelte.\n" +
                    "3. Søg efter superhelte fra database ud fra superhelte navn\n" +
                    "4. Rediger superhelt\n" +
                    "5. Slet superhelt\n" +
                    "9. Luk database");
        }
    }
}
