package com.bjoli.genre;

import java.io.File;

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
	
	public String classify(File file)
	{
		double[] probabilities = new double[genres.length];//array of initial probabilities.
		int current = 0;//array counter.
		for (MarkovModel mm: mms) //for every MarkovModel in the array.
		{
			probabilities[current] = mm.probability(file); //get initial probability from the Markov Model.
			++current;
		}
		
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
		
		return genres[max];//returning corresponding genre.
	}
	
	public static void main(String[] args)
	{
		Classifier cf = new Classifier();
		cf.train(new File("/Users/linzy/Documents/workspace/AI Project/AISongLyrics"));
	}
}
