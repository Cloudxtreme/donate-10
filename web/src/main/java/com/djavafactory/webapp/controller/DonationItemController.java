package com.djavafactory.webapp.controller;

import com.djavafactory.dao.SearchException;
import com.djavafactory.service.DonationItemManager;
import com.djavafactory.model.DonationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/donationItems*")
public class DonationItemController {
    private DonationItemManager donationItemManager;

    @Autowired
    public void setDonationItemManager(DonationItemManager donationItemManager) {
        this.donationItemManager = donationItemManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(donationItemManager.search(query, DonationItem.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(donationItemManager.getAll());
        }
        return model;
    }
}
