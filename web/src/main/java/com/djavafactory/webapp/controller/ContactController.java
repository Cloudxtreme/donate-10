package com.djavafactory.webapp.controller;

import com.djavafactory.dao.SearchException;
import com.djavafactory.service.ContactManager;
import com.djavafactory.model.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contacts*")
public class ContactController {
    private ContactManager contactManager;

    @Autowired
    public void setContactManager(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(contactManager.search(query, Contact.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(contactManager.getAll());
        }
        return model;
    }
}
