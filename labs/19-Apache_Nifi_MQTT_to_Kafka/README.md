

Create Kafka topic

```
[vagrant@node1 ~]$ /usr/hdp/3.1.0.0-78/kafka/bin/kafka-topics.sh \
    --create \
    --topic nifi \
    --zookeeper node1.example.com:2181,node2.example.com:2181,node3.example.com:2181 \
    --partitions 1 \
    --replication-factor 1
```
Publish MQTT message

```
[vagrant@node1 ~]$ mosquitto_pub -h localhost -t test -m "test 123"
```

Start consuming Kafka messages

```
[vagrant@node1 ~]$ /usr/hdp/3.1.0.0-78/kafka/bin/kafka-console-consumer.sh \
    --topic nifi \
    --from-beginning \
    --bootstrap-server node1.example.com:6667
test 123
```

You should have received the message "test 123" to Kafka routed by NiFi.