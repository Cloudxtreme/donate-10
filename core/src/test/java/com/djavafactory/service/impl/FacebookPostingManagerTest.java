package com.djavafactory.service.impl;

import com.djavafactory.service.BaseManagerTestCase;
import com.djavafactory.service.SocialPostingManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author aka
 * @date: 06 June 2015
 */
public class FacebookPostingManagerTest extends BaseManagerTestCase {

    @Autowired
    SocialPostingManager facebookPostingManager;

    @Test
    public void testPost() throws Exception{
        try {
            facebookPostingManager.post("hello world");

        }catch(Exception e){
            e.printStackTrace();
        }


    }



}
