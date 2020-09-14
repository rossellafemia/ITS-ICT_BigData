#  COVID pandemic insight with MapReduce

## Purpose 

Given the dataset [dpc-covid19-ita-regioni.csv](../../datasets/dpc-covid19-ita-regioni.csv), containing data about the new Coronavirus infections in Italy split by regions from February 2020, here's the MapReduce code to find out the sum of new infections per day ( **select sum(nuovi_positivi) group by data**). 

Normally this task would:

- Take a lot of time to execute.                                                                      
- Cause heavy network traffic when we move data from source to network server and so on.
                                                                      
To solve these problems, we have the MapReduce framework.

## Prerequisites

- JDK 1.8 
- IntelliJ Idea Community Edition (or any other Java IDE)
- Maven

## Test locally

Clean and compile the application

```console
$ mvn clean && mvn compile
...
```
Run a local test

```console
$ mvn exec:java 
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------< it.sunnyvale.hadoop.labs:covid-infection-by-days >----------
[INFO] Building covid-infection-by-days 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ covid-infection-by-days ---
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.hadoop.security.authentication.util.KerberosUtil (file:/Users/denismaggiorotto/.m2/repository/org/apache/hadoop/hadoop-core/1.2.1/hadoop-core-1.2.1.jar) to method sun.security.krb5.Config.getInstance()
WARNING: Please consider reporting this to the maintainers of org.apache.hadoop.security.authentication.util.KerberosUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
20/09/07 00:35:46 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
20/09/07 00:35:46 WARN mapred.JobClient: Use GenericOptionsParser for parsing the arguments. Applications should implement Tool for the same.
20/09/07 00:35:46 WARN mapred.JobClient: No job jar file set.  User classes may not be found. See JobConf(Class) or JobConf#setJar(String).
20/09/07 00:35:47 INFO input.FileInputFormat: Total input paths to process : 1
20/09/07 00:35:47 WARN snappy.LoadSnappy: Snappy native library not loaded
20/09/07 00:35:47 INFO mapred.JobClient: Running job: job_local1398272941_0001
20/09/07 00:35:47 INFO mapred.LocalJobRunner: Waiting for map tasks
20/09/07 00:35:47 INFO mapred.LocalJobRunner: Starting task: attempt_local1398272941_0001_m_000000_0
20/09/07 00:35:47 INFO mapred.Task:  Using ResourceCalculatorPlugin : null
20/09/07 00:35:47 INFO mapred.MapTask: Processing split: file:/Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/input/dpc-covid19-ita-regioni.csv:0+487277
20/09/07 00:35:47 INFO mapred.MapTask: io.sort.mb = 100
20/09/07 00:35:47 INFO mapred.MapTask: data buffer = 79691776/99614720
20/09/07 00:35:47 INFO mapred.MapTask: record buffer = 262144/327680
20/09/07 00:35:47 INFO mapred.MapTask: Starting flush of map output
20/09/07 00:35:47 INFO mapred.MapTask: Finished spill 0
20/09/07 00:35:47 INFO mapred.Task: Task:attempt_local1398272941_0001_m_000000_0 is done. And is in the process of commiting
20/09/07 00:35:47 INFO mapred.LocalJobRunner: 
20/09/07 00:35:47 INFO mapred.Task: Task 'attempt_local1398272941_0001_m_000000_0' done.
20/09/07 00:35:47 INFO mapred.LocalJobRunner: Finishing task: attempt_local1398272941_0001_m_000000_0
20/09/07 00:35:47 INFO mapred.LocalJobRunner: Map task executor complete.
20/09/07 00:35:47 INFO mapred.Task:  Using ResourceCalculatorPlugin : null
20/09/07 00:35:47 INFO mapred.LocalJobRunner: 
20/09/07 00:35:47 INFO mapred.Merger: Merging 1 sorted segments
20/09/07 00:35:47 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 5046 bytes
20/09/07 00:35:47 INFO mapred.LocalJobRunner: 
20/09/07 00:35:47 INFO mapred.Task: Task:attempt_local1398272941_0001_r_000000_0 is done. And is in the process of commiting
20/09/07 00:35:47 INFO mapred.LocalJobRunner: 
20/09/07 00:35:47 INFO mapred.Task: Task attempt_local1398272941_0001_r_000000_0 is allowed to commit now
20/09/07 00:35:47 INFO output.FileOutputCommitter: Saved output of task 'attempt_local1398272941_0001_r_000000_0' to output
20/09/07 00:35:47 INFO mapred.LocalJobRunner: reduce > reduce
20/09/07 00:35:47 INFO mapred.Task: Task 'attempt_local1398272941_0001_r_000000_0' done.
20/09/07 00:35:48 INFO mapred.JobClient:  map 100% reduce 100%
20/09/07 00:35:48 INFO mapred.JobClient: Job complete: job_local1398272941_0001
20/09/07 00:35:48 INFO mapred.JobClient: Counters: 17
20/09/07 00:35:48 INFO mapred.JobClient:   Map-Reduce Framework
20/09/07 00:35:48 INFO mapred.JobClient:     Spilled Records=388
20/09/07 00:35:48 INFO mapred.JobClient:     Map output materialized bytes=5050
20/09/07 00:35:48 INFO mapred.JobClient:     Reduce input records=194
20/09/07 00:35:48 INFO mapred.JobClient:     Map input records=4075
20/09/07 00:35:48 INFO mapred.JobClient:     SPLIT_RAW_BYTES=288
20/09/07 00:35:48 INFO mapred.JobClient:     Map output bytes=97776
20/09/07 00:35:48 INFO mapred.JobClient:     Reduce shuffle bytes=0
20/09/07 00:35:48 INFO mapred.JobClient:     Reduce input groups=194
20/09/07 00:35:48 INFO mapred.JobClient:     Combine output records=194
20/09/07 00:35:48 INFO mapred.JobClient:     Reduce output records=194
20/09/07 00:35:48 INFO mapred.JobClient:     Map output records=4074
20/09/07 00:35:48 INFO mapred.JobClient:     Combine input records=4074
20/09/07 00:35:48 INFO mapred.JobClient:     Total committed heap usage (bytes)=408944640
20/09/07 00:35:48 INFO mapred.JobClient:   File Input Format Counters 
20/09/07 00:35:48 INFO mapred.JobClient:     Bytes Read=487277
20/09/07 00:35:48 INFO mapred.JobClient:   FileSystemCounters
20/09/07 00:35:48 INFO mapred.JobClient:     FILE_BYTES_WRITTEN=118540
20/09/07 00:35:48 INFO mapred.JobClient:     FILE_BYTES_READ=980294
20/09/07 00:35:48 INFO mapred.JobClient:   File Output Format Counters 
20/09/07 00:35:48 INFO mapred.JobClient:     Bytes Written=4776

```

Check the result

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

## Submit to Hadoop cluster

If not already up and running, start the lab environment

```console
$ cd ../02-Provision_the_environment/Vagrant  
$ vagrant up
```

Services must be running as well, please refer to the image below:

![Services](img/3-nodes/cluster_services.png)

Log into the **node1** machine

```console
$ vagrant ssh node1
```

```console
[vagrant@node1 ~]$ cd ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java
```

Submit the job to a Hadoop cluster

Create the JAR file

```console
[vagrant@node1 solution]$ mvn package
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------< it.sunnyvale.hadoop.labs:covid-infection-by-days >----------
[INFO] Building covid-infection-by-days 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ covid-infection-by-days ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ covid-infection-by-days ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/target/classes
[WARNING] /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/src/main/java/it/sunnyvale/hadoop/labs/NewInfections.java: /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/src/main/java/it/sunnyvale/hadoop/labs/NewInfections.java uses unchecked or unsafe operations.
[WARNING] /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/src/main/java/it/sunnyvale/hadoop/labs/NewInfections.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ covid-infection-by-days ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ covid-infection-by-days ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ covid-infection-by-days ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ covid-infection-by-days ---
[INFO] Building jar: /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/target/covid-infection-by-days-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.005 s
[INFO] Finished at: 2020-09-07T00:50:06+02:00
[INFO] ------------------------------------------------------------------------
```



Create the input folder on HDFS:

```console
[vagrant@node1 ~]$ hadoop fs -mkdir ass2_input
```

Load the dataset file into the HDFS input folder:

```console
[vagrant@node1 ~]$ hadoop fs -put /home/vagrant/ITS-ICT_BigData/datasets/dpc-covid19-ita-regioni.csv ass2_input
```

Verify that the file has been loaded to HDFS

```console
[vagrant@node1 ~]$ hadoop fs -ls ass2_input
Found 1 items
-rw-r--r--   3 vagrant hdfs        218 2020-07-13 10:32 ass2_input/dpc-covid19-ita-regioni.csv
```

Submit the MapReduce job using YARN

```console
[vagrant@node1 ~]$ yarn jar /home/vagrant/ITS-ICT_BigData/assignments/02-COVID_pandemic_insight_with_MapReduce/solution/Java/target/covid-infection-by-days-1.0-SNAPSHOT.jar it.sunnyvale.hadoop.labs.NewInfections ass2_input ass2_output 
20/09/07 09:30:47 INFO client.RMProxy: Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
20/09/07 09:30:47 INFO client.AHSProxy: Connecting to Application History server at node2.example.com/192.168.199.3:10200
20/09/07 09:30:48 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
20/09/07 09:30:48 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599467673877_0005
20/09/07 09:30:48 INFO input.FileInputFormat: Total input files to process : 1
20/09/07 09:30:48 INFO mapreduce.JobSubmitter: number of splits:1
20/09/07 09:30:49 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1599467673877_0005
20/09/07 09:30:49 INFO mapreduce.JobSubmitter: Executing with tokens: []
20/09/07 09:30:49 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.0.0-78/0/resource-types.xml
20/09/07 09:30:50 INFO impl.YarnClientImpl: Submitted application application_1599467673877_0005
20/09/07 09:30:50 INFO mapreduce.Job: The url to track the job: http://node1.example.com:8088/proxy/application_1599467673877_0005/
20/09/07 09:30:50 INFO mapreduce.Job: Running job: job_1599467673877_0005
20/09/07 09:31:00 INFO mapreduce.Job: Job job_1599467673877_0005 running in uber mode : false
20/09/07 09:31:00 INFO mapreduce.Job:  map 0% reduce 0%
20/09/07 09:31:09 INFO mapreduce.Job:  map 100% reduce 0%
20/09/07 09:31:19 INFO mapreduce.Job:  map 100% reduce 100%
20/09/07 09:31:19 INFO mapreduce.Job: Job job_1599467673877_0005 completed successfully
20/09/07 09:31:19 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=5050
                FILE: Number of bytes written=474685
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=487423
                HDFS: Number of bytes written=4728
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=6195
                Total time spent by all reduces in occupied slots (ms)=11878
                Total time spent by all map tasks (ms)=6195
                Total time spent by all reduce tasks (ms)=5939
                Total vcore-milliseconds taken by all map tasks=6195
                Total vcore-milliseconds taken by all reduce tasks=5939
                Total megabyte-milliseconds taken by all map tasks=3171840
                Total megabyte-milliseconds taken by all reduce tasks=6081536
        Map-Reduce Framework
                Map input records=4075
                Map output records=4074
                Map output bytes=97776
                Map output materialized bytes=5050
                Input split bytes=146
                Combine input records=4074
                Combine output records=194
                Reduce input groups=194
                Reduce shuffle bytes=5050
                Reduce input records=194
                Reduce output records=194
                Spilled Records=388
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=406
                CPU time spent (ms)=2430
                Physical memory (bytes) snapshot=648679424
                Virtual memory (bytes) snapshot=5168705536
                Total committed heap usage (bytes)=470810624
                Peak Map Physical memory (bytes)=442920960
                Peak Map Virtual memory (bytes)=2346389504
                Peak Reduce Physical memory (bytes)=205758464
                Peak Reduce Virtual memory (bytes)=2822316032
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=487277
        File Output Format Counters 
                Bytes Written=4728
```

Verify the output

```console
[vagrant@node1 ~]$ hadoop fs -ls ass2_output
Found 2 items
-rw-r--r--   3 vagrant hdfs          0 2020-09-01 10:37 ass2_output/_SUCCESS
-rw-r--r--   3 vagrant hdfs         24 2020-09-01 10:37 ass2_output/part-r-00000
```

Display the output file:

```console
[vagrant@node1 ~]$ hadoop fs -cat ass2_output/part-r-00000
...
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

