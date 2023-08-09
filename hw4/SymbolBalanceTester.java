import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class SymbolBalanceTester {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage: java SymbolBalanceTester <file path>");
            System.exit(1);
        }

        SymbolBalance sym = new SymbolBalance();
        sym.setFile(args[0]);
        System.out.println(sym.checkFile());

    }

}
