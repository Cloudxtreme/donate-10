package com.djavafactory.service.impl;

import com.djavafactory.service.SocialPostingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

/**
 * Created by user on 6/6/2015.
 */
@Component
public class TwitterPostingManagerImpl implements SocialPostingManager {

    @Autowired
    @Qualifier(value = "twitterOutbound")
    public MessageChannel input;

    @Override
    public void post(String message) {
        Message m = new GenericMessage(message);
        input.send(m);

    }
}
