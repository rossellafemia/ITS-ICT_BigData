package it.sunnyvale.hadoop.labs;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.File;
import java.io.IOException;

public class NewInfections {
    public static class MyMapper
            extends Mapper<Object, Text, Text, IntWritable> {


        @Override
        public void map(Object key, Text value, org.apache.hadoop.mapreduce.Mapper.Context context
        ) throws IOException, InterruptedException {

            String line = value.toString();


            // skip the first line containing headers only
            if(line.startsWith("#")){
                return;
            }

            String date = line.split(",")[0];
            String newInfections = line.split(",")[12];

            int newInfectionsInt = Integer.parseInt(newInfections);
            context.write(new Text(date), new IntWritable(newInfectionsInt));
        }
    }

    public static class MyReducer
            extends Reducer<Text,IntWritable,Text, IntWritable> {
        @Override
        public void reduce(Text key, Iterable<IntWritable> values,
                           Context context
        ) throws IOException, InterruptedException {
            int sumOfTheDay=0;
            for (IntWritable val : values) {
                int value = val.get();
                sumOfTheDay += value;
            }
            context.write(key,new IntWritable(sumOfTheDay));
        }
    }

    public static void main(String[] args) throws Exception {
        FileUtils.deleteDirectory(new File(args[1]));

        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "max new infections");
        job.setJarByClass(NewInfections.class);
        job.setMapperClass(MyMapper.class);
        job.setCombinerClass(MyReducer.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
