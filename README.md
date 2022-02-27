# kafka-consumer-service
Apache Kafka Consumer Service

##Kafka Consumer Creation
##Create Kafka Topic via Console For Mac and Linux
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka_example
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka_model_json

##For Windows machine: 
.\bin\windows\kafka-topics.bat –create –zookeeper localhost:2181 –replication-factor 1 –partitions 1 –topic kafka_example
.\bin\windows\kafka-topics.bat –create –zookeeper localhost:2181 –replication-factor 1 –partitions 1 –topic kafka_model_json

##Publish to the Kafka Topic via Console For Mac and Linux
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic kafka_example
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic kafka_model_json

##Publish to the Kafka Topic via Console For windows
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic kafka_example
## Use Simple String message for the Input Request
>Welcome to Apache Kafka Example

.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic kafka_model_json
## Use this JSON as the Input Request
>{"name":"Bhola Kumar","department":"IT Engineering","salary": 40000.00,"address":"Grugaon"}
