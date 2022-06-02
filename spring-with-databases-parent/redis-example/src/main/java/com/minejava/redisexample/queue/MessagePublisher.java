package com.minejava.redisexample.queue;

public interface MessagePublisher {
    void publish(final String message);

}
