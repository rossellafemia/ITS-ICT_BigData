#!/usr/bin/python

import sys
for line in sys.stdin: # Input takes from standard input
    line = line.strip() # Remove whitespace either side


    #print (line)
    fields = line.split(",")    
    print '%s\t%s' % (fields[0], fields[1])