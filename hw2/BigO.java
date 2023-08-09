import java.lang.Math;

public class BigO implements BigOInterface {

    public void cubic(int n) {
        System.out.println("How are you gentlemen!!");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println("move zig");
                }
                System.out.println("all your base");
            }
            System.out.println("are belong to us");
        }
        System.out.println("for great justice");
    }

    public void exp(int n) {
        double binaryTreeNodes = Math.pow(2, n);

        for (int i = 0; i < binaryTreeNodes; i++) {
            System.out.println("Creating node " + i + "...");
        }
    }

    public void constant(int n) {
        System.out.println("I'm only going to say this " + n + " times:\nHello");
    }
}
