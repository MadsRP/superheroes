package org.example;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

    private Scanner userInput = new Scanner(System.in);
    private Superhero superhero = new Superhero();
    private Database db = new Database();
    private FileWriter fw = new FileWriter(db.getSuperheroDatabase(), true);
    private BufferedWriter bw = new BufferedWriter(fw);
    private PrintWriter pw = new PrintWriter(bw);

    private BufferedReader bufferedReader = new BufferedReader(new FileReader(db.getSuperheroDatabase()));

    public Controller() throws IOException {
    }

    public void createNewHero() throws IOException {
        String name = "";
        String superHeroName = "";
        String superPowers = "";
        double power = 0;
        int creationYear = 0;
        boolean isHuman = true;

    try (PrintWriter pw = new PrintWriter(new FileWriter(db.getSuperheroDatabase(), true))){
        System.out.println("Hvad hedder din superhelt?");
        name = userInput.next();
        System.out.println("Hvad er din superheltes helte navn?");
        superHeroName = userInput.next();
        System.out.println("Hvad er din superhelts kræfter?");
        superPowers = userInput.next();
        System.out.println("Hvad er din superhelts styrke tal?");
        power = userInput.nextDouble();
        System.out.println("Hvornår var din superhelt kreeret?");
        creationYear = userInput.nextInt();
        System.out.println("Er din superhelt menneske? y/n");
        if (userInput.next().equals("y")) {
            isHuman = true;
        } else {
            isHuman = false;
        }
        pw.println("\n"+name + "," + superHeroName + "," + superPowers + "," + power + "," + creationYear + "," + isHuman);
        pw.flush();
        pw.close();
        db.getSuperheroes().add(superhero);
        System.out.println(name + " oprettet.");
    }
    catch (IOException e){
        System.out.println("woops");
    }

    }

    public void printDatabase() throws IOException {
        String line = "";
        String output = "";
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(db.getSuperheroDatabase()))) {
            while ((line = bufferedReader.readLine()) != null) {
                if( line.trim().isEmpty() ) {
                    continue;
                }
                String[] data = line.split(",");
                contentBuilder.append(line).append("\n");
            }
            output = contentBuilder.toString();
            System.out.println(output);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void searchSuperheroList() {
        db.getSearchResult().clear();
        System.out.println("Venligst indtast søgning ud fra supernavn: ");
        String searchSuperhero = userInput.nextLine();
        int i;


        for (Superhero superhero : db.getSuperheroes()) {
            if (superhero.getSuperheroName().toLowerCase(Locale.ROOT).contains(searchSuperhero.toLowerCase())) {
                db.getSearchResult().add(superhero);
            }
        }
        if (!db.getSearchResult().isEmpty()) {
            for (i = 0; i < db.getSearchResult().size(); i++) {
                System.out.println(i+1 + ": " + db.getSearchResult().get(i).getName() + ", " + db.getSearchResult().get(i).getSuperheroName() + ".");
            }
            System.out.println("\n");
        }else{
            System.out.println("Der findens ingen personer i listen med navn: " + searchSuperhero);
        }

    }

    public void searchSpecificHero(){
        db.getSearchResult().clear();
        searchSuperheroList();
        System.out.println("Hvilken superhelt kunne du tænke dig at se?");
        String input = userInput.nextLine();
        int findSuperhero = Integer.parseInt(input) - 1;

        try {
            if (findSuperhero > db.getSearchResult().size()) {
                System.out.println("Venligst indtast et tal fra listen.");
            } else {
                System.out.println(db.getSearchResult().get(findSuperhero).printSuperhero());
            }
        } catch (NumberFormatException e){
            System.out.println("Venligst indtast et nummer.");
        }

    }

    public void editSuperHeroStats() {
        db.getSearchResult().clear();
        searchSuperheroList();
        int chooseSuperhero;

        System.out.println("Ud fra listen ovenfra, hvilken vil du redigere i?");

        String input = userInput.nextLine();
        chooseSuperhero = Integer.parseInt(input) - 1;
        Superhero editSuperhero = db.getSearchResult().get(chooseSuperhero);


        try {

            if (chooseSuperhero > db.getSearchResult().size()) {
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

                System.out.println("Styrke: " + editSuperhero.getStrength());
                System.out.println("Vil du ændre styrken?");
                String newStrength = userInput.nextLine();
                if (!newStrength.isEmpty()) {
                    editSuperhero.setStrength(Double.parseDouble(newStrength));
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
                System.out.println(editSuperhero.printSuperhero());


            }

        }catch(NumberFormatException e){
            System.out.println("Venligst indtast et tal fra listen");
        }
    }
    public void deleteSuperhero() {
        db.getSearchResult().clear();
        searchSuperheroList();

        System.out.println(db.getSearchResult().size());
        System.out.println("Ud fra listen ovenfra, hvilken superhelt kunne du tænke dig at slette?");

        String input = userInput.nextLine();
        int deleteSuperhero = Integer.parseInt(input) - 1;

        try {
            if (deleteSuperhero > db.getSearchResult().size()) {
                System.out.println("Venligst indtast et tal fra listen.");
            } else {
                System.out.println(db.getSearchResult().get(deleteSuperhero).getSuperheroName() + " er nu slettet");
                db.getSearchResult().remove(deleteSuperhero - 1);

            }
        } catch (NumberFormatException e) {
            System.out.println("Venligst indtast et nummer.");
        }

    }



}
