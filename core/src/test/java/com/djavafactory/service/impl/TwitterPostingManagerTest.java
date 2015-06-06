package com.djavafactory.service.impl;

import com.djavafactory.service.BaseManagerTestCase;
import com.djavafactory.service.SocialPostingManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by user on 6/6/2015.
 */
public class TwitterPostingManagerTest extends BaseManagerTestCase {
    @Autowired
    @Qualifier(value = "twitterPostingManagerImpl")
    SocialPostingManager twitterPostingManager;
    @Test
    public void testPost() throws Exception{
        twitterPostingManager.post("hello world");
    }
}
