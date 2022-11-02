package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);


    public UserInterface() throws IOException {
    }


    public void velkomst() throws IOException {
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

                if (menuChooser.isEmpty())
                {
                    System.out.println("Venligst indtast et tal fra listen");
                } else{
                    switch (menuChooserInt) {
                        case 1:
                            controller.createNewHero();
                            break;
                        case 2:
                            controller.printDatabase();
                            break;
                        case 3:
                            controller.searchSuperheroList();
                            break;
                        case 4:
                            controller.editSuperHeroStats();
                            break;
                        case 5:
                            controller.deleteSuperhero();
                            break;
                        case 6:
                            controller.searchSpecificHero();
                            break;
                        case 9:
                            break;
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("Venligst indtast et nummer fra listen.");
            } catch (IOException e) {
                throw new RuntimeException(e);
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
