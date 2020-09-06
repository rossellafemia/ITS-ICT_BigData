# COVID pandemic insight with MapReduce

Given the file [dpc-covid19-ita-regioni.csv](../../datasets/dpc-covid19-ita-regioni.csv), containing data about the new Coronavirus infections in Italy split by regions from February 2020, code your MapReduce job to find out the sum of new infections per day ( **select sum(nuovi_positivi) group by data**). 

Take this simple output as a reference:

```console
$ cat output/part-r-00000 
2020-08-15T17:00:00     629
2020-08-16T17:00:00     479
2020-08-17T17:00:00     320
2020-08-18T17:00:00     403
2020-08-19T17:00:00     642
2020-08-20T17:00:00     845
2020-08-21T17:00:00     947
2020-08-22T17:00:00     1071
2020-08-23T17:00:00     1210
2020-08-24T17:00:00     953
2020-08-25T17:00:00     878
2020-08-26T17:00:00     1367
2020-08-27T17:00:00     1411
2020-08-28T17:00:00     1462
2020-08-29T17:00:00     1444
2020-08-30T17:00:00     1365
2020-08-31T17:00:00     996
2020-09-01T17:00:00     978
2020-09-02T17:00:00     1326
2020-09-03T17:00:00     1397
2020-09-04T17:00:00     1733
```

