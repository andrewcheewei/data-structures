public class TwoStackQueueTester {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        TwoStackQueue myQueue = new TwoStackQueue();
        
        for (int i = 0; i < 9999; i++) {
            for (int j = 0; j < 9999; j++) {
                myQueue.enqueue("A String");
            }
        }

        myQueue.dequeue();
    }
}
