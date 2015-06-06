package com.djavafactory.webapp.controller;

import com.djavafactory.service.OrganizationManager;
import com.djavafactory.model.Organization;

import com.djavafactory.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrganizationControllerTest extends BaseControllerTestCase {
    @Autowired
    private OrganizationController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("organizationList"));
        assertTrue(((List) m.get("organizationList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        OrganizationManager organizationManager = (OrganizationManager) applicationContext.getBean("organizationManager");
        organizationManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("organizationList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}