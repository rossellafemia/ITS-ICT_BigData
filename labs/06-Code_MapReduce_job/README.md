# Code MapReduce job

## Prerequisites

- JDK 1.8 
- IntelliJ Idea Community Edition (or any other Java IDE)
- Maven

## Start the lab

Test locally 

```console
$ mvn exec:java
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------< it.sunnyvale.hadoop.labs:code-mapreduce >---------------
[INFO] Building code-mapreduce 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ code-mapreduce ---
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.hadoop.security.authentication.util.KerberosUtil (file:/Users/denismaggiorotto/.m2/repository/org/apache/hadoop/hadoop-core/1.2.1/hadoop-core-1.2.1.jar) to method sun.security.krb5.Config.getInstance()
WARNING: Please consider reporting this to the maintainers of org.apache.hadoop.security.authentication.util.KerberosUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
20/07/11 19:12:48 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
20/07/11 19:12:48 WARN mapred.JobClient: Use GenericOptionsParser for parsing the arguments. Applications should implement Tool for the same.
20/07/11 19:12:48 WARN mapred.JobClient: No job jar file set.  User classes may not be found. See JobConf(Class) or JobConf#setJar(String).
20/07/11 19:12:48 WARN snappy.LoadSnappy: Snappy native library not loaded
20/07/11 19:12:48 INFO mapred.FileInputFormat: Total input paths to process : 1
20/07/11 19:12:48 INFO mapred.JobClient: Running job: job_local662185113_0001
20/07/11 19:12:48 INFO mapred.LocalJobRunner: Waiting for map tasks
20/07/11 19:12:48 INFO mapred.LocalJobRunner: Starting task: attempt_local662185113_0001_m_000000_0
20/07/11 19:12:48 INFO mapred.Task:  Using ResourceCalculatorPlugin : null
20/07/11 19:12:48 INFO mapred.MapTask: Processing split: file:/Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/labs/06-Code_MapReduce_job/input/sample.txt:0+218
20/07/11 19:12:48 INFO mapred.MapTask: numReduceTasks: 1
20/07/11 19:12:48 INFO mapred.MapTask: io.sort.mb = 100
20/07/11 19:12:48 INFO mapred.MapTask: data buffer = 79691776/99614720
20/07/11 19:12:48 INFO mapred.MapTask: record buffer = 262144/327680
20/07/11 19:12:48 INFO mapred.MapTask: Starting flush of map output
20/07/11 19:12:48 INFO mapred.MapTask: Finished spill 0
20/07/11 19:12:48 INFO mapred.Task: Task:attempt_local662185113_0001_m_000000_0 is done. And is in the process of commiting
20/07/11 19:12:48 INFO mapred.LocalJobRunner: file:/Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/labs/06-Code_MapReduce_job/input/sample.txt:0+218
20/07/11 19:12:48 INFO mapred.Task: Task 'attempt_local662185113_0001_m_000000_0' done.
20/07/11 19:12:48 INFO mapred.LocalJobRunner: Finishing task: attempt_local662185113_0001_m_000000_0
20/07/11 19:12:48 INFO mapred.LocalJobRunner: Map task executor complete.
20/07/11 19:12:48 INFO mapred.Task:  Using ResourceCalculatorPlugin : null
20/07/11 19:12:48 INFO mapred.LocalJobRunner: 
20/07/11 19:12:48 INFO mapred.Merger: Merging 1 sorted segments
20/07/11 19:12:48 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 35 bytes
20/07/11 19:12:48 INFO mapred.LocalJobRunner: 
20/07/11 19:12:48 INFO mapred.Task: Task:attempt_local662185113_0001_r_000000_0 is done. And is in the process of commiting
20/07/11 19:12:48 INFO mapred.LocalJobRunner: 
20/07/11 19:12:48 INFO mapred.Task: Task attempt_local662185113_0001_r_000000_0 is allowed to commit now
20/07/11 19:12:48 INFO mapred.FileOutputCommitter: Saved output of task 'attempt_local662185113_0001_r_000000_0' to file:/Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/labs/06-Code_MapReduce_job/output
20/07/11 19:12:48 INFO mapred.LocalJobRunner: reduce > reduce
20/07/11 19:12:48 INFO mapred.Task: Task 'attempt_local662185113_0001_r_000000_0' done.
20/07/11 19:12:49 INFO mapred.JobClient:  map 100% reduce 100%
20/07/11 19:12:49 INFO mapred.JobClient: Job complete: job_local662185113_0001
20/07/11 19:12:49 INFO mapred.JobClient: Counters: 18
20/07/11 19:12:49 INFO mapred.JobClient:   Map-Reduce Framework
20/07/11 19:12:49 INFO mapred.JobClient:     Spilled Records=6
20/07/11 19:12:49 INFO mapred.JobClient:     Map output materialized bytes=39
20/07/11 19:12:49 INFO mapred.JobClient:     Reduce input records=3
20/07/11 19:12:49 INFO mapred.JobClient:     Map input records=5
20/07/11 19:12:49 INFO mapred.JobClient:     SPLIT_RAW_BYTES=218
20/07/11 19:12:49 INFO mapred.JobClient:     Map output bytes=45
20/07/11 19:12:49 INFO mapred.JobClient:     Reduce shuffle bytes=0
20/07/11 19:12:49 INFO mapred.JobClient:     Map input bytes=218
20/07/11 19:12:49 INFO mapred.JobClient:     Reduce input groups=3
20/07/11 19:12:49 INFO mapred.JobClient:     Combine output records=3
20/07/11 19:12:49 INFO mapred.JobClient:     Reduce output records=3
20/07/11 19:12:49 INFO mapred.JobClient:     Map output records=5
20/07/11 19:12:49 INFO mapred.JobClient:     Combine input records=5
20/07/11 19:12:49 INFO mapred.JobClient:     Total committed heap usage (bytes)=406847488
20/07/11 19:12:49 INFO mapred.JobClient:   File Input Format Counters 
20/07/11 19:12:49 INFO mapred.JobClient:     Bytes Read=218
20/07/11 19:12:49 INFO mapred.JobClient:   FileSystemCounters
20/07/11 19:12:49 INFO mapred.JobClient:     FILE_BYTES_WRITTEN=104182
20/07/11 19:12:49 INFO mapred.JobClient:     FILE_BYTES_READ=1021
20/07/11 19:12:49 INFO mapred.JobClient:   File Output Format Counters 
20/07/11 19:12:49 INFO mapred.JobClient:     Bytes Written=36
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.457 s
[INFO] Finished at: 2020-07-11T19:12:49+02:00
[INFO] ------------------------------------------------------------------------
```

Create the JAR file

```console
$ mvn package
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------< it.sunnyvale.hadoop.labs:code-mapreduce >---------------
[INFO] Building code-mapreduce 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ code-mapreduce ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ code-mapreduce ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ code-mapreduce ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/denismaggiorotto/Documents/SoxelyNCFS/Sunnyvale/Clienti/ITS-ICT/2019-2021/Cloud/BigData/repos/ITS-ICT_BigData/labs/06-Code_MapReduce_job/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ code-mapreduce ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ code-mapreduce ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ code-mapreduce ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.797 s
[INFO] Finished at: 2020-07-11T19:17:16+02:00
[INFO] ------------------------------------------------------------------------
```

Submit the job to a Hadoop cluster

