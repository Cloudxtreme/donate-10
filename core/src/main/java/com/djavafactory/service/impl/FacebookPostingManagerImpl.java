package com.djavafactory.service.impl;

import com.djavafactory.service.SocialPostingManager;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author aka
 * @date: 06 June 2015
 */
@Component
public class FacebookPostingManagerImpl  implements SocialPostingManager{


    protected final Log log = LogFactory.getLog(getClass());

    private static final String ACCESS_TOKEN ="CAACEdEose0cBAIRWNXjYjYZCDiuro2qrCpRuelCGzUtHoZBHYjqVxqKVFwM6tQwkS6ZBatka5KW6C6HyJ8WlvKF0bzSvlQYUbXQ8eOdfEZCdU9CX4zxGMzD7h2E7wPRjJeTKh7M5fmUwneCZB0VUvZCsJAzzIYnEOVX2Wk8Dyl1hD8ruZBZBUj2C3s3c5S6Uqx6KpI2YdUNy97Mj7U4RbCHa";

    @Override
    public void post(String message) {

        log.debug("Posting message to page: " + message);

        FacebookClient facebookClient = new DefaultFacebookClient(ACCESS_TOKEN);
        FacebookType publishMessageResponse = facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", message));

        log.debug("Published message ID: " + publishMessageResponse.getId());

    }
}
