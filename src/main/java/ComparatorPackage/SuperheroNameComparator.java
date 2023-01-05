package ComparatorPackage;

import Database.Superhero;

import java.util.Comparator;

public class SuperheroNameComparator implements Comparator<Superhero> {
    public int compare(Superhero ob1, Superhero ob2) {
        return ob1.getSuperheroName().toLowerCase().compareTo(ob2.getSuperheroName().toLowerCase());
    }
}
