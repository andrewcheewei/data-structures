import java.util.LinkedList;
import java.util.List;

public class SpellCheckerTester {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("usage: java SpellCheckerTester <text file> <dictionary>");
            System.exit(1);
        }

        SpellChecker spellcheck = new SpellChecker(args[1]);
        System.out.println("Incorrect words: ");
        System.out.println(spellcheck.getIncorrectWords(args[0]) + "\n");

        List<String> incorrectWords = spellcheck.getIncorrectWords(args[0]);

        for (String word : incorrectWords) {
            System.out.println(spellcheck.getSuggestions(word));
        }

//        String test = "noz";
//        System.out.println("Substring(0,0) of 'noz': " + test.substring(0,0));
//        System.out.println("Substring(1) of 'noz': " + test.substring(1));
    }
}
