import java.io.*;
import java.util.Scanner;

public class SymbolBalance<T> {

    private MyStack<Character> stack;
    private String lineText;
    private int lineNumber;
    private File f;
    private boolean literalComment;

    @SuppressWarnings("unchecked")
    public SymbolBalance() {
        stack = new MyStack<>();
        lineNumber = 0;
        literalComment = false;
    }

    public void setFile(String filename) {
        // arg is the path to the file
         f = new File(filename);
    }
    

    public BalanceError checkFile() {
        try {
            Scanner in = new Scanner(f);
            while(in.hasNextLine()) {
                lineNumber++;
                lineText = in.nextLine();
//                System.out.println(lineText);

                for (int i = 0; i < lineText.length(); i++) {
                    char c = lineText.charAt(i);
                    // wrap it for the stack
                    Character ch = Character.valueOf(c);

                    // ignore all chars bc literal string
                    // or comment. Only a " can end a literal 
                    // string and * to end the comment
                    if (literalComment && c != '"' && c != '*')
                        continue;

                    // conditions to check for end of
                    // literal string or multiline comment
                    if (literalComment) {
                        // check for end of literal string
                        if (c == '"' && stack.peek() == '"') {
                            literalComment = false;
//                            System.out.println("Just popped " + stack.peek());
                            stack.pop();
                        // check for end of multiline comment
                        } else if (c == '*' && stack.peek() == '*') {
                            if (lineText.charAt(i-1) != '/' &&
                                i+1 < lineText.length() &&
                                lineText.charAt(i+1) == '/') 
                            {
                                literalComment = false;
//                                System.out.println("Just popped " + stack.peek());
                                stack.pop();
                            }
                        } 
                    } 
                    // check for start of literal string
                    // else if because it was getting caught
                    // on a single line string. Some issue with
                    // the boolean being flipped 
                    else if (c == '"') {
                        literalComment = true;
                        stack.push(ch);
//                        System.out.println("Just pushed " + stack.peek());
                    }

                    // check for start of multiline comment
                    if (c == '*') {
                        if (i > 0 && lineText.charAt(i-1) == '/' && !literalComment) {
                            literalComment = true;
                            stack.push(ch);
//                            System.out.println("Just pushed " + stack.peek());
                        }
                    }
 
                    // check for start symbols
                    if (c == '(' || c == '{' || c == '[') {
                        stack.push(ch);
//                        System.out.println("Just pushed " + stack.peek());
                    }
    
                    // check for end parentheses and match to top of stack
                    if (c == ')') {
                        if (stack.isEmpty())
                            return new EmptyStackError(lineNumber);
                        if (stack.peek().equals('(')) {
//                            System.out.println("Just popped " + stack.peek());
                            stack.pop();
                        }
                        else
                            return new MismatchError(lineNumber, c, stack.peek());
                    } 
                    
                    // check closing brace
                    if (c == '}') {
                        if (stack.isEmpty())
                            return new EmptyStackError(lineNumber);
                        if (stack.peek().equals('{')) {
//                            System.out.println("Just popped " + stack.peek());
                            stack.pop();
                        }
                        else
                            return new MismatchError(lineNumber, c, stack.peek());
                    }
    
                    // check closing bracket
                    if (c == ']') {
                        if (stack.isEmpty())
                            return new EmptyStackError(lineNumber);
                        if (stack.peek().equals('[')) {
//                            System.out.println("literalComment is " + literalComment);
//                            System.out.println("Just popped " + stack.peek());
                            stack.pop();
                        }
                        else
                            return new MismatchError(lineNumber, c, stack.peek());
                    }
                }
            }
    
        } 

        catch(Exception FileNotFoundException) {
            System.err.println("I/O error");
            System.exit(1);
        }
        // check stack
        if (stack.isEmpty()) {
            return null; // no error found
        }
        // if we get here, then the stack is not empty
        return new NonEmptyStackError(stack.peek(),stack.size());

    }
}
