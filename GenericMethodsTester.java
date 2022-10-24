import java.util.Arrays;

public class GenericMethodsTester {
    public static void main(String[] args) {
        Rectangle[] a = new Rectangle[5];
        a[0] = new Rectangle(4.0, 6.0);
        a[1] = new Rectangle(12.0, 6.0);
        a[2] = new Rectangle(2.0, 3.0);
        a[3] = new Rectangle(2.0, 7.0);
        a[4] = new Rectangle(8.0, 8.0);

        Rectangle rect = new Rectangle(50.0, 20.0);
        Rectangle rect2 = new Rectangle(100.0, 500.0);

        GenericMethods searches = new GenericMethods();
        int linTest = searches.linearSearch(a, rect);
        System.out.println("Linear search: Expected -1, got " + linTest);

        Arrays.sort(a);
//        for (int i = 0; i < a.length; i++)
//            System.out.println("index " + i + ": " + a[i] + "\n");

        int binTest = searches.binarySearch(a, rect2);
        System.out.println("Binary search: Expected -1, got " + binTest);
    }
}
