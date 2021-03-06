package com.minejava.redisexample.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

public class RedisMessagePublisher implements MessagePublisher{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ChannelTopic topic;

    public RedisMessagePublisher() {
    }
    
    
    public RedisMessagePublisher(final RedisTemplate<String, Object> redisTemplate, final ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }
    
    @Override
    public void publish(final String message) {
        // DONE Auto-generated method stub
        redisTemplate.convertAndSend(topic.getTopic(), message);
        
    }
    
}
