
## Spark SQL  basics

This lab contains multiple examples about the basics of Spark SQL.

Here's a list about the example included:

- DataFrameOperations (example name: DataFrameOperations, fully qualified main class: it.sunnyvale.academy.sparksqlbasics.DataFrameOperations)
- SQLQueries (example name: SQLQueries, fully qualified main class: it.sunnyvale.academy.sparksqlbasics.SQLQueries)


## Prerequisites

To run the examples on your local machine, the following prerequisites must be met:

- JDK 1.8 or above must be installed
- Maven 3.6 or above must be installed

To run the examples on a YARN cluster, the following prerequisites must be met:

- Having completed labs 02 (Provision the environment) and 10 (Spark installation)

## Run examples locally

Compile the source code

```console
$ mvn clean &&  mvn package
```

Run the example of your choice

```console
$ mvn exec:exec \
  -Dspark.master=local \
  -P <EXAMPLE NAME>
```

Make sure to change **\<EXAMPLE NAME\>** with the real example's name before running the previous command (ie: WordCount).

## Run examples on YARN cluster

Go to path **ITS-ICT_BigData/labs/02-Provision_the_environment/Vagrant** and connect to node 1.

```console
$ vagrant ssh node1 
[vagrant@node1 ~]$ 
```

Move to this lab's home directory

```console
[vagrant@node1 ~]$ cd ITS-ICT_BigData/labs/12-Spark_SQL_basics
```

Create the lab input directory on HDFS

```console
[vagrant@node1]$ hadoop fs -mkdir lab12_input
```

To simplify the operation of loading the input datasets on HDFS, a script has been provided. Run it with the command:

```console
[vagrant@node1]$ ./copy_input_datasets.sh 
```

Copile and package the application

```console
[vagrant@node1]$ mvn clean && mvn package
```

Submit Spark job on the cluster

```console
[vagrant@node1]$ spark-submit \
  --master yarn \
  --driver-memory 256m  \
  --executor-memory 256m \
  --class <EXAMPLE FULLY QUALIFIED CLASS NAME> \
  --deploy-mode cluster \
  target/spark-sql-basics-1.0-SNAPSHOT.jar 
```

Make sure to change **\<EXAMPLE FULLY QUALIFIED MAIN CLASS NAME\>** with the real example's fully qualified main class name in previous command (ie: it.sunnyvale.academy.sparksqlbasics.SQLQueries).

To see the job's output run

```console
[vagrant@node1]$ yarn logs -applicationId <APPLICATION ID>
```

Application ID is showed as part of the `spark-submit` command (ie: application_1601154210621_0006)

To kill an application:

```console
[vagrant@node1]$ yarn application -kill <APPLICATION ID>
```



