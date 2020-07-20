#!/usr/bin/python

import sys 
from operator import itemgetter 

maxpower = 0
maxdate = ""

for line in sys.stdin:
    record = line.strip() 
    fields = record.split("\t")
    date = fields[0] 
    power = fields[1] 

    try: 
        power = int(power) 
    except ValueError: 
        # power was not a number, so silently ignore this line and continue
        continue


    if power > maxpower:
        maxpower = power
        maxdate = date

print '%s\t%s' % (maxdate, maxpower)