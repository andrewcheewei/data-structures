/*
 * Problem3.java Solution
 * Author: Ishaan Kishore Agrawal
 * UNI: ia2341
 * Date Created: 22 January, 2019
 * Date Modified: 23 January, 2019
 */

public class Problem3 {

	// main method
	public static void main(String[] args)
	{
		// declare the methods object and the timing variables
		BigO methods = new BigO();
		long startTime, endTime;

		// testing the cubic code fragment
		System.out.println("Timed Results for cubic()");
		for (int i = 10; i < 6250; i *= 5)
		{
			startTime = System.nanoTime();
			methods.cubic(i);
			endTime = System.nanoTime();
			System.out.println("For N = " + i + ", Time Elapsed = " + (endTime - startTime) + " ns.");
		}

		// testing the cubic code fragment
		System.out.println("Timed Results for exp()");
		for (int i = 8; i <= 32; i *= 2)
		{
			startTime = System.nanoTime();
			methods.exp(i);
			endTime = System.nanoTime();
			System.out.println("For N = " + i + ", Time Elapsed = " + (endTime - startTime) + " ns.");
		}

		// testing the cubic code fragment
		System.out.println("Timed Results for constant()");
		for (int i = 10; i < 1000000; i *= 10)
		{
			startTime = System.nanoTime();
			methods.constant(i);
			endTime = System.nanoTime();
			System.out.println("For N = " + i + ", Time Elapsed = " + (endTime - startTime) + " ns.");
		}
	}
}
