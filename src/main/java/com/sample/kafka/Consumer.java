package com.sample.kafka;

import com.sample.SampleAPI;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.sample.kafka.Producer.TOPIC;

@Slf4j
@Component
public class Consumer {
    @KafkaListener(topics = TOPIC)
    public void receive(ConsumerRecord<String, byte[]> record) {
        SampleAPI.UserRq rq = parseRq(record.value());

        if (rq == null) {
            return;
        }

        log.info("receive: {}", rq.getName());
    }

    private SampleAPI.UserRq parseRq(byte[] data) {
        try {
            return SampleAPI.UserRq.newBuilder()
                    .mergeFrom(data)
                    .build();
        } catch (Exception e) {
            log.error("Check *.proto file. Cannot parse data", e);
        }

        return null;
    }
}
