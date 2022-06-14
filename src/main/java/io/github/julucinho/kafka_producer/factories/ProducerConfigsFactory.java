package io.github.julucinho.kafka_producer.factories;

import io.github.julucinho.kafka_producer.configs.ProducerConfigs;
import io.github.julucinho.kafka_producer.configs.impl.ProducerConfigsImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProducerConfigsFactory {

    public static ProducerConfigs makeProducerConfigs(){
        return new ProducerConfigsImpl();
    }

}
