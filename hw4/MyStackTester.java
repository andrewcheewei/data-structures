import java.util.Scanner;

public class MyStackTester {
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        
        Scanner in = new Scanner(System.in);
        stack.push(6);
        System.out.println(stack.peek());

        while (true) {
            System.out.print("Push, pop, peek, empty, size, end? ");
            String action = in.next();
            System.out.println("Action is: " + action);
            
            if (action.equals("push")) {
                System.out.print("Enter item: ");
                int x = in.nextInt();
                stack.push(x);
            } else if (action.equals("pop")) {
                stack.pop();
                System.out.println(stack.pop());
            } else if (action.equals("peek")) {
                System.out.println(stack.peek());
            } else if (action.equals("empty")) {
                System.out.println(stack.isEmpty());
            } else if (action.equals("size")) {
                System.out.println(stack.size());
            } else if (action.equals("end")) {
                return;
            }
        }
    }
}
