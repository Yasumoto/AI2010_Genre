CLASSPATH=~/AI2010_Genre/cls


preprocessor:
	rm -f $(CLASSPATH)/com/bjoli/genre/*.class && javac -d $(CLASSPATH) src/com/bjoli/genre/*.java && java -classpath $(CLASSPATH) com.bjoli.genre.Preprocessor

classifier:
	rm -f $(CLASSPATH)/com/bjoli/genre/*.class && javac -d $(CLASSPATH) src/com/bjoli/genre/*.java && java -classpath $(CLASSPATH) com.bjoli.genre.Classifier

GraphicalFrame:
	rm -f $(CLASSPATH)/com/bjoli/genre/*.class && javac -d $(CLASSPATH) src/com/bjoli/genre/*.java && java -classpath $(CLASSPATH) com.bjoli.genre.GraphicalFrame
