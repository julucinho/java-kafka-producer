package io.github.julucinho.kafka_producer.configs;

import lombok.Getter;
import org.apache.kafka.clients.producer.KafkaProducer;

@Getter
public abstract class AbstractProducer<K, V> implements Producer<K, V>{

    protected final KafkaProducer<K, V> kafkaProducer;
    protected final ProducerConfigs producerProperties;
    protected final String topicName;

    protected AbstractProducer(ProducerConfigs producerProperties, String topicName) {
        this.producerProperties = producerProperties;
        this.topicName = topicName;
        this.kafkaProducer = new KafkaProducer<>(producerProperties.getPropertiesForProducer());
    }
}
