package it.sunnyvale.academy.sparkrddsbasics.transformation;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Map {
    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("MapExamples");
        JavaSparkContext sc = new JavaSparkContext(conf);

        List<String> list = Arrays.asList("Java","Scala","Hello world", "Java helps", "ITS ICT");
        JavaRDD<String> collectionRDD = sc.parallelize(list);

        JavaRDD<String> mappedRDD = collectionRDD.map(s -> s.toUpperCase());

        List<String> uppercaseList  = mappedRDD.collect();

        for (String element : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
