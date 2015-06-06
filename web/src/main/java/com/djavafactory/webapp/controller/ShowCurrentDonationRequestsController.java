package com.djavafactory.webapp.controller;

import com.djavafactory.model.DonationItem;
import com.djavafactory.service.DonationItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author aka
 * @date: 06 June 2015
 */
@Controller
@RequestMapping("/showCurrentDonationRequests*")
public class ShowCurrentDonationRequestsController extends BaseFormController {

    @Autowired
    DonationItemManager donationItemManager;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm(){

        ModelAndView mv = new ModelAndView("currentDonations");
        List<DonationItem> currentDonationItems = donationItemManager.getActiveItems();

        mv.addObject("currentDonationItems",currentDonationItems);
        return mv;

    }
}
