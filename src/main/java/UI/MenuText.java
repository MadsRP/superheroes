package UI;

public class MenuText {

    public void velkomst(){
        System.out.printf("Velkommen til Superhelte Database!");
    }

    public void menu(){
        System.out.println("Vælg venligst hvad du vil nu:\n" +
                "1. Opret ny superhelt.\n" +
                "2. Liste af superhelte.\n" +
                "3. Søg efter superhelte fra database ud fra superhelte navn\n" +
                "4. Rediger superhelt\n" +
                "5. Slet superhelt\n" +
                "6. Find specifik superhelt med fuld udskrift\n" +
                "7. Sorteret Liste Af Superhelte Efter Navn\n" +
                "9. Luk database");
    }
}
