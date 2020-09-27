# Spark installation

This lab is intended to guide you installing Spark on a previously set-up Ambari cluster

## Prerequisites

- Having completed the lab [02 - Provision the environment](../02-Provision_the_environment/README.md)
- MySQL JDBC driver must be setup on the node where Ambari server runs

If you have't installed MySQL JDBC driver on the Ambari server node, just jump on it and type:

```
$ sudo yum install mysql-connector-java -y
```

Then, let Ambari know about it 

```
$ sudo ambari-server setup --jdbc-db=mysql --jdbc-driver=/usr/share/java/mysql-connector-java.jar
```


## Install Spark

After having logged in into Ambari using the web UI, follow the visual instructions listed below:

Click on Add Service
![](./img/1.png)
Select Spark
![](./img/2.png)
Accept all the other components installation prompt
![](./img/3.png)
![](./img/4.png)
Distribute the new components on the cluster nodes (this image is just an example, you can spread them as you prefer)
![](./img/5.png)
Accept the default and click on NEXT
![](./img/6.png)
In order to proceed, type a password in the HIVE -> DATABASE section (not it down for later use)
![](./img/7.png)
Accept the proposal and click on PROCEED ANYWAY
![](./img/8.png)
Click on DEPLOY
![](./img/9.png)
After the installation, click on COMPLETE
![](./img/10.png)
Restart all the affected components as the warning message states
![](./img/11.png)

