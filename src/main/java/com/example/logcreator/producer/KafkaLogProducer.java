package com.example.logcreator.producer;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class KafkaLogProducer {
    public static KafkaProducer<String, String> producer = null;

    public static void KafkaData(String key, String value) throws Exception{

        Properties properties = new Properties();

        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(properties);
        Runtime.getRuntime().addShutdownHook(new Thread(producer::close));
    }
}
