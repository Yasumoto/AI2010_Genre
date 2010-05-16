#!/bin/sh
FILES="$@"
find *.txt -print| while read f
do
	echo "Formatting ${f}..."
	java Format "${f}"
done
