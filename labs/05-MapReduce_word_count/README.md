# MapReduce word count

## Prerequisites

This lab references hosts, users, paths and other details that belong to the [Vagrant-provisioned 3 nodes Hadoop cluster](../02-Provision_the_environment/Vagrant/README.md).

The [Vagrant-provisioned 3 nodes Hadoop cluster](../02-Provision_the_environment/Vagrant/README.md) should have been started before executing this lab.

Also, all the cluster services must be started as show in the picture below: 

![Cluster services](./img/3-nodes/cluster_services.png)

It is possible to run this lab in any other environment (i.e.: Hortonworks Sandbox or Cloudera DataFlow) provided some small changes to the elements listed above.

Lab [03 - HFDS_file_upload_using_CLI](../03-03-HFDS_file_upload_using_CLI/README.md) must be completed BEFORE this one.

## Run the MapReduce word count example

### Upload a file to HDFS

Go to path **ITS-ICT_BigData/labs/02-Provision_the_environment/Vagrant** and connect to node 1.

```console
$ vagrant ssh node1 
[vagrant@node1 ~]$ 
```

Now, load on HDFS the file **constitution.txt** from the dataset folder of this repo

```console
[vagrant@node1 ~]$ hadoop fs -put /home/vagrant/ITS-ICT_BigData/datasets/constitution.txt /hdfs-dir/constitution.txt
[vagrant@node1 ~]$
```

To verify the file upload, just type:


```console
[vagrant@node1 ~]$ hadoop fs -ls /hdfs-dir
Found 2 items
-rw-r--r--   3 vagrant vagrant      44840 2020-06-23 23:22 /hdfs-dir/constitution.txt
-rw-r--r--   3 vagrant vagrant   16257213 2020-06-19 08:45 /hdfs-dir/salaries.csv
```

For now, forget about **salaries.csv** used in the previous lab and other files (if any), just verify the presence of **constitution.txt**.

Let's create the vagrant user's folder to store the word count output (if it doesn't exist already)

```
$ sudo -u hdfs hadoop fs -mkdir -p /user/vagrant
```

And assign it to vagrant user

```
$ sudo -u hdfs hadoop fs -chown vagrant /user/vagrant
```

MapReduce word count example comes pre-installed with Hadoop, to try it just type the following command and see the output

```console
[vagrant@node1 ~]$ yarn jar /usr/hdp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar 
An example program must be given as the first argument.
Valid program names are:
  aggregatewordcount: An Aggregate based map/reduce program that counts the words in the input files.
  aggregatewordhist: An Aggregate based map/reduce program that computes the histogram of the words in the input files.
  bbp: A map/reduce program that uses Bailey-Borwein-Plouffe to compute exact digits of Pi.
  dbcount: An example job that count the pageview counts from a database.
  distbbp: A map/reduce program that uses a BBP-type formula to compute exact bits of Pi.
  grep: A map/reduce program that counts the matches of a regex in the input.
  join: A job that effects a join over sorted, equally partitioned datasets
  multifilewc: A job that counts words from several files.
  pentomino: A map/reduce tile laying program to find solutions to pentomino problems.
  pi: A map/reduce program that estimates Pi using a quasi-Monte Carlo method.
  randomtextwriter: A map/reduce program that writes 10GB of random textual data per node.
  randomwriter: A map/reduce program that writes 10GB of random data per node.
  secondarysort: An example defining a secondary sort to the reduce.
  sort: A map/reduce program that sorts the data written by the random writer.
  sudoku: A sudoku solver.
  teragen: Generate data for the terasort
  terasort: Run the terasort
  teravalidate: Checking results of terasort
  wordcount: A map/reduce program that counts the words in the input files.
  wordmean: A map/reduce program that counts the average length of the words in the input files.
  wordmedian: A map/reduce program that counts the median length of the words in the input files.
  wordstandarddeviation: A map/reduce program that counts the standard deviation of the length of the words in the input files.
```

We will now focus on **wordcount: A map/reduce program that counts the words in the input files**

Modify than the previous command as per the following and launch it.

```console
[vagrant@node1 ~]$ yarn jar /usr/hdp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar wordcount /hdfs-dir/constitution.txt /user/vagrant/wordcount_output
```

Yarn will submit the jar to the single node where the constitution.txt file is stored as a single block (since it's smaller than 128MB).

After a couple of minutes, chances are you will get an error like the one reported below

```console
Failing this attempt.Diagnostics: [2020-06-23 23:47:28.394]Container [pid=24774,containerID=container_e01_1592954553047_0001_02_000001] is running 3432448B beyond the 'PHYSICAL' memory limit. Current usage: 173.3 MB of 170 MB physical memory used; 2.0 GB of 357.0 MB virtual memory used. Killing container.
```

This is normal since the default Hadoop cluster installation has reserved an amount of memory too low to successfully run the word count example.

To solve this, login into Ambari e perform the following adjustments:

- in the YARN configuration section, increase the **Minimum Container Size** to 256MB


Once saving the new configuration, Ambari prompts you some new better values, __DO NOT__ accept and continue.

Then, agree on restart all the services affected.

Once done, you may try to re-run the word count example:

```console
[vagrant@node1 ~]$ yarn jar /usr/hdp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar wordcount /hdfs-dir/constitution.txt /user/vagrant/wordcount_output
20/06/24 12:50:01 INFO client.RMProxy: Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
20/06/24 12:50:01 INFO client.AHSProxy: Connecting to Application History server at node2.example.com/192.168.199.3:10200
20/06/24 12:50:02 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/vagrant/.staging/job_1592994330442_0002
20/06/24 12:50:03 INFO input.FileInputFormat: Total input files to process : 1
20/06/24 12:50:03 INFO mapreduce.JobSubmitter: number of splits:1
20/06/24 12:50:04 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1592994330442_0002
20/06/24 12:50:04 INFO mapreduce.JobSubmitter: Executing with tokens: []
20/06/24 12:50:06 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.0.0-78/0/resource-types.xml
20/06/24 12:50:08 INFO impl.YarnClientImpl: Submitted application application_1592994330442_0002
20/06/24 12:50:08 INFO mapreduce.Job: The url to track the job: http://node1.example.com:8088/proxy/application_1592994330442_0002/
20/06/24 12:50:08 INFO mapreduce.Job: Running job: job_1592994330442_0002
20/06/24 12:50:50 INFO mapreduce.Job: Job job_1592994330442_0002 running in uber mode : false
20/06/24 12:50:50 INFO mapreduce.Job:  map 0% reduce 0%
20/06/24 12:51:10 INFO mapreduce.Job:  map 100% reduce 0%
20/06/24 12:51:52 INFO mapreduce.Job:  map 100% reduce 100%
20/06/24 12:51:55 INFO mapreduce.Job: Job job_1592994330442_0002 completed successfully
20/06/24 12:51:55 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=23646
                FILE: Number of bytes written=511433
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=44960
                HDFS: Number of bytes written=17031
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=16445
                Total time spent by all reduces in occupied slots (ms)=58192
                Total time spent by all map tasks (ms)=16445
                Total time spent by all reduce tasks (ms)=29096
                Total vcore-milliseconds taken by all map tasks=16445
                Total vcore-milliseconds taken by all reduce tasks=29096
                Total megabyte-milliseconds taken by all map tasks=4209920
                Total megabyte-milliseconds taken by all reduce tasks=14838960
        Map-Reduce Framework
                Map input records=865
                Map output records=7620
                Map output bytes=75154
                Map output materialized bytes=23646
                Input split bytes=120
                Combine input records=7620
                Combine output records=1680
                Reduce input groups=1680
                Reduce shuffle bytes=23646
                Reduce input records=1680
                Reduce output records=1680
                Spilled Records=3360
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=296
                CPU time spent (ms)=4930
                Physical memory (bytes) snapshot=229486592
                Virtual memory (bytes) snapshot=4281491456
                Total committed heap usage (bytes)=71827456
                Peak Map Physical memory (bytes)=114212864
                Peak Map Virtual memory (bytes)=2052620288
                Peak Reduce Physical memory (bytes)=115273728
                Peak Reduce Virtual memory (bytes)=2228871168
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=44840
        File Output Format Counters 
                Bytes Written=17031
```

As you can see the wordcount MapReduce example run successfully, it's time to inspect the output:

```
[vagrant@node1 ~]$ hadoop fs -ls /user/vagrant/wordcount_output
Found 2 items
-rw-r--r--   3 vagrant hdfs          0 2020-06-24 12:51 /user/vagrant/wordcount_output/_SUCCESS
-rw-r--r--   3 vagrant hdfs      17031 2020-06-24 12:51 /user/vagrant/wordcount_output/part-r-00000
```