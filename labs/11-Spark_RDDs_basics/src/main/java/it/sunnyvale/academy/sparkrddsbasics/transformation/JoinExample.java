package it.sunnyvale.academy.sparkrddsbasics.transformation;

import it.sunnyvale.academy.sparkrddsbasics.utils.RDDUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import scala.Tuple2;

/*
Run me:

$ mvn exec:exec -Dspark.master=local -P JoinExample

$ spark-submit \
  --master yarn \
  --class it.sunnyvale.academy.sparkrddsbasics.transformation.JoinExample \
  --deploy-mode cluster \
  target/spark-rdds-basics-1.0-SNAPSHOT.jar

 */
public class JoinExample {

    /*
     * rightOuterJoinUsersAndAddresses (RIGHT OUTER JOIN operation)
     * In right join, all the rows from the user RDD are returned irrespective of whether there is a match in the addresses RDD
     */
    public static void rightOuterJoinUsersAndAddresses(JavaPairRDD<Integer, String[]> keyedUsersRDD, JavaPairRDD<Integer, String[]> keyedAddressesRDD){
        // Join the two RDDs by Users' key
        JavaPairRDD<Integer, Tuple2<Optional<String[]>, String[]>> joined = keyedAddressesRDD.rightOuterJoin(keyedUsersRDD);

        // Print the result
        System.out.println("== RIGHT OUTER JOIN ==");
        RDDUtils.printPairRDDAsTable(joined);
        System.out.println();
    }

    /*
     * leftOuterJoinUsersAndAddresses (LEFT OUTER JOIN operation)
     * In left join, all the rows from the addresses RDD are returned irrespective of whether there is a match in the user RDD
     */
    public static void leftOuterJoinUsersAndAddresses(JavaPairRDD<Integer, String[]> keyedUsersRDD, JavaPairRDD<Integer, String[]> keyedAddressesRDD){
        // Join the two RDDs by Users' key
        JavaPairRDD<Integer, Tuple2<String[], Optional<String[]>>> joined = keyedAddressesRDD.leftOuterJoin(keyedUsersRDD);

        // Print the result
        System.out.println("== LEFT OUTER JOIN ==");
        RDDUtils.printPairRDDAsTable(joined);
        System.out.println();
    }

    /*
     * fullOuterJoinUsersAndAddresses (FULL OUTER JOIN operation)
     * Keep records from both the RDDs along with the associated null values in the respective users/addresses RDDs.
     */
    public static void fullOuterJoinUsersAndAddresses(JavaPairRDD<Integer, String[]> keyedUsersRDD, JavaPairRDD<Integer, String[]> keyedAddressesRDD){
        // Join the two RDDs by Users' key
        JavaPairRDD<Integer, Tuple2<Optional<String[]>, Optional<String[]>>> joined = keyedAddressesRDD.fullOuterJoin(keyedUsersRDD);

        // Print the result
        System.out.println("== FULL OUTER JOIN ==");
        RDDUtils.printPairRDDAsTable(joined);
        System.out.println();
    }

    /*
     * joinUsersAndAddresses (INNER JOIN operation)
     * Basically removes all the things that are not common in both the RDD (i.e. users not belonging to an address
     * or addresses with an unknown user)
     */
    public static void joinUsersAndAddresses(JavaPairRDD<Integer, String[]> keyedUsersRDD, JavaPairRDD<Integer, String[]> keyedAddressesRDD){
        // Join the two RDDs by Users' key
        JavaPairRDD<Integer, Tuple2<String[], String[]>> joined = keyedAddressesRDD.join(keyedUsersRDD);

        // Print the result
        System.out.println("== INNER JOIN ==");
        RDDUtils.printPairRDDAsTable(joined);
        System.out.println();
    }

    public static void main(String[] args) {

        // Initialize Spark Context
        SparkConf conf = new SparkConf().setAppName("JoinExamples");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Read the users file and skip header line
        JavaRDD<String> usersRDD = sc.textFile("lab11_input/users.csv").filter(s -> !s.substring(0,1).equals("#"));

        // Read the addresses file and skip header line
        JavaRDD<String> addressesRDD = sc.textFile("lab11_input/addresses.csv").filter(s -> !s.substring(0,1).equals("#"));

        // Create a JavaPairRDD object
        JavaPairRDD<Integer, String[]> keyedUsersRDD = usersRDD.mapToPair(
                s-> new Tuple2(Integer.parseInt(s.split(",")[0]), s.split(",")[1])
        );

        // Create a JavaPairRDD object
        JavaPairRDD<Integer, String[]> keyedAddressesRDD = addressesRDD.mapToPair(
                s-> new Tuple2(Integer.parseInt(s.split(",")[1]), s.split(",")[2])
        );

        // joinUsersAndAddresses (INNER JOIN operation)
        joinUsersAndAddresses(keyedUsersRDD, keyedAddressesRDD);

        // rightOuterJoinUsersAndAddresses (RIGHT OUTER JOIN operation)
        rightOuterJoinUsersAndAddresses(keyedUsersRDD, keyedAddressesRDD);

        // leftOuterJoinUsersAndAddresses (LEFT OUTER JOIN operation)
        leftOuterJoinUsersAndAddresses(keyedUsersRDD, keyedAddressesRDD);

        // fullOuterJoinUsersAndAddresses (FULL OUTER JOIN operation)
        fullOuterJoinUsersAndAddresses(keyedUsersRDD, keyedAddressesRDD);
    }
}
