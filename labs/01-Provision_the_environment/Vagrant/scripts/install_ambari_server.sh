#!/bin/sh
# Disable SELinux
setenforce 0

yum -y install wget

# Download Ambari Repository
#wget -nv https://archive.cloudera.com/p/ambari/centos7/2.x/updates/2.7.5.0/ambari.repo -O /etc/yum.repos.d/ambari.repo
wget -nv http://public-repo-1.hortonworks.com/ambari/centos7/2.x/updates/2.7.4.0/ambari.repo -O /etc/yum.repos.d/ambari.repo

# Install java-1.8
yum -y install java-1.8.0-openjdk java-1.8.0-openjdk-devel

# Install ambari-server
yum -y install ambari-server

# bootstrap ambari-server
ambari-server setup -s --java-home=/usr/lib/jvm/jre/

# disable ssl checks
sed -i 's/verify=platform_default/verify=disable/' /etc/python/cert-verification.cfg || echo "could not disable ssl checks"

# extend default timeouts
sudo perl -p -i -e "s/agent\.package\.install\.task\.timeout=1800/agent\.package\.install\.task\.timeout=14400/g" /etc/ambari-server/conf/ambari.properties 
sudo perl -p -i -e "s/agent\.task\.timeout=900/agent\.task\.timeout=3600/g" /etc/ambari-server/conf/ambari.properties 


# start ambari-server
ambari-server start

sh /vagrant/scripts/install_ambari_agent.sh
