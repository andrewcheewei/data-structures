public class KBestCounterTester {
    public static void main(String[] args) {
        KBestCounter<Integer> counter = new KBestCounter<>(6);

        counter.count(5);
        counter.count(8);
        counter.count(18);
        counter.count(35);
        counter.count(4);
        counter.count(98);
        counter.count(4);
        counter.count(83);
        counter.count(74);
        counter.count(90);
        counter.count(29);
        counter.count(23);
        counter.count(94);

        counter.kbest();
    }
}
