# Counting words using Spark RDDs

Clean and package the application


```console
$ mvn clean && mvn package          
```

Run the application locally

```console
$ mvn exec:exec \
  -Dspark.master=local \
  -P CountWords
```