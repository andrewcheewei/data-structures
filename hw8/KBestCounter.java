import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T> {
    private PriorityQueue<T> heap;
    private int k;

    public KBestCounter(int k) {
       heap = new PriorityQueue<>(k);
       this.k = k;
    }

    public void count(T x) {
//        System.out.println("Head of q before count(): " + heap.peek());
//        System.out.println("Attempting to add: " + x);
        if (heap.size() < k)
            heap.add(x);
        else if (heap.size() == k && x.compareTo(heap.peek()) > 0) {
            heap.poll();
            heap.add(x);
//            System.out.println("Head of q was polled and " + x + " was added to q");
        }
//        System.out.println("Head of q after count(): " + heap.peek() + "\n");
    }

    public List<T> kbest() {
        ArrayList<T> inorder = new ArrayList<>();

        while (heap.size() != 0)
            inorder.add((T)heap.poll());

//        System.out.println(inorder);
//        System.out.println();

        return inorder;
    }
}
