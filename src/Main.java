import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SpellChecker test = new SpellChecker("/Users/adilmustafayilmaz/IdeaProjects/Homework2/src/words.txt");
        test.checkInDictionary("ehllo jjohn orld");

        System.out.println("Adding Charracters Advice List: ");
        System.out.println();
        for (String s : test.getAdviceListAddingChar()){
            System.out.println("--> "+s);
        }
        System.out.println("Removing Charracters Advice List");
        System.out.println();
        for (String s: test.getAdviceListRemovingChar()){
            System.out.println("--> "+s);
        }
        System.out.println("Swapping Characters  Advice List");
        System.out.println();
        for (String s: test.getAdviceListSwappingTwoChar()){
            System.out.println("--> "+s);
        }
    }
}
