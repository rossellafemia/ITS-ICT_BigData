# MapReduce using Python


## Test locally


```console
$ cat ../input/sunnyvale_pv_energy_production.csv | ./mapper.py | ./reducer.py 
16/07/16        36492
```


## Submit to Hadoop cluster

Create the input folder on HDFS:

```console
[vagrant@node1 Python]$ hadoop fs -mkdir streaming_input
```

Load the dataset file into the HDFS input folder:

```console
[vagrant@node1 Python]$ hadoop fs -put /home/vagrant/ITS-ICT_BigData/datasets/sunnyvale_pv_energy_production.csv streaming_input
```

Verify that the file has been loaded to HDFS

```console
[vagrant@node1 Python]$ hadoop fs -ls streaming_input
Found 1 items
-rw-r--r--   3 vagrant hdfs     116320 2020-07-13 20:38 streaming_input/sunnyvale_pv_energy_production.csv
```

Remove the output folder (if it exists)

```console
[vagrant@node1 Python]$ hadoop fs -rm -r -f streaming_output
```


Submit the MapReduce job 


```console
[vagrant@node1 Python]$ hadoop jar /usr/hdp/*/hadoop-mapreduce/hadoop-streaming.jar \
    -input streaming_input/sunnyvale_pv_energy_production.csv \
    -output streaming_output \
    -mapper "python mapper.py" \
    -reducer "python reducer.py" \
    -file ./mapper.py \
    -file ./reducer.py
packageJobJar: [./mapper.py, ./reducer.py] [/usr/hdp/3.1.0.0-78/hadoop-mapreduce/hadoop-streaming-3.1.1.3.1.0.0-78.jar] /tmp/streamjob5180293500150458985.jar tmpDir=null
20/07/20 09:23:40 INFO client.RMProxy: Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
20/07/20 09:23:40 INFO client.AHSProxy: Connecting to Application History server at node2.example.com/192.168.199.3:10200
20/07/20 09:23:40 INFO client.RMProxy: Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
20/07/20 09:23:40 INFO client.AHSProxy: Connecting to Application History server at node2.example.com/192.168.199.3:10200
20/07/20 09:23:40 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/vagrant/.staging/job_1595233114793_0006
20/07/20 09:23:41 INFO mapred.FileInputFormat: Total input files to process : 1
20/07/20 09:23:41 INFO mapreduce.JobSubmitter: number of splits:2
20/07/20 09:23:42 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1595233114793_0006
20/07/20 09:23:42 INFO mapreduce.JobSubmitter: Executing with tokens: []
20/07/20 09:23:42 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.0.0-78/0/resource-types.xml
20/07/20 09:23:42 INFO impl.YarnClientImpl: Submitted application application_1595233114793_0006
20/07/20 09:23:43 INFO mapreduce.Job: The url to track the job: http://node1.example.com:8088/proxy/application_1595233114793_0006/
20/07/20 09:23:43 INFO mapreduce.Job: Running job: job_1595233114793_0006
20/07/20 09:23:53 INFO mapreduce.Job: Job job_1595233114793_0006 running in uber mode : false
20/07/20 09:23:53 INFO mapreduce.Job:  map 0% reduce 0%
20/07/20 09:24:02 INFO mapreduce.Job:  map 100% reduce 0%
20/07/20 09:24:10 INFO mapreduce.Job:  map 100% reduce 100%
20/07/20 09:24:11 INFO mapreduce.Job: Job job_1595233114793_0006 completed successfully
20/07/20 09:24:12 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=24615
                FILE: Number of bytes written=757436
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=174770
                HDFS: Number of bytes written=15
                HDFS: Number of read operations=11
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=2
                Launched reduce tasks=1
                Data-local map tasks=2
                Total time spent by all maps in occupied slots (ms)=13205
                Total time spent by all reduces in occupied slots (ms)=11936
                Total time spent by all map tasks (ms)=13205
                Total time spent by all reduce tasks (ms)=5968
                Total vcore-milliseconds taken by all map tasks=13205
                Total vcore-milliseconds taken by all reduce tasks=5968
                Total megabyte-milliseconds taken by all map tasks=6760960
                Total megabyte-milliseconds taken by all reduce tasks=6111232
        Map-Reduce Framework
                Map input records=1467
                Map output records=1467
                Map output bytes=21675
                Map output materialized bytes=24621
                Input split bytes=290
                Combine input records=0
                Combine output records=0
                Reduce input groups=1467
                Reduce shuffle bytes=24621
                Reduce input records=1467
                Reduce output records=1
                Spilled Records=2934
                Shuffled Maps =2
                Failed Shuffles=0
                Merged Map outputs=2
                GC time elapsed (ms)=854
                CPU time spent (ms)=4690
                Physical memory (bytes) snapshot=523771904
                Virtual memory (bytes) snapshot=7523721216
                Total committed heap usage (bytes)=221249536
                Peak Map Physical memory (bytes)=182345728
                Peak Map Virtual memory (bytes)=2347700224
                Peak Reduce Physical memory (bytes)=171872256
                Peak Reduce Virtual memory (bytes)=2828783616
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=174480
        File Output Format Counters 
                Bytes Written=15
20/07/20 09:24:12 INFO streaming.StreamJob: Output directory: streaming_output
```
Check the output

```console
[vagrant@node1 Python]$ hadoop fs -ls streaming_output/
Found 2 items
-rw-r--r--   3 vagrant hdfs          0 2020-07-20 09:24 streaming_output/_SUCCESS
-rw-r--r--   3 vagrant hdfs         15 2020-07-20 09:24 streaming_output/part-00000
```

Display the output

```console
[vagrant@node1 Python]$ hadoop fs -cat streaming_output/part-00000
16/07/16        36492
```