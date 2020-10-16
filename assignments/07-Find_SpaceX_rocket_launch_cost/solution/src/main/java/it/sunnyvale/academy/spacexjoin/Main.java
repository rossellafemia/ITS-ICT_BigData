package it.sunnyvale.academy.spacexjoin;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class Main {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("SpaceXJoin");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Load dataset
        JavaRDD<String> launches = sc.textFile("ass7_input/spacex_launches.csv").filter(s -> !s.substring(0,1).equals("#"));

        // Load dataset
        JavaRDD<String> rockets = sc.textFile("ass7_input/spacex_rockets.csv").filter(s -> !s.substring(0,1).equals("#"));

        // Create a JavaPairRDD object
        JavaPairRDD<String, String[]> keyedLaunchesRDD = launches.mapToPair(
                s-> new Tuple2(s.split(";", -1 )[5], s.split(";")[1])
        );

        //keyedLaunchesRDD.foreach(i -> System.out.println(i));

        // Create a JavaPairRDD object
        JavaPairRDD<String, String[]> keyedRocketsRDD = rockets.mapToPair(
                s-> new Tuple2(s.split(";", -1)[1], s.split(";")[2])
        );

        //keyedRocketsRDD.foreach(i -> System.out.println(i));

        JavaPairRDD<String, Tuple2<String[], String[]>> joined = keyedRocketsRDD.join(keyedLaunchesRDD);

        joined.foreach(i -> System.out.println(i));

    }
}
