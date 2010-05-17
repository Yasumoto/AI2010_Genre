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
		File[] genreFolders = dir.listFiles();
		genres = new String[genres.length];
		mms = new MarkovModel[genres.length];
		
		for (int i = 0; i < genreFolders.length; ++i)
		{
			genres[i] = genreFolders[i].getName();
			mms[i] = new MarkovModel();
			for (File file: genreFolders[i].listFiles())
			{
				mms[i].update(file);
				mms[i].train(file, i);
			}
		}
	}
	
	public String classify(File file)
	{
		//return genres[mm.classify(file)];
		return null;
	}
}
