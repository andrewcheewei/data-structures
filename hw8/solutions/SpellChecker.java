import java.util.*;
import java.io.*;

public class SpellChecker implements SpellCheckerInterface
{
	HashSet<String> dictionary;

	public SpellChecker(String filename) throws IOException
	{
		dictionary = new HashSet<>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;

		while ((line = br.readLine()) != null)
		{
			String[] words = line.toLowerCase().split("\\s+");
			for (int i = 0; i < words.length; i ++)
				dictionary.add(words[i].replaceAll("[^a-z0-9]", ""));
		}
	}

	public List<String> getIncorrectWords(String filename)
	{
		ArrayList<String> output = new ArrayList<>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;

			while ((line = br.readLine()) != null)
			{
				String[] words = line.toLowerCase().split("\\s+");
				for (int i = 0; i < words.length; i ++)
				{
					String word = words[i];
					word = word.replaceAll("[^a-z0-9]", "");
					if (!dictionary.contains(word) && word.length() > 0)
						output.add(word);
				}
			}
		}

		catch(Exception e)
		{
			System.out.println("Filename not found");
		}

		return output;
		
	}

	public Set<String> getSuggestions(String word)
	{
		HashSet<String> output = new HashSet<>();
		word = word.toLowerCase().replaceAll("[^a-z0-9]", "");

		output.addAll(addCharacter(word));
		output.addAll(removeCharacter(word));
		output.addAll(swapCharacters(word));

		return output;
	}

	private HashSet<String> addCharacter(String word)
	{
		HashSet<String> output = new HashSet<>();
		StringBuilder builder = new StringBuilder(word);
		
		for (int i = 0; i < builder.length() + 1; i ++)
		{
			for (char character = 'a'; character <= 'z'; character ++)
			{
				builder.insert(i, character);
				if (dictionary.contains(builder.toString()))
					output.add(builder.toString());
				builder.deleteCharAt(i);
			}
		}
		return output;
	}

	private HashSet<String> removeCharacter(String word)
	{
		HashSet<String> output = new HashSet<>();
		StringBuilder builder = new StringBuilder(word);
		
		for (int i = 0; i < builder.length(); i ++)
		{	
			char temp = word.charAt(i);
			builder.deleteCharAt(i);
			if (dictionary.contains(builder.toString()))
				output.add(builder.toString());
			builder.insert(i, temp);
		}
		return output;
	}

	private HashSet<String> swapCharacters(String word)
	{
		HashSet<String> output = new HashSet<>();

		for (int i = 0; i < word.length() - 1; i ++)
		{
			String temp;

			if (i != word.length() - 2)
				temp = word.substring(0, i) + word.charAt(i + 1) + word.charAt(i) + word.substring(i + 2, word.length());
			else
				temp = word.substring(0, i) + word.charAt(i + 1) + word.charAt(i);
			
			if (dictionary.contains(temp))
				output.add(temp);
		}
		return output;
	}
}
