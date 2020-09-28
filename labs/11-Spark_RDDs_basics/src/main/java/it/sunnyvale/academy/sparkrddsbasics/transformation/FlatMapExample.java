package it.sunnyvale.academy.sparkrddsbasics.transformation;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

/*
Run me:

$ mvn exec:exec \                                                                                                                                                        ✔  88  17:12:22
  -Dspark.master=local \
  -P FlatMapExample

 */
public class FlatMapExample {

    /*
     * flatMapStringListUsingSpace
     */
    public static void flatMapStringListUsingSpace(JavaSparkContext sc){
        List<String> list = Arrays.asList("Java","Scala","Hello world", "Java helps", "ITS ICT");
        JavaRDD<String> collectionRDD = sc.parallelize(list);
        JavaRDD<String> mappedRDD = collectionRDD.flatMap(s -> Arrays.asList(s.split(" ")).iterator());
        List<String> uppercaseList  = mappedRDD.collect();
        for (String element : uppercaseList) {
            System.out.println(element);
        }
    }



    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("FlatMapExamples");
        JavaSparkContext sc = new JavaSparkContext(conf);

        flatMapStringListUsingSpace(sc);
    }
}
