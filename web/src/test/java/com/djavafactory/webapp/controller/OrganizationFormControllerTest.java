package com.djavafactory.webapp.controller;

import com.djavafactory.webapp.controller.BaseControllerTestCase;
import com.djavafactory.model.Organization;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrganizationFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private OrganizationFormController form;
    private Organization organization;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/organizationform");
        request.addParameter("id", "-1");

        organization = form.showForm(request);
        assertNotNull(organization);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/organizationform");
        request.addParameter("id", "-1");

        organization = form.showForm(request);
        assertNotNull(organization);

        request = newPost("/organizationform");

        organization = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(organization).getBindingResult();
        form.onSubmit(organization, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/organizationform");
        request.addParameter("delete", "");
        organization = new Organization();
        organization.setId(-2L);

        BindingResult errors = new DataBinder(organization).getBindingResult();
        form.onSubmit(organization, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
