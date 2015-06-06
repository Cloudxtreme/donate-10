package com.djavafactory.webapp.controller;

import com.djavafactory.service.DonationItemManager;
import com.djavafactory.model.DonationItem;

import com.djavafactory.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class DonationItemControllerTest extends BaseControllerTestCase {
    @Autowired
    private DonationItemController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("donationItemList"));
        assertTrue(((List) m.get("donationItemList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        DonationItemManager donationItemManager = (DonationItemManager) applicationContext.getBean("donationItemManager");
        donationItemManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("donationItemList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}