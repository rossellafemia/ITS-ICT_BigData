
curl https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip -o apache-maven-3.6.3-bin.zip 
unzip apache-maven-3.6.3-bin.zip 
sudo cp -rf apache-maven-3.6.3 /opt/
echo "export PATH=\$PATH:/opt/apache-maven-3.6.3/bin" >> /home/vagrant/.bash_profile
rm -rf apache-maven-3.6.3 apache-maven-3.6.3-bin.zip 
