# 1st cluster topology HDP 3.1 (YARN, HDFS, MapReduce, Zookeeper, Ambari Metrics, SmartSense) install & start
#
#curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/blueprints/multinode-hdp -d @/vagrant/blueprint/blueprint1.json
#sleep 20
#curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/clusters/multinode-hdp -d @/vagrant/blueprint/clustertemplate1.json


# 2nd cluster topology HDP 3.1 (YARN, HDFS, MapReduce, Zookeeper) install only
#
curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/blueprints/multinode-hdp -d @/vagrant/blueprint/blueprint2.json
sleep 20
curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/clusters/multinode-hdp -d @/vagrant/blueprint/clustertemplate2.json


# 3rd cluster topology HDP 3.1 (YARN, HDFS, MapReduce, Zookeeper, Ambari Metrics, SmartSense, Pig, Tez) install only
#
#curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/blueprints/multinode-hdp -d @/vagrant/blueprint/blueprint3.json
#sleep 20
#curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/clusters/multinode-hdp -d @/vagrant/blueprint/clustertemplate3.json
