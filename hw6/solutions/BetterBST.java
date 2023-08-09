import java.util.*;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>
{	
	public BetterBST() { this.root = null; }

	public BetterBST(BinaryNode<T> root) { this.root = root; }

	public int height() { return height(this.root); }

	private int height(BinaryNode<T> root)
	{
		if (root == null)
			return -1;

		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public T imbalance() { return imbalance(this.root); }

	private T imbalance(BinaryNode<T> root)
	{
		if (root == null)
			return null;

		if (Math.abs(height(root.left) - height(root.right)) > 1)
			return root.data;

		T left_imbalance = imbalance(root.left);
		T right_imbalance = imbalance(root.right);

		if (left_imbalance == null)
			return right_imbalance;

		if (right_imbalance == null)
			return left_imbalance;

		return left_imbalance;		// could return right_imbalance as well
	}

	public BinarySearchTree<T> mirror() { return new BetterBST<T>(mirror(this.root)); }

	private BinaryNode<T> mirror(BinaryNode<T> root)
	{
		if (root == null)
			return root;

		return new BinaryNode<T>(root.data, mirror(root.right), mirror(root.left));
	}

	public T smallestGreaterThan(T t) { return smallestGreaterThan(t, root); }

	private T smallestGreaterThan(T t, BinaryNode<T> root)
	{
		if (root == null)
			return null;
		else if (t.compareTo(root.data) >= 0)
			return smallestGreaterThan(t, root.right);
		else
		{
			T left_result = smallestGreaterThan(t, root.left);
			if (left_result == null)
				return root.data;

			return left_result;
		}
	}
	
	public LinkedList<BinaryNode<T>> levelOrderTraversal() {
		LinkedList<BinaryNode<T>> queue = new LinkedList<>();
		LinkedList<BinaryNode<T>> levelTraversal = new LinkedList<>();
		queue.offer(root);
		BinaryNode<T> removed = null;
		while(!queue.isEmpty()) {
			removed = queue.poll();
			if(removed != null) {
				levelTraversal.add(removed);
				queue.offer(removed.left);
				queue.offer(removed.right);
			}
		}
		return levelTraversal;		
	}
	
	public static void main(String[] args) {
		BetterBST<Integer> x = new BetterBST<>();
		x.insert(100);
		x.insert(105);
		x.insert(97);
		x.insert(9);
		x.insert(917);
		x.insert(297);
		x.insert(7);
		System.out.println(x.levelOrderTraversal());
	}
	
}
