package org.example;

import java.util.Scanner;

public class UserInterface {
    Database database = new Database();
    Scanner scanner = new Scanner(System.in);


    public void startProgram(){
        System.out.printf("Velkommen til din personlige database over superhelte\n" +
                "1. Opret ny superhelt.\n" +
                "2. Liste af superhelte.\n" +
                "3. Søg efter superhelte i database.\n" +
                "9. Luk database\n");

        while (true) {
            String menuChooser = scanner.next();
            if (menuChooser.equals("1")) {
                database.createNewHero();
            } else if (menuChooser.equals("2")) {
                database.printDatabase();
            } else if (menuChooser.equals("3")) {
                database.searchSuperhero();
            } else if (menuChooser.equals("9")) {
                break;
            }
            System.out.println("Vælg venligst hvad du vil nu:\n" +
                    "1. Opret ny superhelt.\n" +
                    "2. Liste af superhelte.\n" +
                    "3. Søg efter superhelt fra database.\n" +
                    "9. Luk database\n");
        }
    }
}
