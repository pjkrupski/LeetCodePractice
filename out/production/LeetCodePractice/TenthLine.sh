# Read from the file file.txt and output the tenth line to stdout.
#head -n 10 file.txt | tail -n 1  if file isnt long enough this 
#will return the last line which is incorrect
sed '10!d' file.txt
