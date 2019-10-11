package com.learning.understandingjvm.seven.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author kian
 * @date 2019/8/6
 */
@Component
public class KafkaHealthIndicator implements HealthIndicator {

    private KafkaTemplate<String, String> kafka;

    @Autowired
    public KafkaHealthIndicator(KafkaTemplate<String, String> kafka) {
        this.kafka = kafka;
    }

    @Override
    public Health health() {
        try {
            kafka.send("kafka-health-indicator", "❥").get(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
