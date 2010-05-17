package com.bjoli.genre;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Classifier
{
	private String[] genres;
	private MarkovModel[] mms;
	
	public Classifier()
	{
		
	}
	
	public void train(File dir)
	{
		System.out.println(dir.exists());
		File[] genreFolders = dir.listFiles(); //Array of genre folders.
		System.out.println(genreFolders.toString());
		genres = new String[genreFolders.length]; //Array of genres as strings.
		mms = new MarkovModel[genreFolders.length]; //Array of Markov Models for each genre.
		
		for (int i = 0; i < genreFolders.length; ++i) //For each folder...
		{
			genres[i] = genreFolders[i].getName(); //Set the new genre name.
			mms[i] = new MarkovModel(); //Initialize new MM.
			for (File file: genreFolders[i].listFiles()) //For each file in the genre folder...
			{
				mms[i].update(file); //Initial pass to update words and counts.
				mms[i].train(file, i); //Train it.
			}
		}
		
		//TEST STUFF
//		for (MarkovModel mm: mms)
//		{
//			mm.print();
//		}
		
		
	}
	
//	public String classify(File file)
//	{
//		double[] probabilities = new double[genres.length];//array of initial probabilities.
//		int current = 0;//array counter.
//		for (MarkovModel mm: mms) //for every MarkovModel in the array.
//		{
//			probabilities[current] = mm.probability(file); //get initial probability from the Markov Model.
//			++current;
//		}
//		
//		double[] realProbabilities = new double[genres.length];//Array of calculated probabilities.
//		int max = 0; //Pointer to maximum probability.
//		for (int i = 0; i < genres.length; ++i) //Calculate probability for each genre.
//		{
//			double sum = 0;
//			for (int j = 0; j < genres.length; ++j)//Sum of the probabilities in different genres.
//			{
//				sum += Math.exp(probabilities[j]);
//			}
//			realProbabilities[i] = Math.exp(probabilities[i]) / sum; //Calculating final probability.
//			if (realProbabilities[i] > realProbabilities[max]) //recalculating max probability.
//			{
//				max = i;
//			}
//		}
//		
//		return genres[max];//returning corresponding genre.
//	}
	
	public String classifyLine(String line)
	{
		System.out.println("The line: " + line);
		double[] probabilities = new double[genres.length]; //array of initial probabilities.
		int current = 0; //array counter.
		for (MarkovModel mm: mms) //for every MarkovModel in the array.
		{
			probabilities[current] = mm.probability(line); //get initial probability from the Markov Model.
			++current;
		}
		
		//TEST
		for (int i = 0; i < genres.length; ++i)
		{
			System.out.println("\t" + genres[i] + " prob of " + probabilities[i]);
		}
		//END
		
		double[] realProbabilities = new double[genres.length];//Array of calculated probabilities.
		int max = 0; //Pointer to maximum probability.
		for (int i = 0; i < genres.length; ++i) //Calculate probability for each genre.
		{
			double sum = 0;
			for (int j = 0; j < genres.length; ++j)//Sum of the probabilities in different genres.
			{
				sum += Math.exp(probabilities[j]);
			}
			realProbabilities[i] = Math.exp(probabilities[i]) / sum; //Calculating final probability.
			if (realProbabilities[i] > realProbabilities[max]) //recalculating max probability.
			{
				max = i;
			}
		}
		System.out.println("Classified as: " + genres[max]);
		return genres[max]; //returning corresponding genre.
	}
	
	public String classify(File file)
	{
		HashMap<String, Integer> votes = new HashMap<String, Integer>(); //Stores the words and corresponding votes.
		Scanner s = createScanner(file);
		String line, vote;
		
		while (s.hasNext()) //
		{
			line = s.nextLine(); 
			vote = classifyLine(line); //returns the classification of line.
			
			if (!votes.containsKey(vote)) //if the word is not already in the HashMap.
			{
				votes.put(vote, 1);//add and set the vote to 1.
			}
			else //if the vote is already in the HashMap
			{
				votes.put(vote, votes.get(vote) + 1); //Increment the number of votes 
			}
		}
		
		String finalVote = null; 
		int highCount = 0;
		
		for (String i: votes.keySet()) //Iterating through all the strings in HashMap. 
		{
			System.out.println(i + ": " + votes.get(i) + " votes");
			if (votes.get(i) > highCount) //If vote count is higher then high count. 
			{
				finalVote = i; //sets final vote to the newest high vote.
				highCount = votes.get(i);
			}
		}
		
		System.out.println(finalVote);
		
		return finalVote;
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
	
	public static void main(String[] args)
	{
		Classifier cf = new Classifier();
		cf.train(new File("/Users/linzy/Documents/workspace/AI Project/AISongLyrics"));
		String x = cf.classify(new File("/Users/linzy/Documents/workspace/AI Project/TestSongs/s4.txt"));
		//String x = cf.classify(new File("/Users/linzy/Documents/workspace/AI Project/AISongLyrics/Spiritual/Agnus Dei- Richard Marlow & The Choir of Trinity College.txt"));
		System.out.println(x);
	}
}
