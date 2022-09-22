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
                "6. Find specifik superhelt med fuld udskrift\n" +
                "9. Luk database\n");
    }

    public void menu(){



        while (true) {
            try {
                String menuChooser = scanner.next();
                int menuChooserInt = Integer.parseInt(menuChooser);
                if (menuChooserInt == 1) {
                    database.createNewHero();
                } else if (menuChooserInt == 2) {
                    database.printDatabase();
                } else if (menuChooserInt == 3) {
                    database.searchSuperheroList();
                } else if (menuChooserInt == 4) {
                    database.editSuperHeroStats();
                } else if (menuChooserInt == 5) {
                    database.deleteSuperhero();
                } else if (menuChooserInt == 6) {
                    database.searchSpecificHero();
                } else if (menuChooserInt == 9) {
                    break;
                } else if (menuChooser.isEmpty()) ;
                {
                    System.out.println("Venligst indtast et tal fra listen");
                }
            } catch (NumberFormatException e){
                System.out.println("Venligst indtast et nummer fra listen.");
            }
            System.out.println("Vælg venligst hvad du vil nu:\n" +
                    "1. Opret ny superhelt.\n" +
                    "2. Liste af superhelte.\n" +
                    "3. Søg efter superhelte fra database ud fra superhelte navn\n" +
                    "4. Rediger superhelt\n" +
                    "5. Slet superhelt\n" +
                    "6. Find specifik superhelt med fuld udskrift\n" +
                    "9. Luk database");
        }

    }
}
