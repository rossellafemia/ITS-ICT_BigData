curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/blueprints/multinode-hdp -d @/vagrant/blueprint/blueprint2.json
sleep 20
curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/clusters/multinode-hdp -d @/vagrant/blueprint/clustertemplate2.json
