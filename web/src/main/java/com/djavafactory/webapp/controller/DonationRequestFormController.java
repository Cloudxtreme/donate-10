package com.djavafactory.webapp.controller;

import com.djavafactory.dao.SearchException;
import com.djavafactory.model.DonationItem;
import com.djavafactory.model.DonationRequest;
import com.djavafactory.model.User;
import com.djavafactory.service.DonationRequestManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by toni on 6/6/15.
 */

@Controller
@RequestMapping("/donationRequestform*")
public class DonationRequestFormController extends BaseFormController {
    private DonationRequestManager donationRequestManager;

    @Autowired
    public void setDonationRequestManager(DonationRequestManager donationRequestManager) {
        this.donationRequestManager = donationRequestManager;
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected DonationRequest showForm(HttpServletRequest request)
            throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return donationRequestManager.get(new Long(id));
        }

        return new DonationRequest();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("donationRequest") final DonationRequest donationRequest,
                           final BindingResult errors, final HttpServletRequest request,
                           final HttpServletResponse response)
            throws Exception {
        log.debug("--------- saving - record -----------");

        HttpSession session = request.getSession();

        List<DonationRequest> donationRequestList = (List<DonationRequest>) session.getAttribute("DonationRequestList");

        for(DonationRequest item : donationRequestList) {
            log.debug("item : " + item);
            donationRequestManager.save(item);
        }

        session.setAttribute("DonationRequestList", null);

        return "donationRequests";
    }

    private List<DonationItem> generateDonationItemList(String itemListString) {
        String[] strDescQtyArr = itemListString.split(",");
        List<DonationItem> donationItemList = new ArrayList<>();

        for (int i = 0; i < strDescQtyArr.length; i++) {
            String[] item = strDescQtyArr[i].split("#");

            DonationItem donationItem = new DonationItem();
            donationItem.setItemDescription(item[0]);
            donationItem.setQty(Integer.valueOf(item[1]));

            donationItemList.add(donationItem);
        }

        return donationItemList;
    }
}
