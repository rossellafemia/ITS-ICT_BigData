#!/bin/bash -x
hadoop fs -mkdir -p lab12_input
hadoop fs -mkdir -p lab12_output
for file in $(ls -1 lab12_input/*); 
do
    hadoop fs -put $(readlink -f $file) lab12_input
done