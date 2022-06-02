package com.minejava.redisexample.queue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber  implements MessageListener {

    public static List<String> messageList = new ArrayList<>();

    @Override
    public void onMessage(final Message message, final byte[] pattern) {
        // DO Auto-generated method stub
        messageList.add(message.toString());
        System.out.println("Message received: " + new String(message.getBody()));
    }
    
}
