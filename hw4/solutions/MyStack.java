/*
 * COMS W3134 - Summer B 2021
 * HW4 Solutions
 * MyStack.java
 */

@SuppressWarnings("unchecked")

public class MyStack<T> implements MyStackInterface<T>
{
	public final static int START_SIZE = 10;
	public int size;
	T[] stack;

	public MyStack()
	{
		this.size = 0;
		this.stack = (T[]) new Object[START_SIZE];
	}

	public void push(T x)
	{
		if (this.size >= this.stack.length)
		{
			T[] temp = (T[]) new Object[this.size * 2];
			for (int i = 0; i < this.stack.length; i ++)
			{
				temp[i] = this.stack[i];
			}

			this.stack = temp;
		}

		this.stack[size++] = x;
	}

	public T pop()
	{
		if (this.size > 0)
			return this.stack[--size];
		else
			return null;
	}

	public T peek()
	{
		if (this.size == 0)
			return null;

		return stack[size - 1];
	}

	public boolean isEmpty()
	{
		return (this.size == 0);
	}

	public int size()
	{
		return this.size;
	}

	public String toString()
	{
		String output = "";
		for (int i = this.size - 1; i >= 0; i--)
			output += "|" + this.stack[i] + "|\n+-+\n";
		return output;
	}
}
