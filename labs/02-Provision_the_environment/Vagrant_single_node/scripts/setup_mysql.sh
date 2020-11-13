sudo yum -y localinstall \
https://dev.mysql.com/get/mysql57-community-release-el7-8.noarch.rpm
sudo yum install -y mysql-community-server
sudo systemctl start mysqld.service

sudo mysql_upgrade

mysql -u root << EOF
DROP DATABASE IF EXISTS employees;
DROP USER IF EXISTS 'employees'@'localhost';
DROP USER IF EXISTS 'employees'@'';
CREATE DATABASE employees;
CREATE USER 'employees'@'localhost' IDENTIFIED BY 'employeespassword';
CREATE USER 'employees'@'' identified by 'employeespassword';
GRANT ALL PRIVILEGES ON employees.* TO 'employees'@'localhost';
GRANT ALL PRIVILEGES ON employees.* TO 'employees'@'';
FLUSH PRIVILEGES;
EOF

sudo systemctl restart mysqld.service 

mysql -u employees --password='employeespassword' << EOF
CREATE SCHEMA IF NOT EXISTS employees DEFAULT CHARACTER SET utf8 ;
EOF

sudo rm -rf /tmp/git/test_db
git clone https://github.com/datacharmer/test_db.git /tmp/git/test_db
cd /tmp/git/test_db
mysql -u root --password='' employees < employees.sql
sudo rm -rf /tmp/git/test_db
