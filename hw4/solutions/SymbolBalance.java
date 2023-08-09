/*
 * COMS W3134 - Summer B 2021
 * HW4 Solutions
 * SymbolBalance.java
 */
import java.util.*;
import java.io.*;

public class SymbolBalance implements SymbolBalanceInterface
{

	private String file;
	private MyStack<Character> stack;
	private boolean ignore;

	public SymbolBalance()
	{
		reset();
	}

	public void reset()
	{
		file = null;
		stack = new MyStack<>();
		ignore = false;
	}

	public void setFile(String filename) {
		reset();
		this.file = filename;
	}

	public BalanceError checkFile()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(this.file));
			return processReader(br);
		}

		catch (FileNotFoundException e)
		{
			System.out.println("The input file cannot be found");
			return null;
		}

		catch (Exception e)
		{
			System.out.println("An unknown error occurred.");
			return null;
		}
	}

	private BalanceError processReader(BufferedReader reader)
	{
		String line;
		int line_counter = 0;

		try
		{
			while ((line = reader.readLine()) != null)
			{
				line_counter += 1;
				char[] characters = line.toCharArray();
				for(int i = 0; i < characters.length; i ++)
				{	
					Character current = characters[i];

					if (ignore && current != '"' && current != '*')
						continue;

					else if (ignore)
					{
						Character top = stack.peek();
	
						if (top == null)
							return new EmptyStackError(line_counter);

						if (current == '"' && top == '"')
						{
							ignore = false;
							stack.pop();
						}
	
						else if (current == '*' && top == '*')
						{
							if ((i + 1 < characters.length && characters[i + 1] == '/') &&
							    (characters[i - 1] != '/'))
							{
								ignore = false;
								stack.pop();
							}
						}
					}

					else if ((current == '(') || (current == '{') || (current == '['))
						stack.push(current);

					else if ((current == '*') || (current == '"'))
					{
						if (current == '"')
						{
							ignore = true;
							stack.push(current);
						}
	
						else if (current == '*')
						{
							if (i > 0 && characters[i - 1] == '/')
							{
								ignore = true;
								stack.push(current);
							}
						}
					}

					else if ((current == ')') || (current == '}') || (current == ']'))
					{
						if (current == ')')
						{
							Character top = stack.peek();

							if (top == null)
								return new EmptyStackError(line_counter);

							else if (top == '(')
								stack.pop();
							
							else
								return new MismatchError(line_counter, current, stack.peek());
						}
	
						else if (current == '}')
						{
							Character top = stack.peek();

							if (top == null)
								return new EmptyStackError(line_counter);

							else if (top == '{')
								stack.pop();

							else
								return new MismatchError(line_counter, current, stack.peek());
						}
	
						else if (current == ']')
						{
							Character top = stack.peek();

							if (top == null)
								return new EmptyStackError(line_counter);
							
							else if (top == '[')
								stack.pop();

							else
								return new MismatchError(line_counter, current, stack.peek());
						}
					}
	
					else { /* do nothing */ }

				}
			}
		}

		catch (IOException e)
		{
			System.out.println("An IOException occured");
			return null;
		}

		catch (Exception e)
		{
			System.out.println("An unknown exception occurred while parsing the file.");
			return null;
		}

		if (this.stack.size() > 0)
		{
			return new NonEmptyStackError(this.stack.peek(), this.stack.size());
		}

		return null;
	}
}
