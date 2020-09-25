# COVID pandemic insight with Pig

Create the input folder

```console
[vagrant@node1 ~]$ hadoop fs -mkdir ass4_input
```

Put the input file within the previously created folder

```console
[vagrant@node1 ~]$ hadoop fs -put /home/vagrant/ITS-ICT_BigData/datasets/dpc-covid19-ita-regioni.csv ass4_input
```

Move to the Pig script folder

```console
[vagrant@node1 ~]$ cd ITS-ICT_BigData/assignments/04-COVID_pandemic_insight_with_Pig/solution/
```

Run the Pig script

```
[vagrant@node1 solution]$ pig script.pig 
20/09/09 22:54:40 INFO pig.ExecTypeProvider: Trying ExecType : LOCAL
20/09/09 22:54:40 INFO pig.ExecTypeProvider: Trying ExecType : MAPREDUCE
20/09/09 22:54:40 INFO pig.ExecTypeProvider: Picked MAPREDUCE as the ExecType
2020-09-09 22:54:40,708 [main] INFO  org.apache.pig.Main - Apache Pig version 0.17.0 (r1797386) compiled Jun 02 2017, 15:41:58
2020-09-09 22:54:40,708 [main] INFO  org.apache.pig.Main - Logging error messages to: /usr/src/git_repo/assignments/04-COVID_pandemic_insight_with_Pig/solution/pig_1599692080704.log
2020-09-09 22:54:42,032 [main] INFO  org.apache.pig.impl.util.Utils - Default bootup file /home/vagrant/.pigbootup not found
2020-09-09 22:54:42,298 [main] INFO  org.apache.pig.backend.hadoop.executionengine.HExecutionEngine - Connecting to hadoop file system at: hdfs://node1.example.com:8020
2020-09-09 22:54:43,255 [main] INFO  org.apache.pig.PigServer - Pig Script ID for the session: PIG-script.pig-3145e034-9f70-4f1a-abd5-d1526838b1bb
2020-09-09 22:54:43,806 [main] INFO  org.apache.hadoop.yarn.client.api.impl.TimelineClientImpl - Timeline service address: node2.example.com:8188
2020-09-09 22:54:44,693 [main] INFO  org.apache.pig.backend.hadoop.PigATSClient - Created ATS Hook
2020-09-09 22:54:46,506 [main] INFO  org.apache.pig.tools.pigstats.ScriptState - Pig features used in the script: GROUP_BY
2020-09-09 22:54:46,564 [main] INFO  org.apache.pig.data.SchemaTupleBackend - Key [pig.schematuple] was not set... will not generate code.
2020-09-09 22:54:46,645 [main] INFO  org.apache.pig.newplan.logical.optimizer.LogicalPlanOptimizer - {RULES_ENABLED=[AddForEach, ColumnMapKeyPrune, ConstantCalculator, GroupByConstParallelSetter, LimitOptimizer, LoadTypeCastInserter, MergeFilter, MergeForEach, NestedLimitOptimizer, PartitionFilterOptimizer, PredicatePushdownOptimizer, PushDownForEachFlatten, PushUpFilter, SplitFilter, StreamTypeCastInserter]}
2020-09-09 22:54:46,761 [main] INFO  org.apache.pig.impl.util.SpillableMemoryManager - Selected heap (PS Old Gen) of size 699400192 to monitor. collectionUsageThreshold = 489580128, usageThreshold = 489580128
2020-09-09 22:54:46,855 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MRCompiler - File concatenation threshold: 100 optimistic? false
2020-09-09 22:54:46,879 [main] INFO  org.apache.pig.backend.hadoop.executionengine.util.CombinerOptimizerUtil - Choosing to move algebraic foreach to combiner
2020-09-09 22:54:46,929 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MultiQueryOptimizer - MR plan size before optimization: 1
2020-09-09 22:54:46,929 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MultiQueryOptimizer - MR plan size after optimization: 1
2020-09-09 22:54:47,015 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-09 22:54:47,294 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-09 22:54:47,375 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.MRScriptState - Pig script settings are added to the job
2020-09-09 22:54:47,381 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - mapred.job.reduce.markreset.buffer.percent is not set, set to default 0.3
2020-09-09 22:54:47,436 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Reduce phase detected, estimating # of required reducers.
2020-09-09 22:54:47,489 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Using reducer estimator: org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.InputSizeReducerEstimator
2020-09-09 22:54:47,531 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.InputSizeReducerEstimator - BytesPerReducer=1000000000 maxReducers=999 totalInputFileSize=487277
2020-09-09 22:54:47,531 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting Parallelism to 1
2020-09-09 22:54:47,531 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - This job cannot be converted run in-process
2020-09-09 22:54:48,061 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/pig-0.17.0-core-h2.jar to DistributedCache through /tmp/temp302046174/tmp38184868/pig-0.17.0-core-h2.jar
2020-09-09 22:54:48,162 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/automaton-1.11-8.jar to DistributedCache through /tmp/temp302046174/tmp-1943952404/automaton-1.11-8.jar
2020-09-09 22:54:48,231 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/antlr-runtime-3.4.jar to DistributedCache through /tmp/temp302046174/tmp37776616/antlr-runtime-3.4.jar
2020-09-09 22:54:48,322 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Added jar file:/opt/pig-0.17.0/lib/joda-time-2.9.3.jar to DistributedCache through /tmp/temp302046174/tmp-1736962749/joda-time-2.9.3.jar
2020-09-09 22:54:48,335 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.JobControlCompiler - Setting up single store job
2020-09-09 22:54:48,340 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Key [pig.schematuple] is false, will not generate code.
2020-09-09 22:54:48,340 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Starting process to move generated code to distributed cacche
2020-09-09 22:54:48,340 [main] INFO  org.apache.pig.data.SchemaTupleFrontend - Setting key [pig.schematuple.classes] with classes to deserialize []
2020-09-09 22:54:48,467 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 1 map-reduce job(s) waiting for submission.
2020-09-09 22:54:48,484 [JobControl] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-09 22:54:48,488 [JobControl] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-09 22:54:48,631 [JobControl] INFO  org.apache.hadoop.mapreduce.JobResourceUploader - Disabling Erasure Coding for path: /user/vagrant/.staging/job_1599687629178_0003
2020-09-09 22:54:48,641 [JobControl] WARN  org.apache.hadoop.mapreduce.JobResourceUploader - No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
2020-09-09 22:54:48,682 [JobControl] INFO  org.apache.pig.builtin.PigStorage - Using PigTextInputFormat
2020-09-09 22:54:48,742 [JobControl] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-09 22:54:48,742 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
2020-09-09 22:54:48,812 [JobControl] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths (combined) to process : 1
2020-09-09 22:54:49,008 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - number of splits:1
2020-09-09 22:54:49,326 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Submitting tokens for job: job_1599687629178_0003
2020-09-09 22:54:49,346 [JobControl] INFO  org.apache.hadoop.mapreduce.JobSubmitter - Executing with tokens: []
2020-09-09 22:54:49,551 [JobControl] INFO  org.apache.hadoop.mapred.YARNRunner - Job jar is not present. Not adding any jar to the list of resources.
2020-09-09 22:54:49,703 [JobControl] INFO  org.apache.hadoop.conf.Configuration - found resource resource-types.xml at file:/etc/hadoop/3.1.0.0-78/0/resource-types.xml
2020-09-09 22:54:50,045 [JobControl] INFO  org.apache.hadoop.yarn.client.api.impl.YarnClientImpl - Submitted application application_1599687629178_0003
2020-09-09 22:54:50,108 [JobControl] INFO  org.apache.hadoop.mapreduce.Job - The url to track the job: http://node1.example.com:8088/proxy/application_1599687629178_0003/
2020-09-09 22:54:50,110 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - HadoopJobId: job_1599687629178_0003
2020-09-09 22:54:50,110 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Processing aliases dataset,group_data,result
2020-09-09 22:54:50,110 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - detailed locations: M: dataset[1,10],dataset[-1,-1],result[4,9],group_data[3,13] C: result[4,9],group_data[3,13] R: result[4,9]
2020-09-09 22:54:50,156 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 0% complete
2020-09-09 22:54:50,156 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599687629178_0003]
2020-09-09 22:55:05,264 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 50% complete
2020-09-09 22:55:05,264 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599687629178_0003]
2020-09-09 22:55:12,332 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Running jobs are [job_1599687629178_0003]
2020-09-09 22:55:15,353 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-09 22:55:15,354 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-09 22:55:15,361 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-09 22:55:15,678 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-09 22:55:15,678 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-09 22:55:15,688 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-09 22:55:15,736 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-09 22:55:15,744 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-09 22:55:15,759 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-09 22:55:15,875 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - 100% complete
2020-09-09 22:55:15,877 [main] INFO  org.apache.pig.tools.pigstats.mapreduce.SimplePigStats - Script Statistics: 

HadoopVersion   PigVersion      UserId  StartedAt       FinishedAt      Features
3.1.1.3.1.0.0-78        0.17.0  vagrant 2020-09-09 22:54:47     2020-09-09 22:55:15     GROUP_BY

Success!

Job Stats (time in seconds):
JobId   Maps    Reduces MaxMapTime      MinMapTime      AvgMapTime      MedianMapTime   MaxReduceTime   MinReduceTime   AvgReduceTime   MedianReducetime      Alias   Feature Outputs
job_1599687629178_0003  1       1       6       6       6       6       4       4       4       4       dataset,group_data,result       GROUP_BY,COMBINER     hdfs://node1.example.com:8020/tmp/temp302046174/tmp-47488637,

Input(s):
Successfully read 4075 records (487685 bytes) from: "hdfs://node1.example.com:8020/user/vagrant/ass3_input/dpc-covid19-ita-regioni.csv"

Output(s):
Successfully stored 195 records (5634 bytes) in: "hdfs://node1.example.com:8020/tmp/temp302046174/tmp-47488637"

Counters:
Total records written : 195
Total bytes written : 5634
Spillable Memory Manager spill count : 0
Total bags proactively spilled: 0
Total records proactively spilled: 0

Job DAG:
job_1599687629178_0003


2020-09-09 22:55:15,879 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-09 22:55:15,880 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-09 22:55:15,884 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-09 22:55:15,907 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-09 22:55:15,908 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-09 22:55:15,914 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-09 22:55:15,949 [main] INFO  org.apache.hadoop.yarn.client.RMProxy - Connecting to ResourceManager at node1.example.com/192.168.199.2:8050
2020-09-09 22:55:15,950 [main] INFO  org.apache.hadoop.yarn.client.AHSProxy - Connecting to Application History server at node2.example.com/192.168.199.3:10200
2020-09-09 22:55:15,953 [main] INFO  org.apache.hadoop.mapred.ClientServiceDelegate - Application state is completed. FinalApplicationStatus=SUCCEEDED. Redirecting to job history server
2020-09-09 22:55:15,984 [main] WARN  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Encountered Warning FIELD_DISCARDED_TYPE_CONVERSION_FAILED 16 time(s).
2020-09-09 22:55:15,984 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Success!
2020-09-09 22:55:15,990 [main] INFO  org.apache.pig.data.SchemaTupleBackend - Key [pig.schematuple] was not set... will not generate code.
2020-09-09 22:55:16,023 [main] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input files to process : 1
2020-09-09 22:55:16,023 [main] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
...
(2020-08-28T17:00:00,1462)
(2020-08-29T17:00:00,1444)
(2020-08-30T17:00:00,1365)
(2020-08-31T17:00:00,996)
(2020-09-01T17:00:00,978)
(2020-09-02T17:00:00,1326)
(2020-09-03T17:00:00,1397)
(2020-09-04T17:00:00,1733)
2020-09-09 22:55:16,224 [main] INFO  org.apache.pig.Main - Pig script completed in 35 seconds and 857 milliseconds (35857 ms)
```

