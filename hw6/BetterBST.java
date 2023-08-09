import java.util.LinkedList;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>{
    private static final int ALLOWED_BALANCE = 1;

    public BetterBST() {
        root = null;
    }

    public int height() {
        return height(root);
    }
    
    private int height(BinaryNode<T> n) {
        if (n == null)
            return -1;
        return Math.max(height(n.left), height(n.right)) + 1;
    }
    
    public T imbalance() {
        return imbalance(root);
    }

    private T imbalance(BinaryNode<T> n) {
        if (n == null)
            return null;

        if ((Math.abs(height(n.left) - height(n.right)) > ALLOWED_BALANCE))
            return n.data;

        imbalance(n.left); // then we check subtrees
        imbalance(n.right); 

        return null;
    }
  
    public T smallestGreaterThan(T t) {
        return smallestGreaterThan(t, root);
    }

    private T smallestGreaterThan(T t, BinaryNode<T> n) {
        if (n == null)
            return null;

        int compare = t.compareTo(n.data);

        if (compare < 0) {
            T temp = smallestGreaterThan(t, n.left);
            if (temp == null)
                return n.data;
            return temp;
        } else if (compare >= 0) {
            return smallestGreaterThan(t, n.right);
        }
        return null;
    }
    
    public BinarySearchTree<T> mirror() {
        return mirror(root);
    }

    private BinarySearchTree<T> mirror(BinaryNode<T> n) {
        if (n == null)
            return new BetterBST<T>();

        BetterBST<T> tree = new BetterBST<>();
        tree.root = copyBinaryTree(n);
        tree.root = mirrorMutate(tree.root);
        return tree;
    }

    private BinaryNode<T> copyBinaryTree(BinaryNode<T> n) {
        if (n == null)
            return n;

        BinaryNode<T> copyNode = new BinaryNode<>(n.data);
        copyNode.left = copyBinaryTree(n.left);
        copyNode.right = copyBinaryTree(n.right);

        return copyNode;
    }

    private BinaryNode<T> mirrorMutate(BinaryNode<T> n) {
        if (n == null)
            return n;

        BinaryNode<T> left = mirrorMutate(n.left);
        BinaryNode<T> right = mirrorMutate(n.right);

        n.left = right;
        n.right = left;

        return n;
    }

    public LinkedList<BinaryNode<T>> levelOrderTraversal() {
        return levelOrderTraversal(root);
    }

    private LinkedList<BinaryNode<T>> levelOrderTraversal(BinaryNode<T> n) {
        if (n == null)
            return null;

        LinkedList<BinaryNode<T>> visited = new LinkedList<>();
        LinkedList<BinaryNode<T>> levelOrder = new LinkedList<>();
        visited.add(n);

        while (!visited.isEmpty()) {
            BinaryNode<T> dequeued = visited.poll();
            levelOrder.add(dequeued);
            if (dequeued.left != null)
                visited.add(dequeued.left);
            if (dequeued.right != null)
                visited.add(dequeued.right);
        }
        return levelOrder;
    }
}
