package com.minejava.redisexample;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.minejava.redisexample.queue.RedisMessagePublisher;
import com.minejava.redisexample.queue.RedisMessageSubscriber;


@SpringBootTest
@Testcontainers
public class RedisExampleApplicationTests {

    private RedisExampleApplication backend;

    @Autowired
    private RedisMessagePublisher publisher;

    // Define container class
    @Container
    public GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:5.0.3-alpine"));
        .withExposedPort(6379);

    @BeforeEach
    public void setUp() {
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();

        // Add a port for redis irrespective of where it 
        // running
        backend = new RedisExampleApplication();
    }

    @Test
    public void testOneMessage() throws Exception {
        String message = "Message " + UUID.randomUUID();
        publisher.publish(message);
        Thread.sleep(1000);
        assertTrue(RedisMessageSubscriber.messageList.get(0).contains(message));
    }
}
