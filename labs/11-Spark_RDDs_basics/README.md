

hadoop fs -mkdir lab11_input

hadoop fs -put ../../datasets/constitution.txt lab11_input

mvn clean && mvn package

spark-submit \
  --class it.sunnyvale.academy.sparkrddsbasics.WordCount \
  --deploy-mode cluster \
  target/spark-rdds-basics-1.0-SNAPSHOT.jar 


yarn logs -applicationId \<application ID\> (yarn logs -applicationId application_1601154210621_0006)