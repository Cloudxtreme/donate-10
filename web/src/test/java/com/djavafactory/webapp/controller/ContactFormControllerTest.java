package com.djavafactory.webapp.controller;

import com.djavafactory.webapp.controller.BaseControllerTestCase;
import com.djavafactory.model.Contact;
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

public class ContactFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private ContactFormController form;
    private Contact contact;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/contactform");
        request.addParameter("id", "-1");

        contact = form.showForm(request);
        assertNotNull(contact);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/contactform");
        request.addParameter("id", "-1");

        contact = form.showForm(request);
        assertNotNull(contact);

        request = newPost("/contactform");

        contact = form.showForm(request);
        // update required fields
        contact.setEmail("CyEbHyDyQxMnFyWnUvBpIfXcSvLtAjKpYiHdJsInCbXgNrGrQmKjRzIuNwTbBfYrCgFzFvBwPqDyDmLyGuUiCsYeGlDuHcKcZzIwXsHmAyMuUqVcCnHiYeXhRgXxVzGjBwRlSnDoSbRyZyGxZkOlYrCrBqUrLvClUwHhUdJoYfGzZpZoXgQjBiQnLiBsSaRhEgHaHlVuUiIqJdCcBlAtVaMcWwXhQaTmLtUdSqJqWuMrNrHgFjYcVkLjAwXwKgG");
        contact.setMessage("GzTsLrWvPaSbWuKmPfLuLjFjVfXzWoDxMpUyRkIjZjCpUjJcTxIaYmVnSoHnRcMyOxKtKhGaMkKoAyIjDcEbBeAgIeNoZdEbNbBiAvMoKxQhMgEbMyJtKxBcPyLlIrXrLqMyBqCkRdCfHdGfGqJsRhBsEmFvWqJoIzGuZuHeMmXhIkFiRzYdAcInHbCnJeSjXnIrVqPxBaPuWrZuLrKzFoMgJeSxNfYtUnJmNhHjRuUgLqYjOnLcTqFzLcQrNhY");
        contact.setName("QaAuBxDeLrVnPbJnFhCxTlBuGhUvMvKoPuAiPsWgFkUhToAuWpNxLyAjOiCvCcQxUeZyTcGfSnSyFkUpSqMjAcOeXdZxUsJcToNrLaBrMjAhDkBsPoSpTrAeZyJkXaGzUzGyWgWvBySeMzVkQrJaChUnCsUqPjHiKvEdIjUmRoAaMpHcKsZqHrGgTdSrDaZfCtXjZfWgNqAfJjXiGiPfLhAvHzYqZkZoGxPjIiWuVnTyKaNdAzXwXtLjVvCfRtV");

        BindingResult errors = new DataBinder(contact).getBindingResult();
        form.onSubmit(contact, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/contactform");
        request.addParameter("delete", "");
        contact = new Contact();
        contact.setId(-2L);

        BindingResult errors = new DataBinder(contact).getBindingResult();
        form.onSubmit(contact, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
