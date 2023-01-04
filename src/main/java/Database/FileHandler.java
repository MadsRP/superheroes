package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileHandler {


    private ArrayList<Superhero> searchResult = new ArrayList<>();
    private File superheroDatabase = new File("C:\\Users\\mosen\\IdeaProjects\\superheroes2\\SuperheroDatabase.txt");

    public FileHandler() {

    }

    public ArrayList <Superhero> superheroList(){
        ArrayList<Superhero> superheroList = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(superheroDatabase);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {

            String linje = sc.nextLine();
            String[] attributter = linje.split(";");

            Superhero superhero = new Superhero(
                    attributter[0],
                    attributter[1],
                    attributter[2],
                    Double.parseDouble(attributter[3]),
                    Integer.parseInt(attributter[4]),
                    Boolean.parseBoolean(attributter[5]));
            superheroList.add(superhero);
        }
        sc.close();
        return superheroList;
    }

    public void saveSuperhero(ArrayList<Superhero> dataSaver) {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(superheroDatabase, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Superhero superhero : dataSaver) {
            pw.print(superhero.getName());
            pw.print(";");
            pw.print(superhero.getSuperheroName());
            pw.print(";");
            pw.print(superhero.getSuperPowers());
            pw.print(";");
            pw.print(superhero.getSuperStrengthNumber());
            pw.print(";");
            pw.print(superhero.getCreationYear());
            pw.print(";");
            pw.print(superhero.getHuman());
            pw.println();
        }
        pw.flush();
        pw.close();
    }

    public void printSuperheroList(){

    }

//    public void searchSuperheroList(Scanner userInput) {
//        searchResult.clear();
//        System.out.println("Venligst indtast søgning ud fra supernavn: ");
//        String searchSuperhero = userInput.nextLine();
//        int i;
//
//
//        for (Database.Superhero superhero : superheroList()) {
//            if (superhero.getSuperheroName().toLowerCase(Locale.ROOT).contains(searchSuperhero.toLowerCase())) {
//                superheroList().add(superhero);
//            }
//        }
//        if (!db.getSearchResult().isEmpty()) {
//            for (i = 0; i < db.getSearchResult().size(); i++) {
//                System.out.println(i + 1 + ": " + db.getSearchResult().get(i).getName() + ", " + db.getSearchResult().get(i).getSuperheroName() + ".");
//            }
//            System.out.println("\n");
//        } else {
//            System.out.println("Der findens ingen personer i listen med navn: " + searchSuperhero);
//        }
 //   }



    public File getSuperheroDatabase() {
        return superheroDatabase;
    }

    public void setSuperheroDatabase(File superheroDatabase) {
        this.superheroDatabase = superheroDatabase;
    }


}
