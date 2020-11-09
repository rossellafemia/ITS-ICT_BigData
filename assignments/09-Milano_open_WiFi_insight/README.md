# Milano open WiFI insight

Using the data provided in this [dataset](../../datasets/wifi_milano_daily_login_per_zone.json), you have to search for:

- Highest number of connection in a single day
- The day in wich connections were at maximun 
- The zone with the highest average connections per day
- The zone with the lowest average connections per day
- Sum of connections per day (all zones)

The dataset indicates the number of navigation sessions carried out each day for each zone; a user who connects to WiFi in the morning and in the evening is counted twice. A user who connects with two separate devices, such as smartphones and tablets, is counted twice.

You may want to use Spark DataFrame and/or Spark SQL.

As a reference, use the lab [12 - Spark SQL basics](../labs/12-Spark_SQL_basics/README.md), the assignment [08 - Search in Strava activities](../assignment/08-Search_in_Strava_activities/README.md) solution and the Spark SQL documentation at https://spark.apache.org/docs/latest/sql-programming-guide.html


Solution is provided [here](./solution)