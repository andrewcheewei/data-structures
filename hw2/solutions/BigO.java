/*
 * BigO.java Solution
 * Author: Ishaan Kishore Agrawal
 * UNI: ia2341
 * Date Created: 22 January, 2019
 * Date Modified: 23 January, 2019
 */

public class BigO implements BigOInterface {

	// function with a O(n^3) time complexity
	public void cubic(int n)
	{
		int sum = 0;
		for (int i = 0; i < n; i ++)
		{
			for (int j = 0; j < n; j ++)
			{
				for (int k = 0; k < n; k ++)
				{
					sum ++;
				}
			}
		}
	}

	// function with a O(2^n) time complexity
	public void exp(int n)
	{
		int val;

		if (n <= 0)
			val = 0;

		else if (n <= 2)
			val = 1;

		else
		{
			exp(n - 1);
			exp(n - 2);
		}
	}

	// function with a O(1) time complexity
	public void constant(int n)
	{
		int x = n;
	}
}
