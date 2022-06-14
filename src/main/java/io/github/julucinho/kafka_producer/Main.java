package io.github.julucinho.kafka_producer;

import io.github.julucinho.kafka_producer.factories.ProducerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Starting Kafka Producer App");
        var counter = 0;
        while (counter < 100){
            var producer = ProducerFactory.makeProducerFor("teste");
            producer.sendRecordOf("teste"+counter, "valor do teste"+counter);
            counter++;
        }
        log.info("Kafka Producer App has finished");
    }

}
