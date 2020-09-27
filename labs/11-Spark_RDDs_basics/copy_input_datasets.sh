#!/bin/bash -x
hadoop fs -mkdir -p lab11_input
for file in $(ls -1 lab11_input/*); 
do
    hadoop fs -put $(readlink -f $file) lab11_input
done