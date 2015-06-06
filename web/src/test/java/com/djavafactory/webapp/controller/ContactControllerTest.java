package com.djavafactory.webapp.controller;

import com.djavafactory.service.ContactManager;
import com.djavafactory.model.Contact;

import com.djavafactory.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactControllerTest extends BaseControllerTestCase {
    @Autowired
    private ContactController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("contactList"));
        assertTrue(((List) m.get("contactList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        ContactManager contactManager = (ContactManager) applicationContext.getBean("contactManager");
        contactManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("contactList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}