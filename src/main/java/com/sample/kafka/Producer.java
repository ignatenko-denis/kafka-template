package com.sample.kafka;

import com.sample.SampleAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Slf4j
@Component
public class Producer {
    public static final String TOPIC = "test-topic";

    @Autowired
    private KafkaTemplate<String, byte[]> template;

    @Scheduled(fixedDelay = 1000)
    public void send() {
        SampleAPI.UserRq rq = SampleAPI.UserRq.newBuilder()
                .setName("" + getRandom())
                .build();

        template.send(TOPIC, UUID.randomUUID().toString(), rq.toByteArray())
                .addCallback(new KafkaListenableFutureCallback());
        log.info("send: {}", rq.getName());
    }

    private int getRandom() {
        return new Random().nextInt(1000);
    }
}
