# Counting succeeded SpaceX launches with Spark

Count the total number of succeeded SpaceX lanches using the dataset [spacex_launches.csv](../datasets/spacex_launches.csv).

Please have a look of the first row to discover the column headers (**launch_success** is the 4th column).

As a reference fot this assignment, please have a look of the lab [11 - Spark RDDs basics](../labs/11-Spark_RDDs_basics/README.md)

In order to simplify the class execution using **right-click** -> **Run** on IntelliJ Idea, when creating the `SparkConf` object, configure it using `.setMaster("local")`.

So for example:

```java
// Create the SparkConf object
SparkConf conf = new SparkConf()
                    // Set the application name
                    .setAppName("MyApplication")
                    // Configure Spark to run locally instead of on a real cluster
                    .setMaster("local");
// Create the JavaSparkContext object using SparkConf as configured before
JavaSparkContext sc = new JavaSparkContext(conf);
// Program the remaining logic here
```

Solution is provided [here](./solution)