/*
 * GenericMethods.java Solution
 * Author: Ishaan Kishore Agrawal
 * UNI: ia2341
 * Date Created: 22 January, 2019
 * Date Modified: 23 January, 2019
 */

import java.util.*;

public class GenericMethods implements GenericMethodsInterface {
	
	// binarySearch routine
	public <T extends Comparable<T>> int binarySearch(T[] a, T x)
	{
		// if the array is empty, return -1 (for not found)
		if (a.length == 0)
			return -1;

		// return the value found by the recursive helper method
		return binaryHelper(a, x, 0, a.length - 1);
	}

	// private binarySearch helper routine
	private <T extends Comparable<T>> int binaryHelper(T[] a, T x, int start, int end)
	{
		// if the array is of non-positive size, return -1 (for not found)
		if (start > end)
			return -1;

		// get the middle position
		int middle = start + ((end - start) / 2);		// evaluates to (start + end) / 2

		// compare the middle element to the element being search
		// accordingly look at different parts of the array
		if (a[middle].compareTo(x) == 0)
			return middle;
		else if (a[middle].compareTo(x) < 0)
			return binaryHelper(a, x, middle + 1, end);
		else
			return binaryHelper(a, x, start, middle - 1);
	}

	// linearSearch routine
	public <T extends Comparable<T>> int linearSearch(T[] a, T x)
	{
		// iteratively, look for the desired element
		for (int i = 0; i < a.length; i ++)
		{
			if (a[i].compareTo(x) == 0)
				return i;
		}

		// if not found, return -1
		return -1;
	}


	public static void main(String[] args)
	{
		// creating an array of Rectangle objects
		Rectangle[] array = {new Rectangle(3, 5),		// perimeter = 16
			             new Rectangle(4, 2),		// perimeter = 12
				     new Rectangle(10, 1),		// perimeter = 22 => LARGEST
				     new Rectangle(1, 2),		// perimeter = 6
				     new Rectangle(5, 5)};		// perimeter = 20

		// instantiate the object to call all the generic methods
		GenericMethods methods = new GenericMethods();
		
		// Declare a Rectangle that needs to be found (perimeters must match)
		Rectangle toSearch = new Rectangle(7, 3);		// perimeter = 20

		// Perform linear search and print the results
		int index = methods.linearSearch(array, toSearch);			// desired value = 4
		System.out.println("Rectangle Searched: " + toSearch);
		System.out.println("Index in Original Array: " + index);
		System.out.println("Rectangle Found: " + array[index] + "\n");

		// Sort the array (for binarySearch)
		Arrays.sort(array);

		// Perform binary search and print the results
		int index2 = methods.binarySearch(array, toSearch);			// desired value = 3
		System.out.println("Rectangle Searched: " + toSearch);
		System.out.println("Index in Sorted Array: " + index2);
		System.out.println("Rectangle Found: " + array[index2] + "\n");

	}
}
