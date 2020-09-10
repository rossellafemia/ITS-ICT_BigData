dataset = LOAD 'lab9_input/students.csv' USING PigStorage(',')
   as (name:chararray, gpa:int);
group_data = GROUP dataset by SUBSTRING(name, 0, 1);
result = foreach group_data generate group, SUM(dataset.gpa);  
dump result;