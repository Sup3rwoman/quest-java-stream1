package quests;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Shield {

    public static void main(String[] args) {

        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("Black Widow", 34, false));
        heroes.add(new Hero("Captain America", 100, false));
        heroes.add(new Hero("Vision", 3, true));
        heroes.add(new Hero("Iron Man", 48, false));
        heroes.add(new Hero("Scarlet Witch", 29, true));
        heroes.add(new Hero("Thor", 1501, false));
        heroes.add(new Hero("Spider-Man", 18, false));
        heroes.add(new Hero("Hulk", 49, true));
        heroes.add(new Hero("Doctor Strange", 42, false));

        //filters heroes in order to found heroes older than 59
        //Use of a Stream in 3 stages:
        List<Hero> elders = heroes.stream()             //1. SOURCE: list of heroes
                .filter(item -> item.getAge() >= 60)    //2. INTERMEDIATE: filter - keep or not (expects Predicate as an argument)
                .collect(Collectors.toList());          //3. TERMINAL: collect - return result in form of a list
        //Predicate = functional interface, returns a value that is either true or false
        //can be used as assignment target for lambda expression or method reference

        System.out.println("\nElders:");
        for (Hero elder : elders) {
            System.out.println(elder.getName());
        }

        //filter heroes in order to found heroes that are gluten intolerants
        List<Hero> intolerants = heroes.stream()
                .filter(item -> item.isGlutenIntolerant())
                .collect(Collectors.toList());

        System.out.println("\nGluten intolerants:");
        for (Hero intolerant : intolerants) {
            System.out.println(intolerant.getName());
        }
    }
}
