# kafka-template

Asynchronous message send via Kafka from producer to consumer

1. Download and install [Kafka](https://kafka.apache.org/downloads)
1. Build - mvn clean install
1. Start zookeeper - bin/zookeeper-server-start.sh config/zookeeper.properties
1. Start Kafka - bin/kafka-server-start.sh config/server.properties
1. Run Application - ./run.sh
1. Check Kafka topics - bin/kafka-topics.sh --list --bootstrap-server localhost:9092

This tiny project is a sample of usage:
1. Java 13
1. [Spring Boot](https://spring.io/projects/spring-boot)
1. [Kafka](https://kafka.apache.org/)
1. [Protocol Buffers version 3](https://developers.google.com/protocol-buffers/docs/proto3)
1. [Lombok](https://projectlombok.org/)
1. [Logback](http://logback.qos.ch/)
1. [Checkstyle](https://checkstyle.org/checks.html)
1. [PMD](https://pmd.github.io/pmd-6.0.0/pmd_rules_java.html)
1. [Maven](https://maven.apache.org/)