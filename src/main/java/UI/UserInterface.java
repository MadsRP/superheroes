package UI;

import Database.Controller;
import Database.Superhero;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);
    private MenuText menuText = new MenuText();


    public UserInterface() throws IOException {
    }

    //MENUS
    public void velkomst() {
        menuText.velkomst();
    }
    public void menu() {
        mainMenu();
    }

    public void mainMenu() {
        menuText.menu();
        while (true) {
            try {
                String menuChooser = scanner.next();
                int menuChooserInt = Integer.parseInt(menuChooser);

                if (menuChooser.isEmpty()) {
                    System.out.println("Venligst indtast et tal fra listen");
                } else {
                    switch (menuChooserInt) {
                        case 1:
                            createNewHero();
                            break;
                        case 2:
                            printSuperheroList();
                            break;
                        case 4:
                            editSuperHeroStats(scanner);
                            break;
                        case 5:
                            deleteSuperhero();
                            break;
                        case 6:
                            searchSpecificHero();
                            break;
                        case 7:
                            sortBySingleCriteria();
                            break;
                        case 9:
                            break;
                        default:
                            mainMenu();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Venligst indtast et nummer fra listen.");
            }
        }
    }
    //PRINT HERO
    public void printHero(Superhero superhero) {
        System.out.print(superhero.getName());
        System.out.print(", " + superhero.getSuperheroName());
        System.out.print(", " + superhero.getSuperPowers());
        System.out.print(", " + superhero.getSuperStrengthNumber());
        System.out.print(", " + superhero.getCreationYear());
        System.out.print(", " + superhero.getHuman());
        System.out.println();
    }
    // CRUD
    public void createNewHero() {
        Scanner userInput = new Scanner(System.in);

        String name = "";
        String superHeroName = "";
        String superPowers = "";
        double superStrengthNumber = 0;
        int creationYear = 0;
        boolean isHuman = true;

        System.out.println("Hvad hedder din superhelt?");
        name = userInput.next();
        System.out.println("Hvad er din superheltes helte navn?");
        superHeroName = userInput.next();
        System.out.println("Hvad er din superhelts kræfter?");
        superPowers = userInput.next();
        System.out.println("Hvad er din superhelts styrke tal?");
        superStrengthNumber = userInput.nextDouble();
        System.out.println("Hvornår var din superhelt kreeret?");
        creationYear = userInput.nextInt();
        System.out.println("Er din superhelt menneske? y/n");
        if (userInput.next().equals("y")) {
            isHuman = true;
        } else {
            isHuman = false;
        }
        Superhero superhero = controller.newSuperhero(name, superHeroName, superPowers, superStrengthNumber, creationYear, isHuman);
        System.out.println(name + " oprettet.");
        controller.saveSuperhero();
    }

    public ArrayList<Superhero> superheroList() {
        return controller.superheroList();
    }

    public void printSuperheroList() {
        for (Superhero superhero : superheroList()) {
            System.out.println(superhero.getName());
        }
    }
    public void editSuperHeroStats(Scanner userInput) {
        for (int i = 0; i < superheroList().size(); i++) {
            System.out.println(i + 1 + ") Name: " + superheroList().get(i).getName() + ", Superhero name: " + superheroList().get(i).getSuperheroName());
        }
        System.out.println("Ud fra listen ovenfra, hvilken vil du redigere i?");

        int input = userInput.nextInt();
        Superhero editSuperhero = controller.superheroList().get(input - 1);


        try {

            if (input > superheroList().size()) {
                System.out.println("Venligst indtast et tal fra listen.");
            } else {

                System.out.println("Du redigere nu i " + editSuperhero.getSuperheroName());

                System.out.println("Hvis du bare trykker enter, vil dataen ikke blevet redigeret.");
                System.out.println("Skriv de nye værdier for " + editSuperhero.getSuperheroName());

                System.out.println("Navn: " + editSuperhero.getName());
                System.out.println("Vil du ændre på " + editSuperhero.getName() + "'s navn");
                String newName = userInput.nextLine();
                if (!newName.isEmpty()) {
                    editSuperhero.setName(newName);
                } else {
                    System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s navn.");
                }

                System.out.println("Superhelte navn: " + editSuperhero.getSuperheroName());
                System.out.println("Vil du ændre superhelte navnet?");

                String newSuperheroName = userInput.nextLine();
                if (!newName.isEmpty()) {
                    editSuperhero.setSuperheroName(newSuperheroName);
                } else {
                    System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s super helte navn.");
                }

                System.out.println("Superkræfter: " + editSuperhero.getSuperPowers());
                System.out.println("Vil du ændre superkræter?");
                String newSuperPowers = userInput.nextLine();
                if (!newName.isEmpty()) {
                    editSuperhero.setSuperPowers(newSuperPowers);
                } else {
                    System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s superkræfter.");
                }

                System.out.println("Styrke: " + editSuperhero.getSuperStrengthNumber());
                System.out.println("Vil du ændre styrken?");
                String newStrength = userInput.nextLine();
                if (!newStrength.isEmpty()) {
                    editSuperhero.setSuperStrengthNumber(Double.parseDouble(newStrength));
                } else {
                    System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s superhelte styrke.");
                }

                System.out.println("Skabelses År: " + editSuperhero.getCreationYear());
                System.out.println("Vil du ændre årret " + editSuperhero.getSuperheroName() + " blew skabt i?");

                String newCreationYear = userInput.nextLine();
                if (!newCreationYear.isEmpty()) {
                    editSuperhero.setCreationYear(Integer.parseInt(newCreationYear));
                } else {
                    System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s skabelses år.");
                }


                System.out.println("Vil du ændre om " + editSuperhero.getName() + " er menneskelig?");
                System.out.println("y/n");
                String newIsHuman = userInput.nextLine();
                if (!newIsHuman.isEmpty()) {
                    if (newIsHuman.equals("y")) {
                        editSuperhero.setIsHuman(true);
                    } else {
                        editSuperhero.setIsHuman(false);
                    }
                } else {
                    System.out.println("Ingen ændringer i " + editSuperhero.getName() + "'s status som menneske");
                }

                System.out.println("Du har nu redigeret i: " + editSuperhero.getName());
                System.out.println("Nedenfor er de nye værdier:");
                printHero(editSuperhero);
                controller.editSuperhero(input, newName, newSuperheroName, newSuperPowers, newStrength, newCreationYear, newIsHuman);


            }

        } catch (NumberFormatException e) {
            System.out.println("Venligst indtast et tal fra listen");
        }
    }
    public void deleteSuperhero() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < superheroList().size(); i++) {
            System.out.println(i + 1 + ") " + superheroList().get(i).getName() + ", " + superheroList().get(i).getSuperheroName());
        }
        System.out.println("Please input the number of which superhero you would like to delete:");
        int nr = input.nextInt();
        input.nextLine();
        System.out.println("Database.Superhero: " + superheroList().get(nr).getSuperheroName() + " has been deleted.");
        controller.sletMedlem(nr);
    }
    public void searchSpecificHero() {
        controller.searchSpecificHero();
    }

    // SORTING

    private void sortBySingleCriteria() {
        System.out.println("Vælg venligst hvad du vil sortere efter:\n" +
                "1. Navn.\n" +
                "2. Superheltenavn.\n" +
                "3. Kræfter.\n" +
                "4. Styrketal.\n" +
                "5. Skabelsesår.\n" +
                "6. Menneskelig eller ej.\n" +
                "9. Tilbage til hovedmenu.\n");
        try {
            String menuChooser = scanner.next();
            int menuChooserInt = Integer.parseInt(menuChooser);

            if (menuChooser.isEmpty()) {
                System.out.println("Venligst indtast et tal fra listen");
            } else {
                switch (menuChooserInt) {
                    case 1:
                        sortByName();
                        break;
                    case 2:
                        sortBySuperheroName();
                        break;
                    case 3:
                        sortByPowers();
                        break;
                    case 4:
                        sortByStrengthLevel();
                        break;
                    case 5:
                        sortByCreationYear();
                        break;
                    case 6:
                        sortByIsHuman();
                        break;
                    case 9:
                        menu();
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Venligst indtast et nummer fra listen.");
        }
    }

    //SORTING
    public void sortByName() {

        for (Superhero superhero : controller.sortByName()) {
            printHero(superhero);

        }
    }

    public void sortBySuperheroName() {

        for (Superhero superhero : controller.sortBySuperheroName()) {
            printHero(superhero);
        }
    }

    public void sortByPowers() {

        for (Superhero superhero : controller.sortByPowers()) {
            printHero(superhero);
        }
    }

    public void sortByStrengthLevel() {

        for (Superhero superhero : controller.sortByStrengthLevel()) {
            printHero(superhero);
            ;
        }
    }

    public void sortByCreationYear() {

        for (Superhero superhero : controller.sortByCreationYear()) {
            printHero(superhero);
        }
    }

    public void sortByIsHuman() {
        for (Superhero superhero : controller.sortByHuman()) {
            printHero(superhero);
        }
    }




}
