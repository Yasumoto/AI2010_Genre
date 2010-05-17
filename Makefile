CLASSPATH=~/AI2010_Genre/cls

all:
	rm -f $(CLASSPATH)/com/bjoli/genre/*.class && javac -d $(CLASSPATH) src/com/bjoli/genre/*.java && java -classpath $(CLASSPATH) com.bjoli.genre.GraphicalFrame
