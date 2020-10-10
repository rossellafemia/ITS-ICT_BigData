package it.sunnyvale.academy.sparkrddsbasics.transformation;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
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
     * joinUsersAndAddresses
     */
    public static void joinUsersAndAddresses(JavaSparkContext sc){

        // Read the users file
        JavaRDD<String> usersRDD = sc.textFile("lab11_input/users.csv");

        // Filter out header row starting with '#'
        JavaRDD<String>  filteredUsersRDD = usersRDD.filter(s -> !s.substring(0,1).equals("#"));

        // Create a JavaPairRDD object
        JavaPairRDD<Integer, String[]> keyedUsersRDD = filteredUsersRDD.mapToPair(
                s-> new Tuple2(Integer.parseInt(s.split(",")[0]), s.split(",")[1])
        );

        System.out.println(keyedUsersRDD.collectAsMap());


        // Read the addresses file
        JavaRDD<String> addressesRDD = sc.textFile("lab11_input/addresses.csv");

        // Filter out header row starting with '#'
        JavaRDD<String>  filteredAddressesRDD = addressesRDD.filter(s -> !s.substring(0,1).equals("#"));

        // Create a JavaPairRDD object
        JavaPairRDD<Integer, String[]> keyedAddressesRDD = filteredAddressesRDD.mapToPair(
                s-> new Tuple2(Integer.parseInt(s.split(",")[1]), s.split(",")[2])
        );

        // Print the
        System.out.println(keyedAddressesRDD.collectAsMap());


        // Join the two RDDs by Users' key
        JavaPairRDD<Integer, Tuple2<String[], String[]>> joined = keyedAddressesRDD.join(keyedUsersRDD);

        System.out.println(joined.collectAsMap());

    }



    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("MapExamples");
        JavaSparkContext sc = new JavaSparkContext(conf);

        joinUsersAndAddresses(sc);
    }
}
