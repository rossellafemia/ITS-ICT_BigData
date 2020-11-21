
# 1st cluster topology HDP 3.1 (YARN, HDFS, MapReduce, Zookeeper) install only
#
curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://hdp-singlenode.example.com:8080/api/v1/blueprints/multinode-hdp  -d @/vagrant/blueprint/blueprint.json
sleep 20
curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://hdp-singlenode.example.com:8080/api/v1/clusters/multinode-hdp  -d @/vagrant/blueprint/clustertemplate.json

