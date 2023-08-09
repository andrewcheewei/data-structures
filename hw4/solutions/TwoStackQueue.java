/*
 * COMS W3134 - Summer B 2021
 * HW4 Solutions
 * TwoStackQueue.java
 */
public class TwoStackQueue<T> implements TwoStackQueueInterface<T>
{
	private MyStack<T> stack1;
	private MyStack<T> stack2;	

	public TwoStackQueue()
	{
		stack1 = new MyStack<>();
		stack2 = new MyStack<>();
	}

	public void enqueue(T x) { stack1.push(x); }

	public T dequeue()
	{
		if (!stack2.isEmpty())
			return stack2.pop();

		while (!stack1.isEmpty())
			stack2.push(stack1.pop());

		return stack2.pop();
	}

	public int size() { return stack1.size() + stack2.size(); }

	public boolean isEmpty() { return (this.size() == 0); }	
}
