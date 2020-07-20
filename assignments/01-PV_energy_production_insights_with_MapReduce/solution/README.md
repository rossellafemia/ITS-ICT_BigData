# PV energy production insights with MapReduce

## Prerequisites

- JDK 1.8 
- Maven

## Test locally

Run a local test

```console
$ mvn exec:java
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.hadoop.security.authentication.util.KerberosUtil (file:/Users/denismaggiorotto/.m2/repository/org/apache/hadoop/hadoop-core/1.2.1/hadoop-core-1.2.1.jar) to method sun.security.krb5.Config.getInstance()
WARNING: Please consider reporting this to the maintainers of org.apache.hadoop.security.authentication.util.KerberosUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
20/07/13 22:25:03 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
20/07/13 22:25:03 WARN mapred.JobClient: Use GenericOptionsParser for parsing the arguments. Applications should implement Tool for the same.
20/07/13 22:25:03 WARN mapred.JobClient: No job jar file set.  User classes may not be found. See JobConf(Class) or JobConf#setJar(String).
20/07/13 22:25:03 INFO input.FileInputFormat: Total input paths to process : 1
20/07/13 22:25:03 WARN snappy.LoadSnappy: Snappy native library not loaded
20/07/13 22:25:03 INFO mapred.JobClient: Running job: job_local708762629_0001
20/07/13 22:25:03 INFO mapred.LocalJobRunner: Waiting for map tasks
20/07/13 22:25:03 INFO mapred.LocalJobRunner: Starting task: attempt_local708762629_0001_m_000000_0
20/07/13 22:25:03 INFO mapred.Task:  Using ResourceCalculatorPlugin : null
20/07/13 22:25:03 INFO mapred.MapTask: Processing split: file:/Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/01-PV_energy_production_insights_with_MapReduce/solution/input/sunnyvale_pv_energy_production.csv:0+116320
20/07/13 22:25:03 INFO mapred.MapTask: io.sort.mb = 100
20/07/13 22:25:04 INFO mapred.MapTask: data buffer = 79691776/99614720
20/07/13 22:25:04 INFO mapred.MapTask: record buffer = 262144/327680
20/07/13 22:25:04 INFO mapred.MapTask: Starting flush of map output
20/07/13 22:25:04 INFO mapred.MapTask: Finished spill 0
20/07/13 22:25:04 INFO mapred.Task: Task:attempt_local708762629_0001_m_000000_0 is done. And is in the process of commiting
20/07/13 22:25:04 INFO mapred.LocalJobRunner: 
20/07/13 22:25:04 INFO mapred.Task: Task 'attempt_local708762629_0001_m_000000_0' done.
20/07/13 22:25:04 INFO mapred.LocalJobRunner: Finishing task: attempt_local708762629_0001_m_000000_0
20/07/13 22:25:04 INFO mapred.LocalJobRunner: Map task executor complete.
20/07/13 22:25:04 INFO mapred.Task:  Using ResourceCalculatorPlugin : null
20/07/13 22:25:04 INFO mapred.LocalJobRunner: 
20/07/13 22:25:04 INFO mapred.Merger: Merging 1 sorted segments
20/07/13 22:25:04 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 14662 bytes
20/07/13 22:25:04 INFO mapred.LocalJobRunner: 
20/07/13 22:25:04 INFO mapred.Task: Task:attempt_local708762629_0001_r_000000_0 is done. And is in the process of commiting
20/07/13 22:25:04 INFO mapred.LocalJobRunner: 
20/07/13 22:25:04 INFO mapred.Task: Task attempt_local708762629_0001_r_000000_0 is allowed to commit now
20/07/13 22:25:04 INFO output.FileOutputCommitter: Saved output of task 'attempt_local708762629_0001_r_000000_0' to output
20/07/13 22:25:04 INFO mapred.LocalJobRunner: reduce > reduce
20/07/13 22:25:04 INFO mapred.Task: Task 'attempt_local708762629_0001_r_000000_0' done.
20/07/13 22:25:04 INFO mapred.JobClient:  map 100% reduce 100%
20/07/13 22:25:04 INFO mapred.JobClient: Job complete: job_local708762629_0001
20/07/13 22:25:04 INFO mapred.JobClient: Counters: 17
20/07/13 22:25:04 INFO mapred.JobClient:   Map-Reduce Framework
20/07/13 22:25:04 INFO mapred.JobClient:     Spilled Records=2932
20/07/13 22:25:04 INFO mapred.JobClient:     Map output materialized bytes=14666
20/07/13 22:25:04 INFO mapred.JobClient:     Reduce input records=1466
20/07/13 22:25:04 INFO mapred.JobClient:     Map input records=1467
20/07/13 22:25:04 INFO mapred.JobClient:     SPLIT_RAW_BYTES=297
20/07/13 22:25:04 INFO mapred.JobClient:     Map output bytes=19058
20/07/13 22:25:04 INFO mapred.JobClient:     Reduce shuffle bytes=0
20/07/13 22:25:04 INFO mapred.JobClient:     Reduce input groups=1
20/07/13 22:25:04 INFO mapred.JobClient:     Combine output records=1466
20/07/13 22:25:04 INFO mapred.JobClient:     Reduce output records=1
20/07/13 22:25:04 INFO mapred.JobClient:     Map output records=1466
20/07/13 22:25:04 INFO mapred.JobClient:     Combine input records=1466
20/07/13 22:25:04 INFO mapred.JobClient:     Total committed heap usage (bytes)=408944640
20/07/13 22:25:04 INFO mapred.JobClient:   File Input Format Counters 
20/07/13 22:25:04 INFO mapred.JobClient:     Bytes Read=116320
20/07/13 22:25:04 INFO mapred.JobClient:   FileSystemCounters
20/07/13 22:25:04 INFO mapred.JobClient:     FILE_BYTES_WRITTEN=133108
20/07/13 22:25:04 INFO mapred.JobClient:     FILE_BYTES_READ=248014
20/07/13 22:25:04 INFO mapred.JobClient:   File Output Format Counters 
20/07/13 22:25:04 INFO mapred.JobClient:     Bytes Written=22
```

Check the output

```console
$ cat output/part-r-00000     
max     36492        
```

## Submit to Hadoop cluster

Submit the job to a Hadoop cluster

Create the JAR file

```console
$ mvn package
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------< it.sunnyvale.hadoop.assignments:pvenergy-mapreduce >---------
[INFO] Building pvenergy-mapreduce 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ pvenergy-mapreduce ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ pvenergy-mapreduce ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ pvenergy-mapreduce ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/01-PV_energy_production_insights_with_MapReduce/solution/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ pvenergy-mapreduce ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ pvenergy-mapreduce ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ pvenergy-mapreduce ---
[INFO] Building jar: /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/assignments/01-PV_energy_production_insights_with_MapReduce/solution/target/pvenergy-mapreduce-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.378 s
[INFO] Finished at: 2020-07-13T22:30:13+02:00
[INFO] ------------------------------------------------------------------------
```


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

Create the input folder on HDFS:

```console
[vagrant@node1 ~]$ hadoop fs -mkdir ass1_input
```

Load the dataset file into the HDFS input folder:

```console
[vagrant@node1 ~]$ hadoop fs -put /home/vagrant/ITS-ICT_BigData/datasets/sunnyvale_pv_energy_production.csv ass1_input
```

Verify that the file has been loaded to HDFS

```console
$ 
[vagrant@node1 ~]$ hadoop fs -ls ass1_input
Found 1 items
-rw-r--r--   3 vagrant hdfs     116320 2020-07-13 20:38 ass1_input/sunnyvale_pv_energy_production.csv
```

Submit the MapReduce job using YARN

```console
[vagrant@node1 ~]$ yarn jar /home/vagrant/ITS-ICT_BigData/assignments/01-PV_energy_production_insights_with_MapReduce/solution/target/pvenergy-mapreduce-1.0-SNAPSHOT.jar it.sunnyvale.hadoop.assignments.PVEnergyMapReduce ass1_input ass1_output 
20/07/13 20:40:30 INFO client.RMProxy: Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
20/07/13 20:40:31 INFO client.AHSProxy: Connecting to Application History server at node2.example.com/192.168.199.3:10200
20/07/13 20:40:31 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
20/07/13 20:40:31 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/vagrant/.staging/job_1594671584051_0001
20/07/13 20:40:32 INFO input.FileInputFormat: Total input files to process : 1
20/07/13 20:40:32 INFO mapreduce.JobSubmitter: number of splits:1
20/07/13 20:40:33 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1594671584051_0001
20/07/13 20:40:33 INFO mapreduce.JobSubmitter: Executing with tokens: []
20/07/13 20:40:34 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.0.0-78/0/resource-types.xml
20/07/13 20:40:34 INFO impl.YarnClientImpl: Submitted application application_1594671584051_0001
20/07/13 20:40:34 INFO mapreduce.Job: The url to track the job: http://node1.example.com:8088/proxy/application_1594671584051_0001/
20/07/13 20:40:34 INFO mapreduce.Job: Running job: job_1594671584051_0001
20/07/13 20:40:49 INFO mapreduce.Job: Job job_1594671584051_0001 running in uber mode : false
20/07/13 20:40:49 INFO mapreduce.Job:  map 0% reduce 0%
20/07/13 20:41:03 INFO mapreduce.Job:  map 100% reduce 0%
20/07/13 20:41:10 INFO mapreduce.Job:  map 100% reduce 100%
20/07/13 20:41:10 INFO mapreduce.Job: Job job_1594671584051_0001 completed successfully
20/07/13 20:41:10 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=14666
                FILE: Number of bytes written=493169
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=116473
                HDFS: Number of bytes written=10
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=9362
                Total time spent by all reduces in occupied slots (ms)=8186
                Total time spent by all map tasks (ms)=9362
                Total time spent by all reduce tasks (ms)=4093
                Total vcore-milliseconds taken by all map tasks=9362
                Total vcore-milliseconds taken by all reduce tasks=4093
                Total megabyte-milliseconds taken by all map tasks=2396672
                Total megabyte-milliseconds taken by all reduce tasks=2087430
        Map-Reduce Framework
                Map input records=1467
                Map output records=1466
                Map output bytes=19058
                Map output materialized bytes=14666
                Input split bytes=153
                Combine input records=1466
                Combine output records=1466
                Reduce input groups=1
                Reduce shuffle bytes=14666
                Reduce input records=1466
                Reduce output records=1
                Spilled Records=2932
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=202
                CPU time spent (ms)=1760
                Physical memory (bytes) snapshot=253186048
                Virtual memory (bytes) snapshot=4280270848
                Total committed heap usage (bytes)=69206016
                Peak Map Physical memory (bytes)=112185344
                Peak Map Virtual memory (bytes)=2050338816
                Peak Reduce Physical memory (bytes)=141000704
                Peak Reduce Virtual memory (bytes)=2229932032
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=116320
        File Output Format Counters 
                Bytes Written=10
```

Check the output file

```console
[vagrant@node1 ~]$ hadoop fs -ls  ass1_output
Found 2 items
-rw-r--r--   3 vagrant hdfs          0 2020-07-13 20:41 ass1_output/_SUCCESS
-rw-r--r--   3 vagrant hdfs         10 2020-07-13 20:41 ass1_output/part-r-00000
```

Read the output file

```console
[vagrant@node1 ~]$ hadoop fs -cat ass1_input/part-r-00000
max     36492
```