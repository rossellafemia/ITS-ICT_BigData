# Vagrant

Every command listed below is supposed to be run from within the folder where this README.md file resides.

Install the Vagrant's hostmanager plugin 

```console
$ vagrant plugin install vagrant-hostmanager
```

Install the Vagrant's vbguest plugin 

```console
$ vagrant plugin install vagrant-vbguest
```

Provision the cluster 

```console
$ vagrant up
```

As soon as the procedure finishes to setup the cluster, point your browser to http://node1.example.com:8080 or http://localhost:8080 (the port 8080 is forward from your host machine to the node1)

The default login and password are **admin/admin**

```console
$ curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/blueprints/multinode-hdp -d @blueprint.json
```

```console
$ curl -vvv -H "X-Requested-By: ambari" -X POST -u admin:admin http://node1.example.com:8080/api/v1/clusters/multinode-hdp -d @clustertemplate.json
```

