#!/bin/bash

sudo curl https://downloads.apache.org/pig/latest/pig-0.17.0.tar.gz -o /opt/pig-0.17.0.tar.gz 

cd /opt
sudo tar xzf pig-0.17.0.tar.gz


echo "export PIG_HOME=/opt/pig/pig-0.17.0" >> /home/vagrant/.bash_profile
echo "export PATH=\$PATH:\$PIG_HOME/bin" >> /home/vagrant/.bash_profile
echo "export PIG_CLASSPATH=\"/etc/hadoop/+([0-9]).+([0-9]).+([0-9]).+([0-9])-+([0-9])/0\"" >> /home/vagrant/.bash_profile
echo "export JAVA_HOME=/usr" >> /home/vagrant/.bash_profile