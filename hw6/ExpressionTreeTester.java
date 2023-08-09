public class ExpressionTreeTester {
    public static void main(String[] args) {
        String expression = "34 2 - 5 *";
        System.out.println("String: " + expression);
        System.out.println("Expected: 160");
        ExpressionTree tree = new ExpressionTree(expression); 
        System.out.println("Result: " + tree.eval());
        System.out.println("Postfix: " + tree.postfix());
        System.out.println("Prefix: " + tree.prefix());
        System.out.println("Infix: " + tree.infix() + "\n");

        // empty string
//        String expression1 = "";
//        System.out.println("String: " + expression1);
//        System.out.println("Expected: ");
//        ExpressionTree tree1 = new ExpressionTree(expression1); 
//        System.out.println("Result: " + tree1.eval() + "\n");

        // infix: ((10+69) * 2740) * 60 + 50 - (20/4) / 5
        String expression2 = "10 69 + 2740 * 60 * 50 + 20 4 / 5 / -";
        System.out.println("String: " + expression2);
        System.out.println("Expected: 12987649");
        ExpressionTree tree2 = new ExpressionTree(expression2); 
        System.out.println("Result: " + tree2.eval());
        System.out.println("Postfix: " + tree2.postfix());
        System.out.println("Prefix: " + tree2.prefix());
        System.out.println("Infix: " + tree2.infix() + "\n");

        // too many operators
//        String expression3 = "50 60 + +";
//        System.out.println("String: " + expression3);
//        System.out.println("Expected: empty stack");
//        ExpressionTree tree3 = new ExpressionTree(expression3); 
//        System.out.println("Result: " + tree3.eval() + "\n");

        // only operators
//        String expression4 = "- + +";
//        System.out.println("String: " + expression4);
//        System.out.println("Expected: empty stack");
//        ExpressionTree tree4 = new ExpressionTree(expression4); 
//        System.out.println("Result: " + tree4.eval() + "\n");

        // only operands
//        String expression4 = "8397 743 27 1";
//        System.out.println("String: " + expression4);
//        System.out.println("Expected: stack is not empty");
//        ExpressionTree tree4 = new ExpressionTree(expression4); 
//        System.out.println("Result: " + tree4.eval() + "\n");



    }
}
