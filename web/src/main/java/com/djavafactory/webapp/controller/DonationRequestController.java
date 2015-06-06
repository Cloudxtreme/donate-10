package com.djavafactory.webapp.controller;

import com.djavafactory.dao.SearchException;
import com.djavafactory.service.DonationRequestManager;
import com.djavafactory.model.DonationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/donationRequests*")
public class DonationRequestController {
    private DonationRequestManager donationRequestManager;

    @Autowired
    public void setDonationRequestManager(DonationRequestManager donationRequestManager) {
        this.donationRequestManager = donationRequestManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(donationRequestManager.search(query, DonationRequest.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(donationRequestManager.getAll());
        }
        return model;
    }
}
