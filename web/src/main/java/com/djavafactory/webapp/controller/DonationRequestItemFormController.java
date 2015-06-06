package com.djavafactory.webapp.controller;

import com.djavafactory.model.Address;
import com.djavafactory.model.DonationRequest;
import org.apache.commons.lang.StringUtils;
import com.djavafactory.service.DonationItemManager;
import com.djavafactory.model.DonationItem;
import com.djavafactory.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/donationRequestItemform*")
public class DonationRequestItemFormController extends BaseFormController {
    private DonationItemManager donationItemManager = null;

    @Autowired
    public void setDonationItemManager(DonationItemManager donationItemManager) {
        this.donationItemManager = donationItemManager;
    }

    public DonationRequestItemFormController() {
        setCancelView("redirect:donationItems");
        setSuccessView("redirect:donationItems");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    public DonationItem showForm(HttpServletRequest request)
    throws Exception {
        log.debug("-------I WANT IT HERE-----");
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return donationItemManager.get(new Long(id));
        }

        return new DonationItem();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void onSubmit(@ModelAttribute("donationItem") final DonationItem donationItem,
                         final BindingResult errors, final HttpServletRequest request,
                         final HttpServletResponse response)
    throws Exception {
        log.debug("--- POST ITEM HERE ---");

        Date dateRequired = dateFromDateString(request.getParameter("dateRequired"));
        Date dateExpire = dateFromDateString(request.getParameter("dateExpire"));
        String address = request.getParameter("address");
        String itemName = request.getParameter("itemName");
        Integer qty = Integer.valueOf(request.getParameter("itemQty"));


        log.debug("dateRequired : " + dateRequired );
        log.debug("dateExpire : " + dateExpire );
        log.debug("address : " + address );
        log.debug("itemName : " + itemName );
        log.debug("qty : " + qty );

        HttpSession session = request.getSession(true);
        List<DonationRequest> donationInfoList;
        if (session.getAttribute("DonationRequestList") == null) {
            donationInfoList = new ArrayList<>();
        } else {
            donationInfoList = (List<DonationRequest>) session.getAttribute("DonationRequestList");
        }

        DonationRequest donationRequest = new DonationRequest();

        Address donationAddress= new Address();
        donationAddress.setAddress(address);
        donationRequest.setAddress(donationAddress);
        donationRequest.setRegisteredDate(dateRequired);
        donationRequest.setExpiredDate(dateExpire);
        donationRequest.setDonationItem(itemName);
        donationRequest.setDonationQty(qty);

        donationInfoList.add(donationRequest);

        session.setAttribute("DonationRequestList", donationInfoList);
    }

    private Date dateFromDateString(String dateStr) {
        String year = dateStr.substring(6);
        String day = dateStr.substring(3, 5);
        String month = dateStr.substring(0, 2);
        Date date =  new Date(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));

        log.debug("---- date : " + date + " --------");
        return date;
    }
}
