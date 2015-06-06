package com.djavafactory.webapp.controller;

import com.djavafactory.model.DonationItem;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Test;
import static org.junit.Assert.*;

public class DonationItemFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private DonationRequestItemFormController form;
    private DonationItem donationItem;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/donationItemform");
        request.addParameter("id", "-1");

        donationItem = form.showForm(request);
        assertNotNull(donationItem);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/donationItemform");
        request.addParameter("id", "-1");

        donationItem = form.showForm(request);
        assertNotNull(donationItem);

        request = newPost("/donationItemform");

        donationItem = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(donationItem).getBindingResult();
        form.onSubmit(donationItem, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/donationItemform");
        request.addParameter("delete", "");
        donationItem = new DonationItem();
        donationItem.setId(-2L);

        BindingResult errors = new DataBinder(donationItem).getBindingResult();
        form.onSubmit(donationItem, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
