package io.github.julucinho.kafka_producer.configs;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public interface Producer<K, V> {

    KafkaProducer<K, V> getKafkaProducer();
    ProducerRecord<K, V> makeRecord(K key, V value);
    ProducerRecord<K, V> makeRecord(V value);
    void send(ProducerRecord<K, V> producerRecord);
    void sendRecordOf(K key, V value);
    void sendRecordOf(V value);
    void finishProducer();

}
