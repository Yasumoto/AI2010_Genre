package com.bjoli.genre;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Preprocessor {
	ArrayList stopwords = new ArrayList();
	public Preprocessor() {
	stopwords.add("a"); stopwords.add("about"); stopwords.add("above"); stopwords.add("above"); stopwords.add("across"); stopwords.add("after"); stopwords.add("afterwards"); stopwords.add("again"); stopwords.add("against"); stopwords.add("all"); stopwords.add("almost"); stopwords.add("alone"); stopwords.add("along"); stopwords.add("already"); stopwords.add("also");stopwords.add("although");stopwords.add("always");stopwords.add("am");stopwords.add("among"); stopwords.add("amongst"); stopwords.add("amoungst"); stopwords.add("amount");  stopwords.add("an"); stopwords.add("and"); stopwords.add("another"); stopwords.add("any");stopwords.add("anyhow");stopwords.add("anyone");stopwords.add("anything");stopwords.add("anyway"); stopwords.add("anywhere"); stopwords.add("are"); stopwords.add("around"); stopwords.add("as");  stopwords.add("at"); stopwords.add("back");stopwords.add("be");stopwords.add("became"); stopwords.add("because");stopwords.add("become");stopwords.add("becomes"); stopwords.add("becoming"); stopwords.add("been"); stopwords.add("before"); stopwords.add("beforehand"); stopwords.add("behind"); stopwords.add("being"); stopwords.add("below"); stopwords.add("beside"); stopwords.add("besides"); stopwords.add("between"); stopwords.add("beyond"); stopwords.add("bill"); stopwords.add("both"); stopwords.add("bottom");stopwords.add("but"); stopwords.add("by"); stopwords.add("call"); stopwords.add("can"); stopwords.add("cannot"); stopwords.add("cant"); stopwords.add("co"); stopwords.add("con"); stopwords.add("could"); stopwords.add("couldnt"); stopwords.add("cry"); stopwords.add("de"); stopwords.add("describe"); stopwords.add("detail"); stopwords.add("do"); stopwords.add("done"); stopwords.add("down"); stopwords.add("due"); stopwords.add("during"); stopwords.add("each"); stopwords.add("eg"); stopwords.add("eight"); stopwords.add("either"); stopwords.add("eleven");stopwords.add("else"); stopwords.add("elsewhere"); stopwords.add("empty"); stopwords.add("enough"); stopwords.add("etc"); stopwords.add("even"); stopwords.add("ever"); stopwords.add("every"); stopwords.add("everyone"); stopwords.add("everything"); stopwords.add("everywhere"); stopwords.add("except"); stopwords.add("few"); stopwords.add("fifteen"); stopwords.add("fify"); stopwords.add("fill"); stopwords.add("find"); stopwords.add("fire"); stopwords.add("first"); stopwords.add("five"); stopwords.add("for"); stopwords.add("former"); stopwords.add("formerly"); stopwords.add("forty"); stopwords.add("found"); stopwords.add("four"); stopwords.add("from"); stopwords.add("front"); stopwords.add("full"); stopwords.add("further"); stopwords.add("get"); stopwords.add("give"); stopwords.add("go"); stopwords.add("had"); stopwords.add("has"); stopwords.add("hasnt"); stopwords.add("have"); stopwords.add("he"); stopwords.add("hence"); stopwords.add("her"); stopwords.add("here"); stopwords.add("hereafter"); stopwords.add("hereby"); stopwords.add("herein"); stopwords.add("hereupon"); stopwords.add("hers"); stopwords.add("herself"); stopwords.add("him"); stopwords.add("himself"); stopwords.add("his"); stopwords.add("how"); stopwords.add("however"); stopwords.add("hundred"); stopwords.add("ie"); stopwords.add("if"); stopwords.add("in"); stopwords.add("inc"); stopwords.add("indeed"); stopwords.add("interest"); stopwords.add("into"); stopwords.add("is"); stopwords.add("it"); stopwords.add("its"); stopwords.add("itself"); stopwords.add("keep"); stopwords.add("last"); stopwords.add("latter"); stopwords.add("latterly"); stopwords.add("least"); stopwords.add("less"); stopwords.add("ltd"); stopwords.add("made"); stopwords.add("many"); stopwords.add("may"); stopwords.add("me"); stopwords.add("meanwhile"); stopwords.add("might"); stopwords.add("mill"); stopwords.add("mine"); stopwords.add("more"); stopwords.add("moreover"); stopwords.add("most"); stopwords.add("mostly"); stopwords.add("move"); stopwords.add("much"); stopwords.add("must"); stopwords.add("my"); stopwords.add("myself"); stopwords.add("name"); stopwords.add("namely"); stopwords.add("neither"); stopwords.add("never"); stopwords.add("nevertheless"); stopwords.add("next"); stopwords.add("nine"); stopwords.add("no"); stopwords.add("nobody"); stopwords.add("none"); stopwords.add("noone"); stopwords.add("nor"); stopwords.add("not"); stopwords.add("nothing"); stopwords.add("now"); stopwords.add("nowhere"); stopwords.add("of"); stopwords.add("off"); stopwords.add("often"); stopwords.add("on"); stopwords.add("once"); stopwords.add("one"); stopwords.add("only"); stopwords.add("onto"); stopwords.add("or"); stopwords.add("other"); stopwords.add("others"); stopwords.add("otherwise"); stopwords.add("our"); stopwords.add("ours"); stopwords.add("ourselves"); stopwords.add("out"); stopwords.add("over"); stopwords.add("own");stopwords.add("part"); stopwords.add("per"); stopwords.add("perhaps"); stopwords.add("please"); stopwords.add("put"); stopwords.add("rather"); stopwords.add("re"); stopwords.add("same"); stopwords.add("see"); stopwords.add("seem"); stopwords.add("seemed"); stopwords.add("seeming"); stopwords.add("seems"); stopwords.add("serious"); stopwords.add("several"); stopwords.add("she"); stopwords.add("should"); stopwords.add("show"); stopwords.add("side"); stopwords.add("since"); stopwords.add("sincere"); stopwords.add("six"); stopwords.add("sixty"); stopwords.add("so"); stopwords.add("some"); stopwords.add("somehow"); stopwords.add("someone"); stopwords.add("something"); stopwords.add("sometime"); stopwords.add("sometimes"); stopwords.add("somewhere"); stopwords.add("still"); stopwords.add("such"); stopwords.add("system"); stopwords.add("take"); stopwords.add("ten"); stopwords.add("than"); stopwords.add("that"); stopwords.add("the"); stopwords.add("their"); stopwords.add("them"); stopwords.add("themselves"); stopwords.add("then"); stopwords.add("thence"); stopwords.add("there"); stopwords.add("thereafter"); stopwords.add("thereby"); stopwords.add("therefore"); stopwords.add("therein"); stopwords.add("thereupon"); stopwords.add("these"); stopwords.add("they"); stopwords.add("thickv"); stopwords.add("thin"); stopwords.add("third"); stopwords.add("this"); stopwords.add("those"); stopwords.add("though"); stopwords.add("three"); stopwords.add("through"); stopwords.add("throughout"); stopwords.add("thru"); stopwords.add("thus"); stopwords.add("to"); stopwords.add("together"); stopwords.add("too"); stopwords.add("top"); stopwords.add("toward"); stopwords.add("towards"); stopwords.add("twelve"); stopwords.add("twenty"); stopwords.add("two"); stopwords.add("un"); stopwords.add("under"); stopwords.add("until"); stopwords.add("up"); stopwords.add("upon"); stopwords.add("us"); stopwords.add("very"); stopwords.add("via"); stopwords.add("was"); stopwords.add("we"); stopwords.add("well"); stopwords.add("were"); stopwords.add("what"); stopwords.add("whatever"); stopwords.add("when"); stopwords.add("whence"); stopwords.add("whenever"); stopwords.add("where"); stopwords.add("whereafter"); stopwords.add("whereas"); stopwords.add("whereby"); stopwords.add("wherein"); stopwords.add("whereupon"); stopwords.add("wherever"); stopwords.add("whether"); stopwords.add("which"); stopwords.add("while"); stopwords.add("whither"); stopwords.add("who"); stopwords.add("whoever"); stopwords.add("whole"); stopwords.add("whom"); stopwords.add("whose"); stopwords.add("why"); stopwords.add("will"); stopwords.add("with"); stopwords.add("within"); stopwords.add("without"); stopwords.add("would"); stopwords.add("yet"); stopwords.add("you"); stopwords.add("your"); stopwords.add("yours"); stopwords.add("yourself"); stopwords.add("yourselves"); stopwords.add("thestopwords.add(");
	}
	public void preprocess (String filename, String folder){
		try {
			System.out.println("***");
			System.out.println(filename);
			System.out.println("***");
		String file = filename + ".processed";
	    Scanner scan = new Scanner(new File(filename));
	    BufferedWriter writer = new BufferedWriter(new FileWriter(file));

	    String[] line;
	    String word;
	    //Read File Line By Line
	    while (scan.hasNextLine() )   {
		    line = scan.nextLine().split("\\s+");
		    
		    for (int i = 0; i < line.length; ++i){
			    word = line[i];

			    // If this word isn't a stop word..
			    if (!stopwords.contains(word.toLowerCase())){
				    writer.write(word);
				    writer.write(" ");
			    }
		    }

		    writer.write("\n");
	    }
	    //Close the input stream
	    writer.close();
	    }catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }
	}

	public static void main(String args[]){
		Preprocessor doitTony = new Preprocessor();
		//doitTony.preprocess("/Users/joe/AI2010_Genre/AISongLyrics/ClassicRock/A World Without Heroes- Kiss.txt");
		doitTony.removeStopWords(new File("AISongLyrics"));
	}

	public void removeStopWords(File dir) {
		File[] genreFolders = dir.listFiles(); //Array of genre folders
		System.out.println(genreFolders);

		for (int i = 0; i < genreFolders.length; ++i){
			File genre = new File("Songs_Processed/" + genreFolders[i]);
			for (File file: genreFolders[i].listFiles()) {//For eachfile in the genre folder...
				preprocess(file.getAbsolutePath(), genreFolders[i].getAbsolutePath());
			}
		}
	}
}
