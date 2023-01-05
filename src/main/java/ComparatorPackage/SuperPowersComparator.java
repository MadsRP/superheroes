package ComparatorPackage;

import Database.Superhero;

import java.util.Comparator;

public class SuperPowersComparator implements Comparator<Superhero> {
    public int compare(Superhero ob1, Superhero ob2) {
        return ob1.getSuperPowers().toLowerCase().compareTo(ob2.getSuperPowers().toLowerCase());
    }
}
