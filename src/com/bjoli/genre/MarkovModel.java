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
	private HashMap<Integer, Integer> counts;
	private int numWords;
	
	public MarkovModel()
	{
		mat = new Matrix();
		words = new HashMap<String, Integer>();
		counts = new HashMap<Integer, Integer>();
	}
	
	public void update(File file)
	{
		Scanner s = createScanner(file);
		String line;
		
		while (s.hasNextLine()) //For each line in the file...
		{
			line = s.nextLine();
			for (String i: line.split("[//s}+")) //For each word in the line...
			{
				if (!words.containsKey(i)) //If the word has not been added yet...
				{
					words.put(i, numWords); //Add the word.
					counts.put(numWords++, 1); //Set the number of occurrences to 1 and increment numWords.
				}
				else
				{
					counts.put(words.get(i), counts.get(words.get(i)) + 1); //Otherwise, just increment the current count.
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
			line = s.nextLine().split("[//s}+"); //Split into words.
			
			for (int i = 0; i < line.length - 1; ++i) //For each word in the line, except the last word...
			{
				current = mat.get(words.get(line[i]), words.get(line[i + 1])); //Otherwise, we get the current value.
				mat.set(words.get(line[i]), words.get(line[i + 1]), current + 1); //We increment the current value.
			}
		}
	}
	
	public float probability(File file)
	{
		return 0;
	}
	
	public void normalize()
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
}
