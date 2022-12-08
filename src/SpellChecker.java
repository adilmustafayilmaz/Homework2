
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellChecker {

    private static final TreeSet<String> DICTIONARY = new TreeSet<>();

    private static final Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                                                'o','p','q','r','s','t','u','v','w','x','y','z'};

    private static TreeSet<String> ADVICE_LIST_ADDING_CHAR = new TreeSet<>();

    private static TreeMap<String,String[]> ADVICE_LIST_ADDING_CHAR_MAP = new TreeMap();

    public static TreeSet<String> ADVICE_LIST_REMOVING_CHAR = new TreeSet<>();


    public static TreeMap<String,String[]> ADVICE_LIST_REMOVING_CHAR_MAP = new TreeMap<>();
    public static TreeSet<String> ADVICE_LIST_SWAPPING_TWO_CHAR = new TreeSet<>();

    public static TreeSet<String> getAdviceListAddingChar() {
        return ADVICE_LIST_ADDING_CHAR;
    }

    public static TreeSet<String> getAdviceListRemovingChar() {
        return ADVICE_LIST_REMOVING_CHAR;
    }

    public static TreeSet<String> getAdviceListSwappingTwoChar() {
        return ADVICE_LIST_SWAPPING_TWO_CHAR;
    }

    public SpellChecker(String fileName) throws FileNotFoundException {
        //Scanning the dictionary
        Scanner fileScan = new Scanner(new File(fileName));


        //Adding all the words in the TreeSet Dictionary.
        while (fileScan.hasNext()){
            DICTIONARY.add(fileScan.next());
        }
    }

    public void checkInDictionary(String sentence){
        String lowerCaseSentence = sentence.toLowerCase();
        lowerCaseSentence = lowerCaseSentence.replaceAll("[^a-zA-Z0-9]", " ");
        String[] arr = lowerCaseSentence.split(" ");
        addingCharacters(arr);
        removingCharacters(arr);
        swappingCharacters(arr);
    }

    private void addingCharacters(String[] arr){
        for (int i = 0;i<arr.length;i++){

            for (int j = 0;j<=arr[i].length();j++){

                for (int k = 0;k<alphabet.length;k++){

                    StringBuilder str = new StringBuilder(arr[i]);
                    String str2 = String.valueOf(str.insert(j,alphabet[k]));
                    if (DICTIONARY.contains(str2)){
                        ADVICE_LIST_ADDING_CHAR.add(str2);
                    }
                }
            }
        }

    }

    private void removingCharacters(String[] arr){
        for (int i = 0;i<arr.length;i++){

            for (int j = 0;j<=arr[i].length();j++){

                StringBuilder str = new StringBuilder(arr[i]);

                str.replace(j,j+1,"");

                String str2 = String.valueOf(str);

                if (DICTIONARY.contains(str2)){
                    ADVICE_LIST_REMOVING_CHAR.add(str2);
                }
            }
        }
    }




    private void swappingCharacters(String[] arr){

        for (int i = 0;i<arr.length;i++){

            for (int j = 0;j<arr[i].length();j++){

                for (int k = 1; k<arr[i].length();k++){


                    char ch[] = arr[i].toCharArray();
                    char temp = ch[j];
                    ch[j] = ch[k];
                    ch[k] = temp;

                    String s = "";
                    for (int m = 0;m<ch.length;m++){
                        s += ch[m];
                    }

                    if (DICTIONARY.contains(s)){
                        ADVICE_LIST_SWAPPING_TWO_CHAR.add(s);
                    }
                }
            }
        }
    }





}
