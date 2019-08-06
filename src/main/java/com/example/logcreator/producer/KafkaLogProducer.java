package com.example.logcreator.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

import java.util.Properties;
@Component
public class KafkaLogProducer {
    private static KafkaProducer<String, String> producer = null;

    public KafkaLogProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(properties);
        Runtime.getRuntime().addShutdownHook(new Thread(producer::close));
    }

    public static void KafkaData(String key, String value) throws Exception{
        System.out.println(" key : " + key + " value :  " + value);

            ProducerRecord<String, String> record =
                new ProducerRecord<>("data-in", key,value);

            producer.send(record, (RecordMetadata r, Exception e) -> {
                if(e != null){
                    System.out.println("Error producing to topic :" + r.topic());
                    e.printStackTrace();
                }
            });

            Thread.sleep(100);}
}
