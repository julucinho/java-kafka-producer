package io.github.julucinho.kafka_producer.configs.impl;

import io.github.julucinho.kafka_producer.configs.AbstractProducer;
import io.github.julucinho.kafka_producer.configs.ProducerConfigs;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerImpl extends AbstractProducer<String, String> {

    public ProducerImpl(ProducerConfigs producerProperties, String topicName) {
        super(producerProperties, topicName);
    }

    @Override
    public ProducerRecord<String, String> makeRecord(String key, String value) {
        return new ProducerRecord<>(this.topicName, key, value);
    }

    @Override
    public ProducerRecord<String, String> makeRecord(String value) {
        return new ProducerRecord<>(this.topicName, value);
    }

    @Override
    public void send(ProducerRecord<String, String> producerRecord) {
        this.getKafkaProducer().send(producerRecord);
        this.finishProducer();
    }

    @Override
    public void sendRecordOf(String key, String value) {
        var producerRecord = this.makeRecord(key, value);
        this.getKafkaProducer().send(producerRecord);
        this.finishProducer();
    }

    @Override
    public void sendRecordOf(String value) {
        var producerRecord = this.makeRecord(value);
        this.getKafkaProducer().send(producerRecord);
        this.finishProducer();
    }

    @Override
    public void finishProducer() {
        this.getKafkaProducer().flush();
        this.getKafkaProducer().close();
    }
}
