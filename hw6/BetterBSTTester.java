public class BetterBSTTester {

    public static void main(String[] args) {
        BetterBST tree = new BetterBST();

//        tree.insert(4);
//        tree.insert(2);
//        tree.insert(6);
//        tree.insert(5);
//        tree.insert(1);
//        tree.insert(3);

        System.out.println("Tree height: " + tree.height());
        System.out.println("Imbalance: " + tree.imbalance());
        System.out.println("Expected for mirror: null"); 
        System.out.println("Mirror: " + tree.mirror());
        System.out.println("Expected for smallestGreaterThan: null"); 
        System.out.println("smallestGreaterThan: " + tree.smallestGreaterThan(2));
   }
}
