package ComparatorPackage;

import Database.Superhero;

import java.util.Comparator;

public class StrengthComparator implements Comparator<Superhero> {

    public int compare(Superhero ob1, Superhero ob2)
    {
        if (ob1.getSuperStrengthNumber() < ob2.getSuperStrengthNumber() )
            return -1;
        else if (ob1.getSuperStrengthNumber() > ob2.getSuperStrengthNumber())
            return 1;
        else
            return 0;
    }
}
