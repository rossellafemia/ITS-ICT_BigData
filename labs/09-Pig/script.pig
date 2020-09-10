dataset = LOAD 'lab9_input/students.csv' USING PigStorage(',')
   as (name:chararray, gpa:int);
dataset_ordered = ORDER dataset BY gpa DESC;
dataset_ordered_limited = LIMIT dataset_ordered 1;  
dump dataset_ordered_limited;