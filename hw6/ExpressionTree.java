import java.util.LinkedList;

public class ExpressionTree implements ExpressionTreeInterface {
    private ExpressionNode root;
    private LinkedList<ExpressionNode> stack;
    private int top;

    public ExpressionTree(String expression) {
        stack = new LinkedList<ExpressionNode>();
        int top = -1;

        if (expression.length() == 0)
            throw new RuntimeException("Error: empty string provided");

        // extract t
        String[] tokens = expression.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];

            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                // pop operands and attach to operator as children
                if (stack.isEmpty())
                    throw new RuntimeException("Error: stack is empty");
                ExpressionNode rightOperand = stack.remove(top);
                top--;
                if (stack.isEmpty())
                    throw new RuntimeException("Error: stack is empty");
                ExpressionNode leftOperand = stack.remove(top);
                top--;
                // throw new exception if empty stack
                
                // push operator back onto stack
                char operator = t.charAt(0);
                stack.add(new ExpressionNode(operator, leftOperand, rightOperand));
                top++;
            } else {
                int operand = Integer.parseInt(t);
                stack.add(new ExpressionNode(operand));
                top++;
            }
        }
        root = stack.remove(top);
        if (!stack.isEmpty())
            throw new RuntimeException("Error: stack is not empty");
    }

    public int eval() {
        return eval(root);
    }

    private int eval(ExpressionNode n) {
        // not sure if necessary to check for empty null
//        if (n.operand == null && n.operator == null)
//            throw new RuntimeException("Error: empty node");
            
        if (n.left == null && n.right == null)
            return n.operand;
        int leftValue = eval(n.left);
        int rightValue = eval(n.right);
        return apply(n.operator, leftValue, rightValue);
    }

    private int apply(char operator, int left, int right) {
        // evaluates expression based on operator
        if (operator == '+')
            return left+right;
        else if (operator == '-')
            return left-right;
        else if (operator == '*')
            return left*right;
        return left/right;
    }

    public String postfix() {
        return postfix(root);
    }

    private String postfix(ExpressionNode n) {
        // is operator
        if (n.left != null && n.right != null)
            return postfix(n.left) + " " + postfix(n.right) + " " + n.operator;
        return Integer.toString(n.operand);
    }

    public String prefix() {
        return prefix(root);
    }

    private String prefix(ExpressionNode n) {
        if (n.left != null && n.right != null)
            return n.operator + " " + prefix(n.left) + " " + prefix(n.right);
        return Integer.toString(n.operand);
    }

    public String infix() {
        return infix(root);
    }

    private String infix(ExpressionNode n) {
        if (n.left != null && n.right != null) {
            if (n.left.operator == '+' || n.left.operator == '-') {
                return "(" + " " + infix(n.left) + " " + ")" + " " + n.operator + " " + infix(n.right);
            }
            return infix(n.left) + " " + n.operator + " " + infix(n.right) + " ";
        }
        return Integer.toString(n.operand);
    }

    private static class ExpressionNode {
        public ExpressionNode left;
        public ExpressionNode right;
        public int operand; // must be a leaf
        public char operator; // must have two children

        public ExpressionNode(int num) {
            operand = num;
            left = null;
            right = null;
        }

        public ExpressionNode(char operator, ExpressionNode l, ExpressionNode r) {
            this.operator = operator;
            left = l;
            right = r;

            if (left == null || right == null)
                throw new RuntimeException("Error: operator does not have two operands");
        }

        public ExpressionNode(int num, ExpressionNode l, ExpressionNode r) {
            operand = num;
            left = l;
            right = r;
        }
    }
}
