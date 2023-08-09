public class MyStack<T> implements MyStackInterface<T> {

    private T[] arr;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

//    @SuppressWarnings("unchecked")
//    public MyStack(int x) {
//        arr = (T[])new Object[x];
//        top = -1;
//    }

    @SuppressWarnings("unchecked")
    public MyStack() {
        arr = (T[])new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < arr.length)
            return;

        T[] old = arr;
        arr = (T[]) new Object[newCapacity*2+1];
        for (int i = 0; i < size(); i++)
            arr[i] = old[i];
    }


//    @SuppressWarnings("unchecked")
    public void push(T x) {
        // increase size if stack is full
//        if (top >= arr.length) {
//            T[] newArr = (T[])new Object[arr.length*2]; 
//            for (int i = 0; i < arr.length; i++) {
//                newArr[i] = arr[i];
//            }
//            arr = newArr;
//        }
        top++;
        ensureCapacity(top+1);
        arr[top] = x;
    }

    public T pop() {
        if (top <= -1)
            return null;
        T poppable = arr[top];
        arr[top] = null;
        top--;
        return poppable;
    }
    
    public T peek() {
        if (top <= -1)
            return null;
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top <= -1;
    }

    public int size() {
        return top+1;
    }
}
