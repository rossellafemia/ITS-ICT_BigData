package it.sunnyvale.academy.wifistats;

import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

/*
Run me:

$ mvn exec:exec -Dspark.master=local

$ spark-submit \
  --master yarn \
  --driver-memory 512m  \
  --executor-memory 512m \
  --class it.sunnyvale.academy.wifistats.Main \
  --deploy-mode cluster \
  target/wifi-stats-1.0-SNAPSHOT.jar

*/
public class Main {

    public static void main(String[] args) {

        SparkSession spark = SparkSession
                .builder()
                .appName("Search in Milan Wifi connections")
                .getOrCreate();

        Dataset<Row> df = spark
                .read()
                .option("multiline", "true")
                .option("inferSchema", "false")
                .option("nullValue", "null")
                .option("treatEmptyValuesAsNulls", "true")
                .json("ass9_input"+System.getProperty("file.separator")+"wifi_milano_daily_login_per_zone.json");


        df.createOrReplaceTempView("connections");

        // Highest number of connections in a single day (DataFrame API)
        System.out.println(String.format("\n=== Highest number of connections in a single day (DataFrame API) ==="));
        df
                .select(col("Data"), col("Valore"))
                .groupBy(col("Data"))
                .sum("Valore")
                .orderBy(desc("sum(Valore)"))
                .limit(1)
                .show();

        // Highest number of connections in a single day (DataFrame API) (SQL query)
        System.out.println(String.format("\n=== Highest number of connections in a single day (SQL query) ==="));
        spark
                .sql("SELECT " +
                        "Data, " +
                        "sum(Valore) as Connections " +
                        "from connections " +
                        "GROUP BY Data " +
                        "ORDER BY Connections DESC " +
                        "LIMIT 1")
                .show();

        // The zone with the highest average connections per day (DataFrame API)
        System.out.println(String.format("\n=== The zone with the highest average connections per day (DataFrame API) ==="));
        df
                .groupBy(col("Zona"))
                .avg("Valore")
                .orderBy(desc("avg(Valore)"))
                .limit(1)
                .show();

        // The zone with the highest average connections per day (DataFrame API) (SQL query)
        System.out.println(String.format("\n=== The zone with the highest average connections per day (SQL query) ==="));
        spark
                .sql(
                        "SELECT "
                        + "Zona, "
                        + "avg(Valore) as Connections "
                        + "from connections "
                        + "GROUP BY Zona "
                        + "ORDER BY Connections DESC "
                        + "LIMIT 1"
                    )
                .show();

        // The zone with the lowest average connections per day (DataFrame API)
        System.out.println(String.format("\n=== The zone with the lowest average connections per day (DataFrame API) ==="));
        df
                .groupBy(col("Zona"))
                .avg("Valore")
                .orderBy(asc("avg(Valore)"))
                .limit(1)
                .show();

        // The zone with the lowest average connections per day (SQL query)
        System.out.println(String.format("\n=== The zone with the lowest average connections per day (SQL query) ==="));
        spark
                .sql(
                        "SELECT "
                                + "Zona, "
                                + "avg(Valore) as Connections "
                                + "from connections "
                                + "GROUP BY Zona "
                                + "ORDER BY Connections ASC "
                                + "LIMIT 1"
                )
                .show();

        // Sum of connections per day (DataFrame API)
        System.out.println(String.format("\n=== Sum of connections per day per day (DataFrame API) ==="));
        df
                .groupBy(col("Data"))
                .sum("Valore")
                .orderBy(to_date(col("Data")).desc())
                .show();

        // Sum of connections per day (SQL query)
        System.out.println(String.format("\n=== Sum of connections per day (SQL query) ==="));
        spark
                .sql(
                        "SELECT "
                                + "Data, "
                                + "sum(Valore) as Connections "
                                + "from connections "
                                + "GROUP BY Data "
                                + "ORDER BY to_date(Data) DESC "
                )
                .show();
    }
}
