package UI;

import Database.Controller;
import Database.Superhero;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);
    private MenuText menuText = new MenuText();

    private int input = 0;


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
        while (true ) {
            menuText.menu();
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
                        case 3:
                            editSuperHeroStats(scanner);
                            break;
                        case 4:
                            deleteSuperhero();
                            break;
                        case 5:
                            searchSpecificHero();
                            break;
                        case 6:
                            sortingUIIntro();
                            break;
                        case 7:
                            searchHeroByName();
                            break;
                        case 9:
                            System.out.println("Lukker database.");
                            System.exit(0);
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
        superheroPrint(superhero);
    }

    static void superheroPrint(Superhero superhero) {
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

    public void searchHeroByName(){
        Superhero superhero = new Superhero();
        superhero = controller.searchHeroByName();
        if (superhero == null){
            System.out.println("Der findes ingen med det navn i databasen");
        } else {
            printHero(superhero);
        }
    }

    public void printSuperheroList() {
        for (Superhero superhero : superheroList()) {
            printHero(superhero);
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

    //SORTING
    public void sortingUIIntro(){
        menuText.sortingMenuText();
        input = scanner.nextInt();
        switch (input){
            case 1:
                sortingUISingleAttribute();
                break;
            case 2:
                sortingUITwoAttributes();
                break;
            case 9:
                menu();
        }
    }

    public void sortingUISingleAttribute(){
        menuText.sortingAttributeMenuText();
        try {
            String menuChooser = scanner.next();
            int menuChooserInt = scanner.nextInt();

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

    public void sortingUITwoAttributes(){
        int input1 = 0;
        int input2 = 0;
        boolean keepRunning = true;
        do {
            System.out.println("Vælg venligst hvilke attributer du først vil sortere efter ved hjælp af tallene nedenfor:");
            System.out.println("Skriv 9 for at komme tilbage til hovedmenu");
            menuText.sortingAttributeMenuText();
            input1 = scanner.nextInt();
            if (input1 ==9){
                break;
            }
            input2 = scanner.nextInt();
            if (input2 ==9){
                break;
            }
            sortByNameSwitch(input1, input2);
            sortBySuperNameSwitch(input1, input2);
            sortByPowersSwitch(input1, input2);
            sortByStrengthSwitch(input1, input2);
            sortByCreationYearSwitch(input1, input2);
            sortByHumanSwitch(input1, input2);
        } while (keepRunning);
        mainMenu();
    }
    //SINGLE SORTS
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

    //SORT BY TWO ATTRIBUTES
    //NAME
    public void sortByNameSwitch(int input1, int input2){
        switch (input1 + "|" +  input2) {
            case 1 + " |" +  1:
                System.out.println("Venligst indtast to forskellige tal.");
                sortingUITwoAttributes();
                break;
            case 1 + "|" + 2:
                sortNameSuperHeroName();
                break;
            case 1 + "|" + 3:
                sortNamePowers();
                break;
            case 1 + "|" + 4:
                sortNameStrength();
                break;
            case 1 + "|" + 5:
                sortNameCreationYear();
                break;
            case 1 + "|" + 6:
                sortNameHuman();
                break;
        }
    }
    public void sortNameSuperHeroName(){
        for (Superhero superhero : controller.sortByNameThenSuperHeroName()) {
            printHero(superhero);
        }
    }
    public void sortNamePowers(){
        for (Superhero superhero : controller.sortByNameThenSuperPowers()) {
            printHero(superhero);
        }
    }
    public void sortNameStrength(){
        for (Superhero superhero : controller.sortByNameThenStrength()) {
            printHero(superhero);
        }
    }
    public void sortNameCreationYear(){
        for (Superhero superhero : controller.sortByNameThenCreationYear()) {
            printHero(superhero);
        }
    }
    public void sortNameHuman(){
        for (Superhero superhero : controller.sortByNameThenHuman()) {
            printHero(superhero);
        }
    }
    //SUPERHERONAME
    public void sortBySuperNameSwitch(int input1, int input2){
        switch (input1 + "|" + input2) {
            case 2 + "|" + 2:
                System.out.println("Venligst indtast to forskellige tal.");
                sortingUITwoAttributes();
                break;
            case 2 + "|" + 1:
                sortSuperHeroNameName();
                break;
            case 2 + "|" + 3:
                sortSuperHeroNamePowers();
                break;
            case 2 + "|" + 4:
                sortSuperHeroNameStrength();
                break;
            case 2 + "|" + 5:
                sortSuperHeroNameCreationYear();
                break;
            case 2 + "|" + 6:
                sortSuperHeroNameHuman();
                break;
        }

    }
    public void sortSuperHeroNameName(){
        for (Superhero superhero : controller.sortBySuperHeroNameThenName()) {
            printHero(superhero);
        }
    }
    public void sortSuperHeroNamePowers(){
        for (Superhero superhero : controller.sortBySuperHeroNameThenSuperPowers()) {
            printHero(superhero);
        }
    }
    public void sortSuperHeroNameStrength(){
        for (Superhero superhero : controller.sortBySuperHeroNameThenStrength()) {
            printHero(superhero);
        }
    }
    public void sortSuperHeroNameCreationYear(){
        for (Superhero superhero : controller.sortBySuperHeroNameThenCreationYear()) {
            printHero(superhero);
        }
    }
    public void sortSuperHeroNameHuman(){
        for (Superhero superhero : controller.sortBySuperHeroNameThenHuman()) {
            printHero(superhero);
        }
    }

    //POWERS
    public void sortByPowersSwitch(int input1, int input2){
        switch (input1 + "|" + input2) {
            case 3 + "|" + 3:
                System.out.println("Venligst indtast to forskellige tal.");
                sortingUITwoAttributes();
                break;
            case 3 + "|" + 1:
                sortPowersName();
                break;
            case 3 + "|" + 2:
                sortPowersSuperHeroName();
                break;
            case 3 + "|" + 4:
                sortPowersStrength();
                break;
            case 3 + "|" + 5:
                sortPowersYear();
                break;
            case 3 + "|" + 6:
                sortPowersHuman();
                break;
        }
    }
    public void sortPowersName(){
        for (Superhero superhero : controller.sortBySuperPowerThenName()) {
            printHero(superhero);
        }
    }
    public void sortPowersSuperHeroName(){
        for (Superhero superhero : controller.sortBySuperPowerThenSuperHeroName()) {
            printHero(superhero);
        }
    }
    public void sortPowersStrength(){
        for (Superhero superhero : controller.sortBySuperPowerThenStrength()) {
            printHero(superhero);
        }
    }
    public void sortPowersYear(){
        for (Superhero superhero : controller.sortBySuperPowerThenCreationYear()) {
            printHero(superhero);
        }
    }
    public void sortPowersHuman(){
        for (Superhero superhero : controller.sortBySuperPowerThenHuman()) {
            printHero(superhero);
        }
    }
    //STRENGTH
    public void sortByStrengthSwitch(int input1, int input2){
        switch (input1 + "|" + input2) {
            case 4 + "|" + 4:
                System.out.println("Venligst indtast to forskellige tal.");
                sortingUITwoAttributes();
                break;
            case 4 + "|" + 1:
                sortStrengthName();
                break;
            case 4 + "|" + 2:
                sortStrengthSuperHeroName();
                break;
            case 4 + "|" + 3:
                sortStrengthPowers();
                break;
            case 4 + "|" + 5:
                sortStrengthCreationYear();
                break;
            case 4 + "|" + 6:
                sortStrengthHuman();
                break;
        }

    }
    public void sortStrengthName(){
        for (Superhero superhero : controller.sortByStrengthThenName()) {
            printHero(superhero);
        }
    }
    public void sortStrengthSuperHeroName(){
        for (Superhero superhero : controller.sortByStrengthThenSuperHeroName()) {
            printHero(superhero);
        }
    }
    public void sortStrengthPowers(){
        for (Superhero superhero : controller.sortByStrengthThenPowers()) {
            printHero(superhero);
        }
    }
    public void sortStrengthCreationYear(){
        for (Superhero superhero : controller.sortByStrengthThenCreationYear()) {
            printHero(superhero);
        }
    }
    public void sortStrengthHuman(){
        for (Superhero superhero : controller.sortByStrengthThenHuman()) {
            printHero(superhero);
        }
    }

    //CREATIONYEAR
    public void sortByCreationYearSwitch(int input1, int input2){
        switch (input1 + "|" + input2) {
            case 5 + "|" + 5:
                System.out.println("Venligst indtast to forskellige tal.");
                sortingUITwoAttributes();
                break;
            case 5 + "|" + 1:
                sortYearName();
                break;
            case 5 + "|" + 2:
                sortYearSuperHeroName();
                break;
            case 5 + "|" + 3:
                sortYearPowers();
                break;
            case 5 + "|" + 4:
                sortYearStrength();
                break;
            case 5 + "|" + 6:
                sortYearHuman();
                break;
        }

    }
    public void sortYearName(){
        for (Superhero superhero : controller.sortByCreationYearThenName()) {
            printHero(superhero);
        }
    }
    public void sortYearSuperHeroName(){
        for (Superhero superhero : controller.sortByCreationYearThenSuperHeroName()) {
            printHero(superhero);
        }
    }
    public void sortYearPowers(){
        for (Superhero superhero : controller.sortByCreationYearThenPowers()) {
            printHero(superhero);
        }
    }
    public void sortYearStrength(){
        for (Superhero superhero : controller.sortByCreationYearThenStrength()) {
            printHero(superhero);
        }
    }
    public void sortYearHuman(){
        for (Superhero superhero : controller.sortByCreationYearThenHuman()) {
            printHero(superhero);
        }
    }
    //HUMAN
    public void sortByHumanSwitch(int input1, int input2){
        switch (input1 + "|" + input2) {
            case 6 + "|" + 6:
                System.out.println("Venligst indtast to forskellige tal.");
                sortingUITwoAttributes();
                break;
            case 6 + "|" + 1:
                sortHumanName();
                break;
            case 6 + "|" + 2:
                sortHumanSuperHeroName();
                break;
            case 6 + "|" + 3:
                sortHumanPowers();
                break;
            case 6 + "|" + 4:
                sortHumanStrength();
                break;
            case 6 + "|" + 5:
                sortHumanCreationYear();
                break;
        }

    }
    public void sortHumanName(){
        for (Superhero superhero : controller.sortByHumanThenName()) {
            printHero(superhero);
        }
    }
    public void sortHumanSuperHeroName(){
        for (Superhero superhero : controller.sortByHumanThenSuperHeroName()) {
            printHero(superhero);
        }
    }
    public void sortHumanPowers(){
        for (Superhero superhero : controller.sortByHumanThenPowers()) {
            printHero(superhero);
        }
    }
    public void sortHumanStrength(){
        for (Superhero superhero : controller.sortByHumanThenStrength()) {
            printHero(superhero);
        }
    }
    public void sortHumanCreationYear(){
        for (Superhero superhero : controller.sortByHumanThenCreationYear()) {
            printHero(superhero);
        }
    }


}
