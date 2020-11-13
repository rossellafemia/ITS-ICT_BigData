# Search in Strava activities

Compile sources

```console
$ mvn clean && mvn package
```

Run the Main class locally

```console
$ mvn exec:exec
```

Run the Main class on Hadoop cluster

```console
$ spark-submit \
  --master yarn \
  --driver-memory 512m  \
  --executor-memory 512m \
  --class it.sunnyvale.academy.searchstrava.Main \
  --deploy-mode cluster \
  target/search-strava-1.0-SNAPSHOT.jar
```