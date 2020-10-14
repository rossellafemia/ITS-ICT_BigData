package it.sunnyvale.academy.sparkrddsbasics.transformation;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/*
Run me:

$ mvn exec:exec -Dspark.master=local -P ReduceExample

 */
public class ReduceExample {

    /*
     * sum
     */
    public static void sum(JavaSparkContext sc){
        List<Integer> list = Arrays.asList(1, 2,100, 49, 15, 1, 800, 87);
        JavaRDD<Integer> collectionRDD = sc.parallelize(list);
        JavaRDD<Integer> rdd1 = collectionRDD.distinct();
        long sum = rdd1.reduce((a,b)->a+b);
        System.out.println("== SUM ==");
        System.out.println(sum);
    }

    /*
     * max
     */
    public static void max(JavaSparkContext sc){
        List<Integer> list = Arrays.asList(1, 2,100, 49, 15, 1, 800, 87);
        JavaRDD<Integer> collectionRDD = sc.parallelize(list);
        JavaRDD<Integer> rdd1 = collectionRDD.distinct();
        long max = rdd1.reduce((a,b)->Math.max(a,b));
        System.out.println("== MAX ==");
        System.out.println(max);
    }

    /*
     * min
     */
    public static void min(JavaSparkContext sc){
        List<Integer> list = Arrays.asList(1, 2,100, 49, 15, 1, 800, 87);
        JavaRDD<Integer> collectionRDD = sc.parallelize(list);
        JavaRDD<Integer> rdd1 = collectionRDD.distinct();
        long min = rdd1.reduce((a,b)->Math.min(a,b));
        System.out.println("== MIN ==");
        System.out.println(min);
    }

    /*
     * avg ()
     * Combine values with the same key.
     public static void min(JavaSparkContext sc){
        List<Integer> list = Arrays.asList(1, 2,100, 49, 15, 1, 800, 87);
        JavaRDD<Integer> collectionRDD = sc.parallelize(list);
        JavaRDD<Integer> rdd1 = collectionRDD.distinct();
        long avg = rdd1.map(x => (x, 1))
.reduce((x, y) => (x._1 + y._1, x._2 + y._2))
        System.out.println(avg);
    } */

    /*
     * countOccurences (reduceByKey operation)
     * Combine values with the same key.
     */
    public static void countOccurences(JavaSparkContext sc){
        List<String> list = Arrays.asList("a", "b", "a", "a", "b", "b", "b", "b");
        JavaRDD<String> rdd = sc.parallelize(list);
        JavaPairRDD<String, Integer> rddX = rdd.mapToPair(e -> new Tuple2<String, Integer>(e, 1));
        JavaPairRDD<String, Integer> reduced = rddX.reduceByKey((accum, n) -> (accum + n));
        System.out.println("== COUNT ==");
        rddX.groupByKey();
        reduced.foreach(item -> System.out.println(item));
    }





    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("ReduceExample");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // reduce
        sum(sc);
        max(sc);
        min(sc);

        // reduceByKey
        countOccurences(sc);


    }
}
