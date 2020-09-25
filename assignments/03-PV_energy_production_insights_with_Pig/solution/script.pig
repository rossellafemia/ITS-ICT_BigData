dataset = LOAD 'ass3_input/sunnyvale_pv_energy_production.csv' USING PigStorage(',')
   as (day:chararray, energy:int);
dataset_ordered = ORDER dataset BY energy DESC;
dataset_ordered_limited = LIMIT dataset_ordered 1;  
dump dataset_ordered_limited;
