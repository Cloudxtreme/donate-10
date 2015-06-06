package com.djavafactory.service.impl;

import com.djavafactory.service.BaseManagerTestCase;
import com.djavafactory.service.SocialPostingManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author aka
 * @date: 06 June 2015
 */
public class FacebookPostingManagerTest extends BaseManagerTestCase {

    @Autowired
    @Qualifier(value = "facebookPostingManagerImpl")
    SocialPostingManager facebookPostingManager;

    @Test
    public void testPost() throws Exception{
        facebookPostingManager.post("hello world");


    }



}
