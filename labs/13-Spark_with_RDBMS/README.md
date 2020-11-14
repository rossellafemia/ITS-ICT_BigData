# Spark with RDBMS

Using Apache Spark on top of the existing MySQL server(s) (without the need to export or even stream data to Spark or Hadoop), we can increase query performance more than ten times.
You can also use the Spark cache function to cache the whole MySQL query results table.

The idea is simple: Spark can read MySQL data via JDBC and can also execute SQL queries, so we can connect it directly to MySQL and run the queries. Why is this faster? For long-running (i.e., reporting or BI) queries, it can be much faster as Spark is a massively parallel system. MySQL can only use one CPU core per query, whereas Spark can use all cores on all cluster nodes. 

## Setup MySQL DB on the VM

To setup MySQL DB on the and import data into it, run the following command after having connected to the VM.

```console
$ ITS-ICT_BigData/labs/02-Provision_the_environment/Vagrant/scripts/setup_mysql.sh
```

This will create a table like this:

```
$ mysql -h 192.168.199.10 -u root --password="" <<EOF
desc employees.employees;
EOF

+------------+---------------+------+-----+---------+-------+
| Field      | Type          | Null | Key | Default | Extra |
+------------+---------------+------+-----+---------+-------+
| emp_no     | int(11)       | NO   | PRI | NULL    |       |
| birth_date | date          | NO   |     | NULL    |       |
| first_name | varchar(14)   | NO   |     | NULL    |       |
| last_name  | varchar(16)   | NO   |     | NULL    |       |
| gender     | enum('M','F') | NO   |     | NULL    |       |
| hire_date  | date          | NO   |     | NULL    |       |
+------------+---------------+------+-----+---------+-------+
6 rows in set (0.01 sec)
```

The database is available at:

\<VM_IP\>:3306
user: "root"
pass: ""

user: employees
pass: employeespassword

db name: employeess


To run this lab locally 

```console
$ mvn exec:exec -Dspark.master=local
...
=== All employees with the name starting with L (DataFrame API) ===
+------+----------+----------+-----------+------+----------+
|emp_no|birth_date|first_name|  last_name|gender| hire_date|
+------+----------+----------+-----------+------+----------+
| 10019|1953-01-23|   Lillian|    Haddadi|     M|1999-04-30|
| 10046|1960-07-23|    Lucien|  Rosenbaum|     M|1992-06-20|
| 10108|1952-04-07|    Lunjin|     Giveon|     M|1986-10-02|
| 10224|1954-05-17|      Leon|  Trogemann|     M|1988-01-09|
| 10233|1954-04-01|      Lein|    Vendrig|     F|1985-07-05|
| 10242|1964-02-22|    Lunjin|      Ozeri|     M|1988-01-18|
| 10278|1955-03-09|   Lubomir|     Nitsch|     M|1991-05-17|
| 10301|1962-08-26|    Lucien|Staudhammer|     M|1988-05-23|
| 10383|1963-11-13|    Leucio|     Aumann|     M|1991-06-19|
| 10411|1956-07-10|    Lidong|     Klerer|     F|1989-09-02|
| 10492|1957-04-03|     Lobel|  Kumaresan|     M|1988-04-24|
| 10543|1962-10-06|      Lein|   Lichtman|     M|1998-10-16|
| 10597|1961-05-07|    Lucien|     Schaad|     F|1990-04-01|
| 10625|1958-02-08|    Leszek|   Petereit|     F|1985-10-31|
| 10629|1954-03-23|     Lalit|  Francisci|     F|1986-01-30|
| 10687|1961-07-25|      Leon|     Kaiser|     F|1990-03-13|
| 10692|1960-08-11|    Larisa|       Bage|     M|1993-03-22|
| 10762|1965-01-19|      Lech|     Himler|     M|1992-01-21|
| 10810|1957-10-23|     Lijie|       Lunn|     F|1994-09-07|
| 10878|1952-06-13|   Lakshmi|    Deville|     M|1988-02-25|
+------+----------+----------+-----------+------+----------+
only showing top 20 rows

=== All employees with the name starting with L (SQL Query) ===
+------+----------+----------+-----------+------+----------+
|emp_no|birth_date|first_name|  last_name|gender| hire_date|
+------+----------+----------+-----------+------+----------+
| 10019|1953-01-23|   Lillian|    Haddadi|     M|1999-04-30|
| 10046|1960-07-23|    Lucien|  Rosenbaum|     M|1992-06-20|
| 10108|1952-04-07|    Lunjin|     Giveon|     M|1986-10-02|
| 10224|1954-05-17|      Leon|  Trogemann|     M|1988-01-09|
| 10233|1954-04-01|      Lein|    Vendrig|     F|1985-07-05|
| 10242|1964-02-22|    Lunjin|      Ozeri|     M|1988-01-18|
| 10278|1955-03-09|   Lubomir|     Nitsch|     M|1991-05-17|
| 10301|1962-08-26|    Lucien|Staudhammer|     M|1988-05-23|
| 10383|1963-11-13|    Leucio|     Aumann|     M|1991-06-19|
| 10411|1956-07-10|    Lidong|     Klerer|     F|1989-09-02|
| 10492|1957-04-03|     Lobel|  Kumaresan|     M|1988-04-24|
| 10543|1962-10-06|      Lein|   Lichtman|     M|1998-10-16|
| 10597|1961-05-07|    Lucien|     Schaad|     F|1990-04-01|
| 10625|1958-02-08|    Leszek|   Petereit|     F|1985-10-31|
| 10629|1954-03-23|     Lalit|  Francisci|     F|1986-01-30|
| 10687|1961-07-25|      Leon|     Kaiser|     F|1990-03-13|
| 10692|1960-08-11|    Larisa|       Bage|     M|1993-03-22|
| 10762|1965-01-19|      Lech|     Himler|     M|1992-01-21|
| 10810|1957-10-23|     Lijie|       Lunn|     F|1994-09-07|
| 10878|1952-06-13|   Lakshmi|    Deville|     M|1988-02-25|
+------+----------+----------+-----------+------+----------+
only showing top 20 rows

...

Process finished with exit code 0
```

To run this lab on Hadoop cluster, use this command in the VM where `spark-submit` tool has been installed previously: 

```console
$ mvn package && spark-submit \
  --master yarn \
  --driver-memory 512m  \
  --executor-memory 512m \
  --class it.sunnyvale.academy.sparkrdbms.Main \
  --deploy-mode cluster \
  target/spark-rdbms-1.0-SNAPSHOT.jar
```