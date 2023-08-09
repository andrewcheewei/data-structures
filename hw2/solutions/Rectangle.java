/*
 * Rectangle.java Solution
 * Author: Ishaan Kishore Agrawal
 * UNI: ia2341
 * Date Created: 22 January, 2019
 * Date Modified: 23 January, 2019
 */

public class Rectangle implements RectangleInterface, Comparable<Rectangle> {

	// instance variables
	private double length;
	private double width;

	// default constructor
	public Rectangle()
	{
		length = 0.0;
		width = 0.0;
	}

	// constructor with dimension specifications
	public Rectangle(double len, double wid)
	{
		length = len;
		width = wid;
	}

	// define the functions in RectangleInterface
	public double getLength() { return length; }
	public double getWidth() { return width; }

	// private method that returns the perimeter of the rectangle
	private double getPerimeter() { return 2 * (length + width); }

	public int compareTo(Rectangle o)
	{
		if (this.getPerimeter() < o.getPerimeter())
			return -1;

		else if (this.getPerimeter() > o.getPerimeter())
			return 1;

		return 0;
	}

	public String toString()
	{
		return "{Length: " + getLength() + ", Width: " + getWidth() + ", Perimeter: " + getPerimeter() + "}";
	}

}
