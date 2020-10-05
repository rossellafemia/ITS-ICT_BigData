package it.sunnyvale.academy.countingwords;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("WordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // load dataset
        JavaRDD<String> lines = sc.textFile("ass5_input/constitution.txt");

        // put each word in a line
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

        // remove empty lines
        JavaRDD<String> wordsFiltered = words.filter((s)-> !s.trim().equals(""));

        // just for debug, print words
        Iterator iter = wordsFiltered.toLocalIterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        // count words
        long count = wordsFiltered.count();

        System.out.println(count);
 
    }
}
