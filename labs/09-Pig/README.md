# Pig

## Prerequisites

This lab references hosts, users, paths and other details that belong to the [Vagrant-provisioned 3 nodes Hadoop cluster](../02-Provision_the_environment/Vagrant/README.md).

The [Vagrant-provisioned 3 nodes Hadoop cluster](../02-Provision_the_environment/Vagrant/README.md) should have been started before executing this lab.

Also, all the cluster services must be started as show in the picture below:  

![Cluster services](./img/3-nodes/cluster_services.png)

It is possible to run this lab in any other environment (i.e.: Hortonworks Sandbox or Cloudera DataFlow) provided some small changes to the elements listed above.


Go to path **ITS-ICT_BigData/labs/02-Provision_the_environment/Vagrant** and connect to node 1.

```console
$ vagrant ssh node1 
[vagrant@node1 ~]$ 
```

Move to this folder within the VM 


```console
[vagrant@node1 ~]$ cd ITS-ICT_BigData/labs/09-Pig/
```

Create the HDFS input folder

```console
[vagrant@node1 09-Pig]$ hadoop fs -mkdir lab9_input
```


Copy the dataset in the right HDFS folder

```console
[vagrant@node1 09-Pig]$ hadoop fs -put input/students.csv lab9_input
```

## Case A: search for the maximun GPA

In this scenario, we will use a pig script to search the student with the maximun GPA (Grade Point Average)


Run the script 

```console
[vagrant@node1 09-Pig]$ pig script.pig 
20/09/10 23:13:27 INFO pig.ExecTypeProvider: Trying ExecType : LOCAL
20/09/10 23:13:27 INFO pig.ExecTypeProvider: Trying ExecType : MAPREDUCE
20/09/10 23:13:27 INFO pig.ExecTypeProvider: Picked MAPREDUCE as the ExecType
2020-09-10 23:13:27,557 [main] INFO  org.apache.pig.Main - Apache Pig version 0.17.0 (r1797386) compiled Jun 02 2017, 15:41:58
2020-09-10 23:13:27,557 [main] INFO  org.apache.pig.Main - Logging error messages to: /usr/src/git_repo/labs/09-Pig/pig_1599779607555.log
2020-09-10 23:13:28,110 [main] INFO  org.apache.pig.impl.util.Utils - Default bootup file /home/vagrant/.pigbootup not found
2020-09-10 23:13:28,216 [main] INFO  org.apache.pig.backend.hadoop.executionengine.HExecutionEngine - Connecting to hadoop file system at: hdfs://node1.example.com:8020
2020-09-10 23:13:28,856 [main] INFO  org.apache.pig.PigServer - Pig Script ID for the session: PIG-script.pig-224b342d-345e-40d1-a64a-92020de86c4b
2020-09-10 23:13:29,299 [main] INFO  org.apache.hadoop.yarn.client.api.impl.TimelineClientImpl - Timeline service address: node2.example.com:8188
2020-09-10 23:13:29,840 [main] INFO  org.apache.pig.backend.hadoop.PigATSClient - Created ATS Hook
2020-09-10 23:13:31,183 [main] INFO  org.apache.pig.tools.pigstats.ScriptState - Pig features used in the script: ORDER_BY,LIMIT
2020-09-10 23:13:31,304 [main] INFO  org.apache.pig.data.SchemaTupleBackend - Key [pig.schematuple] was not set... will not generate code.
2020-09-10 23:13:31,417 [main] INFO  org.apache.pig.newplan.logical.optimizer.LogicalPlanOptimizer - {RULES_ENABLED=[AddForEach, ColumnMapKeyPrune, ConstantCalculator, GroupByConstParallelSetter, LimitOptimizer, LoadTypeCastInserter, MergeFilter, MergeForEach, NestedLimitOptimizer, PartitionFilterOptimizer, PredicatePushdownOptimizer, PushDownForEachFlatten, PushUpFilter, SplitFilter, StreamTypeCastInserter]}
2020-09-10 23:13:31,560 [main] INFO  org.apache.pig.impl.util.SpillableMemoryManager - Selected heap (PS Old Gen) of size 699400192 to monitor. collectionUsageThreshold = 489580128, usageThreshold = 489580128
2020-09-10 23:13:31,749 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MRCompiler - File concatenation threshold: 100 optimistic? false
2020-09-10 23:13:32,017 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.SecondaryKeyOptimizerMR - Using Secondary Key Optimization for MapReduce node scope-14
2020-09-10 23:13:32,062 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MultiQueryOptimizer - MR plan size before optimization: 4
2020-09-10 23:13:32,063 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MultiQueryOptimizer - MR plan size after optimization: 4
2020-09-10 23:13:32,289 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:13:32,775 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:13:32,906 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:13:32,910 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:13:32,942 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:13:33,386 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp1767239210/tmp-608831957/pig-0.17.0-core-h2.jar
2020-09-10 23:13:33,471 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp1767239210/tmp1912427586/automaton-1.11-8.jar
2020-09-10 23:13:33,554 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp1767239210/tmp-1169895847/antlr-runtime-3.4.jar
2020-09-10 23:13:33,703 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp1767239210/tmp325619643/joda-time-2.9.3.jar
2020-09-10 23:13:33,732 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:13:33,812 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:13:33,812 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:13:33,812 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:13:33,967 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:13:34,049 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:13:34,060 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:13:34,263 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0001
2020-09-10 23:13:34,293 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:13:34,383 [JobControl] INFO  org.apache.pig.builtin.PigStorage - Using PigTextInputFormat
2020-09-10 23:13:34,417 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:13:34,417 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:13:34,458 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:13:34,671 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:13:35,043 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0001
2020-09-10 23:13:35,046 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:13:35,331 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:13:35,463 [JobControl] INFO  org.apache.hadoop.conf.Configuration - found resource resource-types.xml at file:/etc/hadoop/3.1.0.0-78/0/resource-types.xml
2020-09-10 23:13:35,862 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0001
2020-09-10 23:13:36,207 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0001/
2020-09-10 23:13:36,275 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0001
2020-09-10 23:13:36,275 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset
2020-09-10 23:13:36,275 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset[1,10],dataset[-1,-1] C:  R: 
2020-09-10 23:13:36,494 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 0% complete
2020-09-10 23:13:36,494 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0001]
2020-09-10 23:14:01,929 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 12% complete
2020-09-10 23:14:01,929 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0001]
2020-09-10 23:14:06,955 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 25% complete
2020-09-10 23:14:06,963 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:14:06,963 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:14:06,971 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:14:09,177 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:14:09,177 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:14:09,200 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:14:09,267 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:14:09,267 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:14:09,275 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:14:09,480 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:14:09,481 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:14:09,481 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Reduce phase detected, estimating # of required reducers.
2020-09-10 23:14:09,484 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Using reducer estimator: org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.InputSizeReducerEstimator
2020-09-10 23:14:09,557 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.InputSizeReducerEstimator - BytesPerReducer=1000000000 maxReducers=999 totalInputFileSize=75
2020-09-10 23:14:09,558 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting Parallelism to 1
2020-09-10 23:14:09,558 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:14:10,286 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp1767239210/tmp896358724/pig-0.17.0-core-h2.jar
2020-09-10 23:14:10,867 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp1767239210/tmp-207765865/automaton-1.11-8.jar
2020-09-10 23:14:10,943 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp1767239210/tmp-1298321465/antlr-runtime-3.4.jar
2020-09-10 23:14:11,035 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp1767239210/tmp342297925/joda-time-2.9.3.jar
2020-09-10 23:14:11,037 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:14:11,038 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:14:11,038 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:14:11,038 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:14:11,128 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:14:11,149 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:14:11,151 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:14:11,177 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0002
2020-09-10 23:14:11,180 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:14:11,231 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:14:11,234 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:14:11,234 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:14:11,386 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:14:11,579 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0002
2020-09-10 23:14:11,579 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:14:11,584 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:14:11,893 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0002
2020-09-10 23:14:11,899 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0002/
2020-09-10 23:14:11,899 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0002
2020-09-10 23:14:11,899 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset_ordered
2020-09-10 23:14:11,899 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset_ordered[3,18] C:  R: 
2020-09-10 23:14:29,116 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 37% complete
2020-09-10 23:14:29,116 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0002]
2020-09-10 23:14:36,194 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 50% complete
2020-09-10 23:14:36,194 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0002]
2020-09-10 23:14:42,223 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:14:42,224 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:14:42,230 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:14:42,561 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:14:42,561 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:14:42,567 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:14:42,630 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:14:42,630 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:14:42,641 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:14:42,727 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:14:42,728 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:14:42,728 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Reduce phase detected, estimating # of required reducers.
2020-09-10 23:14:42,728 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting Parallelism to 1
2020-09-10 23:14:42,728 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:14:43,192 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp1767239210/tmp-739366449/pig-0.17.0-core-h2.jar
2020-09-10 23:14:43,354 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp1767239210/tmp922813487/automaton-1.11-8.jar
2020-09-10 23:14:43,439 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp1767239210/tmp-1274650947/antlr-runtime-3.4.jar
2020-09-10 23:14:43,637 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp1767239210/tmp-1247729961/joda-time-2.9.3.jar
2020-09-10 23:14:43,640 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:14:43,641 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:14:43,641 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:14:43,641 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:14:43,724 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:14:43,728 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:14:43,728 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:14:43,800 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0003
2020-09-10 23:14:43,815 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:14:43,916 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:14:43,917 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:14:43,917 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:14:44,063 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:14:44,140 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0003
2020-09-10 23:14:44,140 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:14:44,145 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:14:44,411 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0003
2020-09-10 23:14:44,437 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0003/
2020-09-10 23:14:44,442 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0003
2020-09-10 23:14:44,442 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset_ordered
2020-09-10 23:14:44,442 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset_ordered[3,18] C:  R: 
2020-09-10 23:14:58,586 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 62% complete
2020-09-10 23:14:58,586 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0003]
2020-09-10 23:15:06,614 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 75% complete
2020-09-10 23:15:06,614 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0003]
2020-09-10 23:15:09,627 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:09,627 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:09,631 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:09,757 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:09,757 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:09,760 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:09,792 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:09,793 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:09,801 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:09,847 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:15:09,847 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:15:09,848 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Reduce phase detected, estimating # of required reducers.
2020-09-10 23:15:09,848 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting Parallelism to 1
2020-09-10 23:15:09,848 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:15:10,000 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp1767239210/tmp-1253585000/pig-0.17.0-core-h2.jar
2020-09-10 23:15:10,084 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp1767239210/tmp-431983596/automaton-1.11-8.jar
2020-09-10 23:15:10,139 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp1767239210/tmp-265330967/antlr-runtime-3.4.jar
2020-09-10 23:15:10,241 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp1767239210/tmp1852322692/joda-time-2.9.3.jar
2020-09-10 23:15:10,242 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:15:10,243 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:15:10,243 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:15:10,243 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:15:10,268 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:15:10,291 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:10,291 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:10,348 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0004
2020-09-10 23:15:10,353 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:15:10,437 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:15:10,437 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:15:10,437 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:15:10,577 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:15:10,668 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0004
2020-09-10 23:15:10,668 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:15:10,685 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:15:11,023 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0004
2020-09-10 23:15:11,118 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0004/
2020-09-10 23:15:11,118 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0004
2020-09-10 23:15:11,118 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset_ordered
2020-09-10 23:15:11,118 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset_ordered[3,18] C:  R: 
2020-09-10 23:15:25,266 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 87% complete
2020-09-10 23:15:25,266 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0004]
2020-09-10 23:15:33,325 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0004]
2020-09-10 23:15:36,338 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,339 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,344 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,440 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,441 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,446 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,480 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,480 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,486 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,540 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 100% complete
2020-09-10 23:15:36,600 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.SimplePigStats - Script Statistics: 

HadoopVersion   PigVersion      UserId  StartedAt       FinishedAt      Features
3.1.1.3.1.0.0-78        0.17.0  vagrant 2020-09-10 23:13:32     2020-09-10 23:15:36     ORDER_BY,LIMIT

Success!

Job Stats (time in seconds):
JobId   Maps    Reduces MaxMapTime      MinMapTime      AvgMapTime      MedianMapTime   MaxReduceTime   MinReduceTime   AvgReduceTime   MedianReducetimeAlias   Feature Outputs
job_1599772615630_0001  1       0       6       6       6       6       0       0       0       0       dataset MAP_ONLY
job_1599772615630_0002  1       1       4       4       4       4       3       3       3       3       dataset_ordered SAMPLER
job_1599772615630_0003  1       1       3       3       3       3       5       5       5       5       dataset_ordered ORDER_BY,COMBINER
job_1599772615630_0004  1       1       4       4       4       4       3       3       3       3       dataset_ordered         hdfs://node1.example.com:8020/tmp/temp1767239210/tmp2038774277,

Input(s):
Successfully read 5 records (442 bytes) from: "hdfs://node1.example.com:8020/user/vagrant/lab9_input/students.csv"

Output(s):
Successfully stored 1 records (19 bytes) in: "hdfs://node1.example.com:8020/tmp/temp1767239210/tmp2038774277"

Counters:
Total records written : 1
Total bytes written : 19
Spillable Memory Manager spill count : 0
Total bags proactively spilled: 0
Total records proactively spilled: 0

Job DAG:
job_1599772615630_0001  ->      job_1599772615630_0002,
job_1599772615630_0002  ->      job_1599772615630_0003,
job_1599772615630_0003  ->      job_1599772615630_0004,
job_1599772615630_0004


2020-09-10 23:15:36,601 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,601 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,604 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,626 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,627 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,629 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,666 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,666 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,670 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,718 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,718 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,721 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,740 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,740 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,751 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,817 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,817 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,825 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,851 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,851 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,862 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:36,912 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:36,913 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:36,923 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:37,031 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:37,034 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:37,038 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:37,082 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:37,083 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:37,098 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:37,164 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:37,165 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:37,176 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:37,217 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:15:37,218 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:15:37,235 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:15:37,271 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Success!
2020-09-10 23:15:37,274 [main] INFO  org.apache.pig.data.SchemaTupleBackend - Key [pig.schematuple] was not set... will not generate code.
2020-09-10 23:15:37,297 [main] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:15:37,297 [main] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
(Margherita,30)
2020-09-10 23:15:37,586 [main] INFO  org.apache.pig.Main - Pig script completed in 2 minutes, 10 seconds and 214 milliseconds (130214 ms)
```

## Case B: Sum the GPAs of students with the name starts for the same letter 

```console
[vagrant@node1 09-Pig]$ pig script_grouping.pig 

20/09/10 23:20:24 INFO pig.ExecTypeProvider: Trying ExecType : LOCAL
20/09/10 23:20:24 INFO pig.ExecTypeProvider: Trying ExecType : MAPREDUCE
20/09/10 23:20:24 INFO pig.ExecTypeProvider: Picked MAPREDUCE as the ExecType
2020-09-10 23:20:24,866 [main] INFO  org.apache.pig.Main - Apache Pig version 0.17.0 (r1797386) compiled Jun 02 2017, 15:41:58
2020-09-10 23:20:24,866 [main] INFO  org.apache.pig.Main - Logging error messages to: /usr/src/git_repo/labs/09-Pig/pig_1599780024862.log
2020-09-10 23:20:25,553 [main] INFO  org.apache.pig.impl.util.Utils - Default bootup file /home/vagrant/.pigbootup not found
2020-09-10 23:20:25,706 [main] INFO  org.apache.pig.backend.hadoop.executionengine.HExecutionEngine - Connecting to hadoop file system at: hdfs://node1.example.com:8020
2020-09-10 23:20:26,294 [main] INFO  org.apache.pig.PigServer - Pig Script ID for the session: PIG-script_grouping.pig-b2fee4a7-b04f-4f9e-8774-3c9349533036
2020-09-10 23:20:26,609 [main] INFO  org.apache.hadoop.yarn.client.api.impl.TimelineClientImpl - Timeline service address: node2.example.com:8188
2020-09-10 23:20:27,139 [main] INFO  org.apache.pig.backend.hadoop.PigATSClient - Created ATS Hook
2020-09-10 23:20:28,091 [main] INFO  org.apache.pig.tools.pigstats.ScriptState - Pig features used in the script: GROUP_BY
2020-09-10 23:20:28,115 [main] INFO  org.apache.pig.data.SchemaTupleBackend - Key [pig.schematuple] was not set... will not generate code.
2020-09-10 23:20:28,157 [main] INFO  org.apache.pig.newplan.logical.optimizer.LogicalPlanOptimizer - {RULES_ENABLED=[AddForEach, ColumnMapKeyPrune, ConstantCalculator, GroupByConstParallelSetter, LimitOptimizer, LoadTypeCastInserter, MergeFilter, MergeForEach, NestedLimitOptimizer, PartitionFilterOptimizer, PredicatePushdownOptimizer, PushDownForEachFlatten, PushUpFilter, SplitFilter, StreamTypeCastInserter]}
2020-09-10 23:20:28,242 [main] INFO  org.apache.pig.impl.util.SpillableMemoryManager - Selected heap (PS Old Gen) of size 699400192 to monitor. collectionUsageThreshold = 489580128, usageThreshold = 489580128
2020-09-10 23:20:28,347 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MRCompiler - File concatenation threshold: 100 optimistic? false
2020-09-10 23:20:28,371 [main] INFO  org.apache.pig.backend.hadoop.executionengine.util.CombinerOptimizerUtil - Choosing to move algebraic foreach to combiner
2020-09-10 23:20:28,429 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MultiQueryOptimizer - MR plan size before optimization: 1
2020-09-10 23:20:28,429 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MultiQueryOptimizer - MR plan size after optimization: 1
2020-09-10 23:20:28,636 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:20:28,960 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:20:29,017 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-10 23:20:29,023 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-10 23:20:29,075 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Reduce phase detected, estimating # of required reducers.
2020-09-10 23:20:29,076 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Using reducer estimator: org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.InputSizeReducerEstimator
2020-09-10 23:20:29,087 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.InputSizeReducerEstimator - BytesPerReducer=1000000000 maxReducers=999 totalInputFileSize=49
2020-09-10 23:20:29,087 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting Parallelism to 1
2020-09-10 23:20:29,087 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-10 23:20:29,465 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp1873336036/tmp1975536105/pig-0.17.0-core-h2.jar
2020-09-10 23:20:29,546 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp1873336036/tmp-286896554/automaton-1.11-8.jar
2020-09-10 23:20:29,620 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp1873336036/tmp-743619209/antlr-runtime-3.4.jar
2020-09-10 23:20:29,699 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp1873336036/tmp-496497408/joda-time-2.9.3.jar
2020-09-10 23:20:29,713 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-10 23:20:29,717 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-10 23:20:29,718 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-10 23:20:29,718 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-10 23:20:29,844 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-10 23:20:29,858 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:20:29,860 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:20:30,025 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599772615630_0005
2020-09-10 23:20:30,042 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-10 23:20:30,091 [JobControl] INFO  org.apache.pig.builtin.PigStorage - Using PigTextInputFormat
2020-09-10 23:20:30,109 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:20:30,110 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-10 23:20:30,160 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-10 23:20:30,301 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-10 23:20:30,561 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599772615630_0005
2020-09-10 23:20:30,565 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-10 23:20:30,905 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-10 23:20:31,049 [JobControl] INFO  org.apache.hadoop.conf.Configuration - found resource resource-types.xml at file:/etc/hadoop/3.1.0.0-78/0/resource-types.xml
2020-09-10 23:20:31,410 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599772615630_0005
2020-09-10 23:20:31,539 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599772615630_0005/
2020-09-10 23:20:31,541 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599772615630_0005
2020-09-10 23:20:31,541 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset,group_data,result
2020-09-10 23:20:31,541 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset[1,10],dataset[-1,-1],result[4,9],group_data[3,13] C: result[4,9],group_data[3,13] R: result[4,9]
2020-09-10 23:20:31,585 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 0% complete
2020-09-10 23:20:31,585 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0005]
2020-09-10 23:20:45,697 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 50% complete
2020-09-10 23:20:45,698 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0005]
2020-09-10 23:20:51,730 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599772615630_0005]
2020-09-10 23:20:56,748 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:20:56,748 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:20:56,758 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:20:57,006 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:20:57,007 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:20:57,011 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:20:57,078 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:20:57,078 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:20:57,092 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:20:57,195 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 100% complete
2020-09-10 23:20:57,198 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.SimplePigStats - Script Statistics: 

HadoopVersion   PigVersion      UserId  StartedAt       FinishedAt      Features
3.1.1.3.1.0.0-78        0.17.0  vagrant 2020-09-10 23:20:29     2020-09-10 23:20:57     GROUP_BY

Success!

Job Stats (time in seconds):
JobId   Maps    Reduces MaxMapTime      MinMapTime      AvgMapTime      MedianMapTime   MaxReduceTime   MinReduceTime   AvgReduceTime   MedianReducetimeAlias   Feature Outputs
job_1599772615630_0005  1       1       4       4       4       4       3       3       3       3       dataset,group_data,result       GROUP_BY,COMBINER       hdfs://node1.example.com:8020/tmp/temp1873336036/tmp182551647,

Input(s):
Successfully read 5 records (442 bytes) from: "hdfs://node1.example.com:8020/user/vagrant/lab9_input/students.csv"

Output(s):
Successfully stored 2 records (20 bytes) in: "hdfs://node1.example.com:8020/tmp/temp1873336036/tmp182551647"

Counters:
Total records written : 2
Total bytes written : 20
Spillable Memory Manager spill count : 0
Total bags proactively spilled: 0
Total records proactively spilled: 0

Job DAG:
job_1599772615630_0005


2020-09-10 23:20:57,201 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:20:57,201 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:20:57,207 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:20:57,237 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:20:57,237 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:20:57,243 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:20:57,274 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-10 23:20:57,275 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-10 23:20:57,285 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-10 23:20:57,317 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Success!
2020-09-10 23:20:57,325 [main] INFO  org.apache.pig.data.SchemaTupleBackend - Key [pig.schematuple] was not set... will not generate code.
2020-09-10 23:20:57,394 [main] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-10 23:20:57,396 [main] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
(A,35)
(M,76)
2020-09-10 23:20:57,628 [main] INFO  org.apache.pig.Main - Pig script completed in 32 seconds and 966 milliseconds (32966 ms)
```