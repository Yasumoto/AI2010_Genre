package com.bjoli.genre;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;


public class MarkovModel
{
	private Matrix mat;
	private HashMap<String, Integer> words;
	private HashMap<String, Integer> firstCounts;
	private int numWords;

	public MarkovModel()
	{
		mat = new Matrix();
		words = new HashMap<String, Integer>();
		firstCounts = new HashMap<String, Integer>();
	}

	public void update(File file)
	{
		Scanner s = createScanner(file);
		String[] line;

		while (s.hasNextLine()) //For each line in the file...
		{
			line = s.nextLine().split("[//s]+"); //Split into words.
			
			if (!firstCounts.containsKey(line[0]))
			{
				firstCounts.put(line[0], 1); //Set the number of occurrences to 1.
			}
			else
			{
				firstCounts.put(line[0], firstCounts.get(line[0]) + 1); //Increment count.
			}
			
			for (int i = 0; i < line.length; ++i)
			{
				if (!words.containsKey(i)) //If the word has not been added yet...
				{
					words.put(line[i], numWords++); //Add the word.
				}
			}
		}
	}

	public void train(File file, int label)
	{
		Scanner s = createScanner(file);
		String[] line;
		float current;

		while (s.hasNextLine()) //For each line in the file...
		{
			line = s.nextLine().split("[//s]+"); //Split into words.

			for (int i = 1; i < line.length; ++i) //For each word in the line, except the first word...
			{
				current = mat.get(words.get(line[i]), words.get(line[i - 1])); //Get the current count.
				mat.set(words.get(line[i]), words.get(line[i - 1]), current + 1); //Increment the current count.
			}
		}
	}

	public float probability(File file)
	{
		Scanner s = createScanner(file);
		String line;
		double firstProb;
		double sum;

		while (s.hasNextLine()) //For each line in the file...
		{
			line = s.nextLine();
			for (String i: line.split("[//s]+")) //For each word in the line, except the last word...
			{
				firstProb = firstCounts.get(words.get(i));


			}
		}

		return 0;
	}

	public void normalize()
	{

	}

	public void smooth()
	{

	}

	private Scanner createScanner(File file)
	{
		Scanner s = null;
		try
		{
			s = new Scanner(new FileReader(file));
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public void print()
	{
		mat.print();
	}
}
