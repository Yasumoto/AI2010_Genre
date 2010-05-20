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
	private HashMap<String, Float> firstCounts;
	private int numWords;
	private float smallest;

	public MarkovModel()
	{
		mat = new Matrix();
		words = new HashMap<String, Integer>();
		firstCounts = new HashMap<String, Float>();
	}

	public void update(File file)
	{
		Scanner s = createScanner(file);
		String[] line;

		while (s.hasNextLine()) //For each line in the file...
		{
			line = s.nextLine().toLowerCase().split("[//s]+"); //Split into words.
			
			if (!firstCounts.containsKey(line[0]))
			{
				firstCounts.put(line[0], new Float(1)); //Set the number of occurrences to 1.
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
			line = s.nextLine().toLowerCase().split("[//s]+"); //Split into words.

			for (int i = 0; i < line.length - 1; ++i) //For each word in the line, except the first word...
			{
				current = mat.get(words.get(line[i]), words.get(line[i + 1])); //Get the current count.
				mat.set(words.get(line[i]), words.get(line[i + 1]), current + 1); //Increment the current count.
			}
		}
	}

//	public float probability(File file)
//	{
//		Scanner s = createScanner(file);
//		String line;
//		double firstProb;
//		double sum;
//
//		while (s.hasNextLine()) //For each line in the file...
//		{
//			line = s.nextLine();
//			for (String i: line.split("[//s]+")) //For each word in the line, except the last word...
//			{
//				firstProb = firstCounts.get(words.get(i));
//
//
//			}
//		}
//
//		return 0;
//	}
	
	public double probability(String line)
	{
		String[] splitLine = line.toLowerCase().split("[//s]+"); //Array of words in the line.
		double firstProb = 0;
		double sum = 0;

		Float val;
		if ((val = firstCounts.get(splitLine[0])) != null)
			firstProb = Math.log(val); //Log of the first word probability.
//		else
//			firstProb = Math.log(smallest / 2);
		
		for (int i = 1; i < splitLine.length; ++i) //going through the array
		{
			if (words.get(splitLine[i]) != null && words.get(splitLine[i - 1]) != null 
					&& mat.get(words.get(splitLine[i]), words.get(splitLine[i - 1])) != 0)
				sum += Math.log(mat.get(words.get(splitLine[i]), words.get(splitLine[i - 1]))); //taking the log of the bigram probability
//			else
//				sum += Math.log(smallest / 2);
		}
		
		return firstProb + sum; //returning the first word probability plus the sum of the bigram probability.
	}

	public void normalize()
	{
		//Normalize first words hash map
		for (String i: firstCounts.keySet()) //For each first word.
		{
			firstCounts.put(i, firstCounts.get(i) / firstCounts.keySet().size()); //replaces count by count divided by size
		}
		
		//Normalize bigram matrix
		smallest = Integer.MAX_VALUE;
		
		for (int i = 0; i < mat.getSize(); ++i) //Iterating through matrix rows...
		{
			float count = 0;
			for (int j = 0; j < mat.getSize(); ++j) //Iterating through matrix cols...
			{
				if (mat.get(i, j) > 0) //if it exists.
					count = count + mat.get(i, j); //Adding all non zero values in the row
			}
			for (int j = 0; j < mat.getSize(); ++j) //iterating through matrix cols again...
			{
				if (mat.get(i, j) > 0) //if it is a non zero value.
				{
					float value = mat.get(i, j) / count; //dividing non zero values by the total count.
					mat.set(i, j, value);
					if (value < smallest)
					{
						smallest = value;
					}
				}
			}
		}
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
