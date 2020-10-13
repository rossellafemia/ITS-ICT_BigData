package it.sunnyvale.academy.sparkrddsbasics.utils;

import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.Optional;
import scala.Tuple2;


public class RDDUtils {
    public static void printPairRDDAsTable(JavaPairRDD rdd){
        rdd.foreach(i -> System.out.println(i));
    }
}
