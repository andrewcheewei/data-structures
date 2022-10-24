public class Problem3 {
    public static void main(String[] args) {
        BigO bigboy = new BigO();

        long startTime = System.nanoTime();

        System.out.println("Method: exp(3)"); 
        bigboy.exp(3);
        System.out.println("Method: exp(4)"); 
        bigboy.exp(4);
        System.out.println("Method: exp(7)"); 
        bigboy.exp(7);
        System.out.println("Method: exp(13)"); 
        bigboy.exp(13);
        System.out.println("Method: exp(15)"); 
        bigboy.exp(15);
        System.out.println("Method: exp(18)"); 
        bigboy.exp(18);
        // stopped here because it started taking several seconds
      
        System.out.println("Method: cubic(2)"); 
        bigboy.cubic(2);
        System.out.println("Method: cubic(4)"); 
        bigboy.cubic(4);
        System.out.println("Method: cubic(7)"); 
        bigboy.cubic(7);
        System.out.println("Method: cubic(13)"); 
        bigboy.cubic(13);
        System.out.println("Method: cubic(15)"); 
        bigboy.cubic(15);
        System.out.println("Method: cubic(18)"); 
        bigboy.cubic(18);
 
        System.out.println("Method: constant(500)"); 
        bigboy.constant(500);
        System.out.println("Method: constant(10)"); 
        bigboy.constant(10);

        long endTime = System.nanoTime();
        long diff = endTime - startTime;
        System.out.println("Elapsed time: " + diff);
    }
}
