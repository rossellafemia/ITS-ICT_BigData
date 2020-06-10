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

Event when Vagrant finishes to provision the VMs, Ambari is still installing and starting packages on the cluster, the entire procedure may take up to 2 hours to be completed.



