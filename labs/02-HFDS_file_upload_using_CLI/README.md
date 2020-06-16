# HDFS file upload using CLI

## Prerequisites

This lab references hosts, users, paths and other details that belong to the [Vagrant-provisioned 3 nodes Hadoop cluster](../01-Provision_the_environment/Vagrant/README.md).

Also, the [Vagrant-provisioned 3 nodes Hadoop cluster](../01-Provision_the_environment/Vagrant/README.md) should have been started before executing this lab.

It is possible to run this lab in any other environment (i.e.: Hortonworks Sandbox or Cloudera DataFlow) provided some small changes to the elements listed above.

## Upload a file to HDFS

Go to path **ITS-ICT_BigData/labs/01-Provision_the_environment/Vagrant** and connect to node 1.

```console
$ vagrant ssh node1 
[vagrant@node1 ~]$ 
```

Here you can use the `hadoop`command to interact with HFDS.

First of all, using `sudo` let's impersonate the `hdfs` user in order to execute commands as the HDFS administrator:

```console
[vagrant@node1 ~]$ sudo su - hdfs
Last login: Mon Jun 15 22:00:12 UTC 2020
[hdfs@node1 ~]$ 
```

Here we can create the first HDFS folder.

```console
[hdfs@node1 ~]$ hadoop fs -mkdir /hdfs-dir
[hdfs@node1 ~]$ 
```

Let's change the folder owner in order to write into it with the vagrant user:

```console
[hdfs@node1 ~]$ hadoop fs -chown vagrant:vagrant /hdfs-dir
[hdfs@node1 ~]$ 
```

By returning the vagrant user, just list the HDFS folder content:

```console
[hdfs@node1 ~]$ exit
[vagrant@node1 ~]$ hadoop fs -ls /hdfs-dir

```
The /hdfs-dir is empty.

Now we are going to load a file in the Hadoop FS folder:

```console
[vagrant@node1 ~]$ hadoop fs -put /home/vagrant/ITS-ICT_BigData/datasets/salaries.csv /hdfs-dir/salaries.csv
[vagrant@node1 ~]$
```

Let's check how HDFS has hadled our file:

```console
[vagrant@node1 ~]$ hdfs fsck /hdfs-dir/salaries.csv
hdfs fsck /hdfs-dir/salaries.csv
Connecting to namenode via http://node1.example.com:50070/fsck?ugi=vagrant&path=%2Fhdfs-dir%2Fsalaries.csv
FSCK started by vagrant (auth:SIMPLE) from /192.168.199.2 for path /hdfs-dir/salaries.csv at Mon Jun 15 23:43:20 UTC 2020

Status: HEALTHY
 Number of data-nodes:  3
 Number of racks:               1
 Total dirs:                    0
 Total symlinks:                0

Replicated Blocks:
 Total size:    16257213 B
 Total files:   1
 Total blocks (validated):      1 (avg. block size 16257213 B)
 Minimally replicated blocks:   1 (100.0 %)
 Over-replicated blocks:        0 (0.0 %)
 Under-replicated blocks:       0 (0.0 %)
 Mis-replicated blocks:         0 (0.0 %)
 Default replication factor:    3
 Average block replication:     3.0
 Missing blocks:                0
 Corrupt blocks:                0
 Missing replicas:              0 (0.0 %)

Erasure Coded Block Groups:
 Total size:    0 B
 Total files:   0
 Total block groups (validated):        0
 Minimally erasure-coded block groups:  0
 Over-erasure-coded block groups:       0
 Under-erasure-coded block groups:      0
 Unsatisfactory placement block groups: 0
 Average block group size:      0.0
 Missing block groups:          0
 Corrupt block groups:          0
 Missing internal blocks:       0
FSCK ended at Mon Jun 15 23:43:20 UTC 2020 in 3 milliseconds


The filesystem under path '/hdfs-dir/salaries.csv' is HEALTHY
```
salaries.csv file is only 16Mb so it is not decomposed into multiple blocks.

Using the `-D dfs.blocksize=1m` flag we can decrease the block size and with the `-f` we can overwrite the previous file with the same but decomposed in smaller blocks.

```console
[vagrant@node1 ~]$ hadoop fs -D dfs.blocksize=1m -put -f /home/vagrant/ITS-ICT_BigData/datasets/salaries.csv /hdfs-dir/salaries.csv
```

If we re-run the `hdfs fsck`command

```console
[vagrant@node1 ~]$ hdfs fsck /hdfs-dir/salaries.csv
Connecting to namenode via http://node1.example.com:50070/fsck?ugi=vagrant&path=%2Fhdfs-dir%2Fsalaries.csv
FSCK started by vagrant (auth:SIMPLE) from /192.168.199.2 for path /hdfs-dir/salaries.csv at Mon Jun 15 23:49:57 UTC 2020

Status: HEALTHY
 Number of data-nodes:  3
 Number of racks:               1
 Total dirs:                    0
 Total symlinks:                0

Replicated Blocks:
 Total size:    16257213 B
 Total files:   1
 Total blocks (validated):      16 (avg. block size 1016075 B)
 Minimally replicated blocks:   16 (100.0 %)
 Over-replicated blocks:        0 (0.0 %)
 Under-replicated blocks:       0 (0.0 %)
 Mis-replicated blocks:         0 (0.0 %)
 Default replication factor:    3
 Average block replication:     3.0
 Missing blocks:                0
 Corrupt blocks:                0
 Missing replicas:              0 (0.0 %)

Erasure Coded Block Groups:
 Total size:    0 B
 Total files:   0
 Total block groups (validated):        0
 Minimally erasure-coded block groups:  0
 Over-erasure-coded block groups:       0
 Under-erasure-coded block groups:      0
 Unsatisfactory placement block groups: 0
 Average block group size:      0.0
 Missing block groups:          0
 Corrupt block groups:          0
 Missing internal blocks:       0
FSCK ended at Mon Jun 15 23:49:57 UTC 2020 in 2 milliseconds


The filesystem under path '/hdfs-dir/salaries.csv' is HEALTHY
```

we can see that fhe **salaries.csv** file has been divided into 16 blocks.

To understand the distribution of blocks among the Datanodes we can run the following command:

```console
[vagrant@node1 ~]$ hdfs fsck /hdfs-dir/salaries.csv -files -locations -blocks
Connecting to namenode via http://node1.example.com:50070/fsck?ugi=vagrant&files=1&locations=1&blocks=1&path=%2Fhdfs-dir%2Fsalaries.csv
FSCK started by vagrant (auth:SIMPLE) from /192.168.199.2 for path /hdfs-dir/salaries.csv at Mon Jun 15 23:53:45 UTC 2020
/hdfs-dir/salaries.csv 16257213 bytes, replicated: replication=3, 16 block(s):  OK
0. BP-2031746174-192.168.199.2-1591961399762:blk_1073741995_1178 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
1. BP-2031746174-192.168.199.2-1591961399762:blk_1073741996_1179 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
2. BP-2031746174-192.168.199.2-1591961399762:blk_1073741997_1180 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
3. BP-2031746174-192.168.199.2-1591961399762:blk_1073741998_1181 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
4. BP-2031746174-192.168.199.2-1591961399762:blk_1073741999_1182 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
5. BP-2031746174-192.168.199.2-1591961399762:blk_1073742000_1183 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
6. BP-2031746174-192.168.199.2-1591961399762:blk_1073742001_1184 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
7. BP-2031746174-192.168.199.2-1591961399762:blk_1073742002_1185 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK]]
8. BP-2031746174-192.168.199.2-1591961399762:blk_1073742003_1186 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
9. BP-2031746174-192.168.199.2-1591961399762:blk_1073742004_1187 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
10. BP-2031746174-192.168.199.2-1591961399762:blk_1073742005_1188 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
11. BP-2031746174-192.168.199.2-1591961399762:blk_1073742006_1189 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
12. BP-2031746174-192.168.199.2-1591961399762:blk_1073742007_1190 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
13. BP-2031746174-192.168.199.2-1591961399762:blk_1073742008_1191 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
14. BP-2031746174-192.168.199.2-1591961399762:blk_1073742009_1192 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
15. BP-2031746174-192.168.199.2-1591961399762:blk_1073742010_1193 len=528573 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]


Status: HEALTHY
 Number of data-nodes:  3
 Number of racks:               1
 Total dirs:                    0
 Total symlinks:                0

Replicated Blocks:
 Total size:    16257213 B
 Total files:   1
 Total blocks (validated):      16 (avg. block size 1016075 B)
 Minimally replicated blocks:   16 (100.0 %)
 Over-replicated blocks:        0 (0.0 %)
 Under-replicated blocks:       0 (0.0 %)
 Mis-replicated blocks:         0 (0.0 %)
 Default replication factor:    3
 Average block replication:     3.0
 Missing blocks:                0
 Corrupt blocks:                0
 Missing replicas:              0 (0.0 %)

Erasure Coded Block Groups:
 Total size:    0 B
 Total files:   0
 Total block groups (validated):        0
 Minimally erasure-coded block groups:  0
 Over-erasure-coded block groups:       0
 Under-erasure-coded block groups:      0
 Unsatisfactory placement block groups: 0
 Average block group size:      0.0
 Missing block groups:          0
 Corrupt block groups:          0
 Missing internal blocks:       0
FSCK ended at Mon Jun 15 23:53:45 UTC 2020 in 3 milliseconds


The filesystem under path '/hdfs-dir/salaries.csv' is HEALTHY
```

By inspecting a line (refferred to block 0) we can see that

```log
0. BP-2031746174-192.168.199.2-1591961399762:blk_1073741995_1178 len=1048576 Live_repl=3  [DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]]
```

- blk_1073741995_1178 = the block id
- len=1048576 is 1Mb circa
- Live_repl=3 is replicated three times
- [DatanodeInfoWithStorage[192.168.199.4:50010,DS-6cacbc28-5ee9-45d5-a098-6084f9f771d4,DISK], DatanodeInfoWithStorage[192.168.199.3:50010,DS-f86177ce-37e8-4afc-b957-36047c6990bc,DISK], DatanodeInfoWithStorage[192.168.199.2:50010,DS-0ef6196f-ba80-46cf-b9be-5a05e07dd7ca,DISK]] are the Datanodes holding the block replicas

By finding the blockid on the node1 we can see how Hadoop stores the block

```console
[vagrant@node1 ~]$ sudo find / -name "blk_1073741995*"
/hadoop/hdfs/data/current/BP-2031746174-192.168.199.2-1591961399762/current/finalized/subdir0/subdir0/blk_1073741995_1178.meta
/hadoop/hdfs/data/current/BP-2031746174-192.168.199.2-1591961399762/current/finalized/subdir0/subdir0/blk_1073741995
```

The two output lines show that a single block has a metadata file and a file containing the actual block of data.

If you inspect the latter, you can see that the data has been cut around the block dimension (1Mb)


```console
[vagrant@node1 ~]$ sudo cat /hadoop/hdfs/data/current/BP-2031746174-192.168.199.2-1591961399762/current/finalized/subdir0/subdir0/blk_1073741995
...
9851,ERIC SHAFFER,REGISTERED NURSE,92149.82,1069.72,4858.68,,98078.22,98078.22,2011,,San Francisco,
9852,LEO BERNSTEIN,POLICE OFFICER I,84009.21,3027.23,11030.81,,98067.25,98067.25,2011,,San Francisco,
9853,TAMI QUAN,AIRPORT ELECTRICIAN,96050.44,90.77,1920.0,,98061.21,98061.21,2011,,San Francisco,
9854,JOANNE D[vagrant@node1 ~]$ 
```