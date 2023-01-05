package UI;

public class MenuText {

    public void velkomst(){
        System.out.printf("Velkommen til Superhelte Database!");
    }
    public void menu(){
        System.out.println("Vælg venligst hvad du vil nu:\n" +
                "1. Opret ny superhelt.\n" +
                "2. Liste af superhelte.\n" +
                "3. Rediger superhelt\n" +
                "4. Slet superhelt\n" +
                "5. Find specifik superhelt med fuld udskrift\n" +
                "6. Sortering Af Database\n" +
                "9. Luk database");
    }

    public void sortingMenuText(){
        System.out.println("Du kan nu vælge om du vil sortere mellem en eller to attributter.");
        System.out.println("1. En attribut");
        System.out.println("2. To attributter");
        System.out.println("9. Tilbage til hovedmenu");
    }
    public void sortingAttributeMenuText(){
        System.out.println("Vælg venligst hvad du vil sortere efter:\n" +
                "1. Navn.\n" +
                "2. Superheltenavn.\n" +
                "3. Kræfter.\n" +
                "4. Styrketal.\n" +
                "5. Skabelsesår.\n" +
                "6. Menneskelig eller ej.\n" +
                "9. Tilbage til hovedmenu.\n");
    }
}
