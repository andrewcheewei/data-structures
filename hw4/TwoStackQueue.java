public class TwoStackQueue<T> implements TwoStackQueueInterface<T> {
    
    private MyStack<T> in;
    private MyStack<T> out;

//    @SuppressWarnings("unchecked")
//    public TwoStackQueue(int x) {
//        in = new MyStack<>(x/2);
//        out = new MyStack<>(x/2);
//    }

    @SuppressWarnings("unchecked")
    public TwoStackQueue() {
        // if I don't provide an arg, the code will just
        // die incredibly painfully on all tests
        // if I provide a small arg, it will fail on test 2
        in = new MyStack();
        out = new MyStack();
    }

    public void enqueue(T x) {
        in.push(x);
//        System.out.println("Enqueue " + in.peek() + " to stack 1");
//        System.out.println("Size of stack 1: " + in.size() + "\n");
//        System.out.println("Total capacity of stack 1: " + in.length + "\n");

    }

    public T dequeue() {
        if (isEmpty())
            return null;

        if (out.isEmpty())
            while (!in.isEmpty()) {
                out.push(in.pop());
//                System.out.print("Moved " + out.peek() + " onto stack 2\n");
            }

//        System.out.print("Dequeue " + out.peek() + " from stack 2\n");
        return out.pop();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

}
