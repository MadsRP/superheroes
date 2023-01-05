package ComparatorPackage;

import Database.Superhero;

import java.util.Comparator;

public class HumanComparator implements Comparator<Superhero> {
    public int compare(Superhero ob1, Superhero ob2) {
        return Boolean.compare(ob1.getHuman(), ob2.getHuman());
    }

}
