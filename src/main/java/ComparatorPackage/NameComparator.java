package ComparatorPackage;

import Database.Superhero;

import java.util.Comparator;

public class NameComparator implements Comparator<Superhero> {

    public int compare(Superhero ob1, Superhero ob2) {
        return ob1.getName().toLowerCase().compareTo(ob2.getName().toLowerCase());
    }
}