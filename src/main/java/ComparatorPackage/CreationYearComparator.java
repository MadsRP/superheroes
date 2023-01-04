package ComparatorPackage;

import Database.Superhero;

import java.util.Comparator;

public class CreationYearComparator implements Comparator<Superhero> {

    public int compare(Superhero ob1, Superhero ob2)
    {
        if (ob1.getCreationYear() < ob2.getCreationYear() )
            return -1;
        else if (ob1.getCreationYear() > ob2.getCreationYear())
            return 1;
        else
            return 0;
    }
}
