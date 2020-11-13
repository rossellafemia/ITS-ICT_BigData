package it.sunnyvale.academy.sparkrdbms;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

/*
Run me:

$ mvn exec:exec -Dspark.master=local

$ spark-submit \
  --master yarn \
  --driver-memory 512m  \
  --executor-memory 512m \
  --class it.sunnyvale.academy.sparkrdbms.Main \
  --deploy-mode cluster \
  target/spark-rdbms-1.0-SNAPSHOT.jar
*/
public class Main {

    /* 3-nodes cluster */
    //public static final String MYSQL_IP = "192.168.199.2";

    /* Single node cluster */
    public static final String MYSQL_IP = "192.168.199.10";

    public static void main(String[] args) {

        SparkSession spark = SparkSession
                .builder()
                .appName("Search in Strava activities")
                .getOrCreate();

        Dataset<Row> df = spark
                .read()
                .format("jdbc")
                .option("url","jdbc:mysql://"+MYSQL_IP+":3306/employees")
                .option("driver","com.mysql.jdbc.Driver")
                .option("dbtable","employees")
                .option("user","employees")
                .option("password","employeespassword")
                .load();

        df.createOrReplaceTempView("employees");

        // All employees with the name starting with L (DataFrame API)
        System.out.println(String.format("\n=== All employees with the name starting with L (DataFrame API) ==="));
        df
                .filter(col("first_name").startsWith("L"))
                .show();

        // All employees with the name starting with L (SQL Query)
        System.out.println(String.format("\n=== All employees with the name starting with L (SQL Query) ==="));
        spark
                .sql(
                        "SELECT * " +
                        "FROM employees " +
                        "WHERE SUBSTRING(first_name,1,1) = 'L' "
                )
                .show();

    }
}
