package io.github.julucinho.kafka_producer.factories;

import io.github.julucinho.kafka_producer.configs.Producer;
import io.github.julucinho.kafka_producer.configs.impl.ProducerImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProducerFactory {

    public static Producer<String, String> makeProducerFor(String topic){
        var producerConfigs = ProducerConfigsFactory.makeProducerConfigs();
        return new ProducerImpl(producerConfigs, topic);
    }

}
