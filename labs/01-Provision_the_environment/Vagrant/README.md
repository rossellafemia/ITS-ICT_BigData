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

Looking at the standard output you may spot some weird red messages. This is normal, just wait for the Vagrant procedure to fisnish.

As soon as the procedure finishes to setup the VMs, point your browser to http://node1.example.com:8080 or http://localhost:8080 (the port 8080 is forward from your host machine to the node1)

The default login and password are **admin/admin**

Event when Vagrant finishes to provision the VMs, Ambari is still installing and starting packages on the cluster, the entire procedure may take up to 2 hours to complete so be patient.




