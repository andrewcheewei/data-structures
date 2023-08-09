public class RectangleTester {
    public static void main(String[] args) {
        Rectangle smallSquare = new Rectangle(3.0, 3.0);
        Rectangle bigSquare = new Rectangle(4.0, 4.0);

        System.out.println(smallSquare.toString());
        System.out.println(bigSquare.toString());

        int output = smallSquare.compareTo(bigSquare);
        System.out.println(output);
    }
}
