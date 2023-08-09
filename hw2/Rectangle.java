import java.lang.Comparable;

public class Rectangle implements RectangleInterface, Comparable<Rectangle> {
    private double length;
    private double width;
    private double perimeter;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        perimeter = (length + width)*2;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }
   
    public int compareTo(Rectangle o) {
        if (perimeter < o.perimeter)
            return -1;
        else if (perimeter > o.perimeter)
            return 1;
        return 0;
    }

    public String toString() {
        return "length: " + length + ", width: " + width + ", perimeter: " + perimeter;
    }

}
