package it.sunnyvale.academy.sparkrddsbasics.transformation;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

/*
Run me:

$ mvn exec:exec \
  -Dspark.master=local \
  -P FilterExample

 */
public class FilterExample {

    /*
     * flatMapStringListUsingSpace
     */
    public static void filterStringsStartingByJ(JavaSparkContext sc){
        List<String> list = Arrays.asList("Java","Scala","Hello world", "Java helps", "ITS ICT");
        JavaRDD<String> collectionRDD = sc.parallelize(list);
        JavaRDD<String> rdd1 = collectionRDD.filter(s -> s.startsWith("J"));
        List<String> result  = rdd1.collect();
        for (String element : result) {
            System.out.println(element);
        }
    }



    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("FlatMapExamples");
        JavaSparkContext sc = new JavaSparkContext(conf);

        filterStringsStartingByJ(sc);
    }
}
