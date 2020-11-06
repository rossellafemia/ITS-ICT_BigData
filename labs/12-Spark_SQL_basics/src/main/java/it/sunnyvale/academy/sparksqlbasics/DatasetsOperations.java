package it.sunnyvale.academy.sparksqlbasics;


import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/*
Run me:

$ mvn exec:exec \
  -Dpark.master=local \
  -P DatasetsOperations

$ spark-submit \
  --master yarn \
  --driver-memory 512m  \
  --executor-memory 512m \
  --class it.sunnyvale.academy.sparksqlbasics.DatasetsOperations \
  --deploy-mode cluster \
  target/spark-sql-basics-1.0-SNAPSHOT.jar

*/
public class DatasetsOperations {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        Dataset<Row> ds = spark
                .read()
                .option("multiline", "true")
                .json("lab12_input/users.json");





    }
}
