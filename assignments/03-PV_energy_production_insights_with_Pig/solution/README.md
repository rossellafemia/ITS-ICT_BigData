# PV energy production insights with Pig

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
[vagrant@node1 ~]$ hadoop fs -mkdir ass3_input
```

Load the dataset file into the HDFS input folder:

```console
[vagrant@node1 ~]$ hadoop fs -put /home/vagrant/ITS-ICT_BigData/datasets/sunnyvale_pv_energy_production.csv ass3_input
```

Verify that the file has been loaded to HDFS

```console
$ 
[vagrant@node1 ~]$ hadoop fs -ls ass3_input
Found 1 items
-rw-r--r--   3 vagrant hdfs     116320 2020-07-13 20:38 ass3_input/sunnyvale_pv_energy_production.csv
```

Move to this folder 

```console
$ 
[vagrant@node1 ~]$ cd ITS-ICT_BigData/assignments/03-PV_energy_production_insights_with_Pig/solution/
```

```console
$ 
[vagrant@node1 solution]$ pig script.pig
20/09/10 23:37:25 INFO pig.ExecTypeProvider: Trying ExecType : LOCAL
20/09/10 23:37:25 INFO pig.ExecTypeProvider: Trying ExecType : MAPREDUCE
20/09/10 23:37:25 INFO pig.ExecTypeProvider: Picked MAPREDUCE as the ExecType
2020-09-10 23:37:25,162 [main] INFO  org.apache.pig.Main - Apache Pig version 0.17.0 (r1797386) compiled Jun 02 2017, 15:41:58
2020-09-10 23:37:25,162 [main] INFO  org.apache.pig.Main - Logging error messages to: /usr/src/git_repo/assignments/03-PV_energy_production_insights_with_Pig/solution/pig_1599781045152.log
2020-09-10 23:37:25,677 [main] INFO  org.apache.pig.impl.util.Utils - Default bootup file /home/vagrant/.pigbootup not found
2020-09-10 23:37:25,768 [main] INFO  org.apache.pig.backend.hadoop.executionengine.HExecutionEngine - Connecting to hadoop file system at: hdfs://node1.example.com:8020
2020-09-10 23:37:26,244 [main] INFO  org.apache.pig.PigServer - Pig Script ID for the session: PIG-script.pig-5da5c293-0e73-4807-ae82-543fcf883e45
2020-09-10 23:37:26,580 [main] INFO  org.apache.hadoop.yarn.client.api.impl.TimelineClientImpl - Timeline service address: node2.example.com:8188
2020-09-10 23:37:27,035 [main] INFO  org.apache.pig.backend.hadoop.PigATSClient - Created ATS Hook
2020-09-10 23:37:27,818 [main] INFO  org.apache.pig.tools.pigstats.ScriptState - Pig features used in the script: ORDER_BY,LIMIT
2020-09-10 23:37:27,842 [main] INFO  org.apache.pig.data.SchemaTupleBackend - Key [pig.schematuple] was not set... will not generate code.
2020-09-10 23:37:27,883 [main] INFO  org.apache.pig.newplan.logical.optimizer.LogicalPlanOptimizer - {RULES_ENABLED=[AddForEach, ColumnMapKeyPrune, ConstantCalculator, GroupByConstParallelSetter, LimitOptimizer, LoadTypeCastInserter, MergeFilter, MergeForEach, NestedLimitOptimizer, PartitionFilterOptimizer, PredicatePushdownOptimizer, PushDownForEachFlatten, PushUpFilter, SplitFilter, StreamTypeCastInserter]}
2020-09-10 23:37:27,973 [main] INFO  org.apache.pig.impl.util.SpillableMemoryManager - Selected heap (PS Old Gen) of size 699400192 to monitor. collectionUsageThreshold = 489580128, usageThreshold = 489580128
2020-09-10 23:37:28,035 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MRCompiler - File concatenation threshold: 100 optimistic? false
2020-09-10 23:37:28,103 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.SecondaryKeyOptimizerMR - Using Secondary Key Optimization for MapReduce node scope-14
2020-09-10 23:37:28,115 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MultiQueryOptimizer - MR plan size before optimization: 4
2020-09-10 23:37:28,115 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MultiQueryOptimizer - MR plan size after optimization: 4
2020-09-10 23:37:28,225 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:37:28,557 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:37:28,595 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:37:28,602 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:37:28,614 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:37:28,915 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp757351960/tmp-1115297814/pig-0.17.0-core-h2.jar
2020-09-10 23:37:28,972 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp757351960/tmp-1913233089/automaton-1.11-8.jar
2020-09-10 23:37:29,036 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp757351960/tmp-642588268/antlr-runtime-3.4.jar
2020-09-10 23:37:29,105 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp757351960/tmp1441857720/joda-time-2.9.3.jar
2020-09-10 23:37:29,117 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:37:29,126 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:37:29,128 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:37:29,128 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:37:29,198 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:37:29,207 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:37:29,214 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:37:29,343 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0006
2020-09-10 23:37:29,351 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:37:29,406 [JobControl] INFO  org.apache.pig.builtin.PigStorage - Using PigTextInputFormat
2020-09-10 23:37:29,418 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:37:29,418 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:37:29,479 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:37:29,593 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:37:29,821 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0006
2020-09-10 23:37:29,822 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:37:30,008 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:37:30,134 [JobControl] INFO  org.apache.hadoop.conf.Configuration - found resource resource-types.xml at file:/etc/hadoop/3.1.0.0-78/0/resource-types.xml
2020-09-10 23:37:30,306 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0006
2020-09-10 23:37:30,482 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0006/
2020-09-10 23:37:30,482 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0006
2020-09-10 23:37:30,483 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset
2020-09-10 23:37:30,483 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset[1,10],dataset[-1,-1] C:  R: 
2020-09-10 23:37:30,536 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 0% complete
2020-09-10 23:37:30,536 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0006]
2020-09-10 23:37:44,710 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 12% complete
2020-09-10 23:37:44,710 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0006]
2020-09-10 23:37:45,710 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 25% complete
2020-09-10 23:37:45,715 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:37:45,716 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:37:45,722 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:37:46,127 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:37:46,128 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:37:46,167 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:37:46,204 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:37:46,204 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:37:46,214 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:37:46,277 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:37:46,292 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:37:46,303 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Reduce phase detected, estimating # of required reducers.
2020-09-10 23:37:46,305 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Using reducer estimator: org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.InputSizeReducerEstimator
2020-09-10 23:37:46,336 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.InputSizeReducerEstimator - BytesPerReducer=1000000000 maxReducers=999 totalInputFileSize=26587
2020-09-10 23:37:46,353 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting Parallelism to 1
2020-09-10 23:37:46,353 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:37:47,152 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp757351960/tmp957675070/pig-0.17.0-core-h2.jar
2020-09-10 23:37:47,266 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp757351960/tmp-1777499316/automaton-1.11-8.jar
2020-09-10 23:37:47,337 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp757351960/tmp-978628171/antlr-runtime-3.4.jar
2020-09-10 23:37:47,420 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp757351960/tmp-1077698207/joda-time-2.9.3.jar
2020-09-10 23:37:47,421 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:37:47,423 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:37:47,423 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:37:47,423 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:37:47,490 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:37:47,499 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:37:47,500 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:37:47,538 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0007
2020-09-10 23:37:47,540 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:37:47,601 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:37:47,602 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:37:47,602 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:37:47,725 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:37:47,873 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0007
2020-09-10 23:37:47,873 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:37:47,888 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:37:48,195 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0007
2020-09-10 23:37:48,227 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0007/
2020-09-10 23:37:48,228 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0007
2020-09-10 23:37:48,228 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset_ordered
2020-09-10 23:37:48,228 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset_ordered[3,18] C:  R: 
2020-09-10 23:38:02,571 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 37% complete
2020-09-10 23:38:02,571 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0007]
2020-09-10 23:38:10,678 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 50% complete
2020-09-10 23:38:10,679 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0007]
2020-09-10 23:38:13,701 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:38:13,701 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:38:13,708 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:38:13,888 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:38:13,888 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:38:13,892 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:38:13,941 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:38:13,942 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:38:13,949 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:38:13,988 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:38:13,989 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:38:13,989 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Reduce phase detected, estimating # of required reducers.
2020-09-10 23:38:13,989 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting Parallelism to 1
2020-09-10 23:38:13,989 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:38:14,128 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp757351960/tmp764032213/pig-0.17.0-core-h2.jar
2020-09-10 23:38:14,280 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp757351960/tmp1822907653/automaton-1.11-8.jar
2020-09-10 23:38:14,338 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp757351960/tmp465136200/antlr-runtime-3.4.jar
2020-09-10 23:38:14,417 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp757351960/tmp1734156670/joda-time-2.9.3.jar
2020-09-10 23:38:14,419 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:38:14,420 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:38:14,420 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:38:14,420 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:38:14,481 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:38:14,485 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:38:14,485 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:38:14,511 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0008
2020-09-10 23:38:14,513 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:38:14,568 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:38:14,568 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:38:14,568 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:38:14,638 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:38:14,709 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0008
2020-09-10 23:38:14,709 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:38:14,716 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:38:15,002 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0008
2020-09-10 23:38:15,007 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0008/
2020-09-10 23:38:15,007 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0008
2020-09-10 23:38:15,007 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset_ordered
2020-09-10 23:38:15,007 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset_ordered[3,18] C:  R: 
2020-09-10 23:38:29,114 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 62% complete
2020-09-10 23:38:29,115 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0008]
2020-09-10 23:38:34,184 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 75% complete
2020-09-10 23:38:34,185 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0008]
2020-09-10 23:38:40,211 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:38:40,211 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:38:40,215 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:38:40,451 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:38:40,451 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:38:40,456 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:38:40,506 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:38:40,506 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:38:40,512 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:38:40,561 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:38:40,561 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:38:40,562 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Reduce phase detected, estimating # of required reducers.
2020-09-10 23:38:40,562 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting Parallelism to 1
2020-09-10 23:38:40,562 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:38:40,815 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp757351960/tmp154006392/pig-0.17.0-core-h2.jar
2020-09-10 23:38:40,857 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp757351960/tmp-994965363/automaton-1.11-8.jar
2020-09-10 23:38:40,951 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp757351960/tmp-1828770141/antlr-runtime-3.4.jar
2020-09-10 23:38:41,059 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp757351960/tmp-513727002/joda-time-2.9.3.jar
2020-09-10 23:38:41,061 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:38:41,062 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:38:41,062 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:38:41,062 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:38:41,079 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:38:41,084 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:38:41,084 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:38:41,112 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0009
2020-09-10 23:38:41,114 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:38:41,165 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:38:41,165 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:38:41,165 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:38:41,352 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:38:41,477 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0009
2020-09-10 23:38:41,479 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:38:41,499 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:38:41,892 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0009
2020-09-10 23:38:41,961 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0009/
2020-09-10 23:38:41,963 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0009
2020-09-10 23:38:41,964 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset_ordered
2020-09-10 23:38:41,964 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset_ordered[3,18] C:  R: 
2020-09-10 23:38:59,486 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 87% complete
2020-09-10 23:38:59,486 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0009]
2020-09-10 23:39:06,536 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0009]
2020-09-10 23:39:07,543 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,544 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,549 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,661 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,662 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,667 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,699 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,699 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,704 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,759 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 100% complete
2020-09-10 23:39:07,785 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.SimplePigStats - Script Statistics: 

HadoopVersion   PigVersion      UserId  StartedAt       FinishedAt      Features
3.1.1.3.1.0.0-78        0.17.0  vagrant 2020-09-10 23:37:28     2020-09-10 23:39:07     ORDER_BY,LIMIT

Success!

Job Stats (time in seconds):
JobId   Maps    Reduces MaxMapTime      MinMapTime      AvgMapTime      MedianMapTime   MaxReduceTime   MinReduceTime   AvgReduceTime   MedianReducetimeAlias   Feature Outputs
job_1599772615630_0006  1       0       4       4       4       4       0       0       0       0       dataset MAP_ONLY
job_1599772615630_0007  1       1       6       6       6       6       4       4       4       4       dataset_ordered SAMPLER
job_1599772615630_0008  1       1       4       4       4       4       4       4       4       4       dataset_ordered ORDER_BY,COMBINER
job_1599772615630_0009  1       1       5       5       5       5       4       4       4       4       dataset_ordered         hdfs://node1.example.com:8020/tmp/temp757351960/tmp-535751454,

Input(s):
Successfully read 1467 records (116735 bytes) from: "hdfs://node1.example.com:8020/user/vagrant/ass3_input/sunnyvale_pv_energy_production.csv"

Output(s):
Successfully stored 1 records (20 bytes) in: "hdfs://node1.example.com:8020/tmp/temp757351960/tmp-535751454"

Counters:
Total records written : 1
Total bytes written : 20
Spillable Memory Manager spill count : 0
Total bags proactively spilled: 0
Total records proactively spilled: 0

Job DAG:
job_1599772615630_0006  ->      job_1599772615630_0007,
job_1599772615630_0007  ->      job_1599772615630_0008,
job_1599772615630_0008  ->      job_1599772615630_0009,
job_1599772615630_0009


2020-09-10 23:39:07,786 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,787 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,790 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,823 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,823 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,829 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,846 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,846 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,850 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,873 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,874 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,878 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,901 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,901 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,906 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,935 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,935 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,939 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,966 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,967 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,970 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:07,991 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:07,991 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:07,997 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:08,022 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:08,022 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:08,025 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:08,052 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:08,052 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:08,055 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:08,083 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:08,083 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:08,096 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:08,126 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:39:08,127 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:39:08,135 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:39:08,164 [main] WARN  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Encountered Warning FIELD_DISCARDED_TYPE_CONVERSION_FAILED 1 time(s).
2020-09-10 23:39:08,164 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Success!
2020-09-10 23:39:08,171 [main] INFO  org.apache.pig.data.SchemaTupleBackend - Key [pig.schematuple] was not set... will not generate code.
2020-09-10 23:39:08,184 [main] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:39:08,184 [main] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
(16/07/16,36492)
2020-09-10 23:39:08,441 [main] INFO  org.apache.pig.Main - Pig script completed in 1 minute, 43 seconds and 437 milliseconds (103437 ms)
```