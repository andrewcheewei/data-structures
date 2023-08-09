import java.io.File;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;

public class SpellChecker implements SpellCheckerInterface {
    HashSet<String> dict;

    public SpellChecker(String filename) {
        try {
            File f = new File(filename);
            dict = parseDict(f);
        }
        catch(Exception FileNotFoundException) {
            System.err.println("I/O error");
            System.exit(1);
        }
    }

    public List<String> getIncorrectWords(String filename) {
        LinkedList<String> incorrectWords = new LinkedList<>();

        try {
            File textToCheck = new File(filename);
            Scanner in = new Scanner(textToCheck);
            String str = "";
    
            while (in.hasNextLine()) {
                str += in.nextLine() + " ";
            }

            str = str.toLowerCase().replaceAll("[^a-z ^0-9]", "");
            String[] whitespaceDelim = str.split("\\s+");
    
            for (int i = 0; i < whitespaceDelim.length; i++) {
                if (!dict.contains(whitespaceDelim[i]))
                    incorrectWords.add(whitespaceDelim[i]);
            }
        }
        catch(Exception FileNotFoundException) {
            System.err.println("I/O error");
            System.exit(1);
        }
        return incorrectWords;
    }

    public Set<String> getSuggestions(String word) {
        HashSet<String> suggestions = new HashSet<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // add one char
        for (int i = 0; i <= word.length(); i++) {
            // substring(inclusive, exclusive)
            // <= to check char at end of string
            for (int j = 0; j < alphabet.length; j++) {
                String newWord = word.substring(0,i) + alphabet[j] + word.substring(i);
                if (dict.contains(newWord))
                    suggestions.add(newWord);
            }
        }
        // remove one char
        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0,i) + word.substring(i+1);
            if (dict.contains(newWord))
                suggestions.add(newWord);
        }
        // swap adjacent chars
        for (int i = 0; i < word.length()-1; i++) {
            String newWord = word.substring(0,i) + word.charAt(i+1) + word.charAt(i) + word.substring(i+2);
            if (dict.contains(newWord))
                suggestions.add(newWord);
        }
        return suggestions;
    }

    private HashSet<String> parseDict(File f) {
        HashSet<String> dictionary = new HashSet<>();
        try{
            Scanner in = new Scanner(f);
            while (in.hasNextLine()) {
                String str = in.nextLine().toLowerCase().replaceAll("[^a-z ^0-9]", "");
                dictionary.add(str);
            }
        }
        catch(Exception FileNotFoundException) {
            System.err.println("I/O error");
            System.exit(1);
        }
        return dictionary;
    }
}
