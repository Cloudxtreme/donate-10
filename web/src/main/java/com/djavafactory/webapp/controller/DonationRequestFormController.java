package com.djavafactory.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.djavafactory.service.DonationRequestManager;
import com.djavafactory.model.DonationRequest;
import com.djavafactory.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/donationRequestform*")
public class DonationRequestFormController extends BaseFormController {
    private DonationRequestManager donationRequestManager = null;

    @Autowired
    public void setDonationRequestManager(DonationRequestManager donationRequestManager) {
        this.donationRequestManager = donationRequestManager;
    }

    public DonationRequestFormController() {
        setCancelView("redirect:donationRequests");
        setSuccessView("redirect:donationRequests");
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
    public String onSubmit(DonationRequest donationRequest, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(donationRequest, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "donationRequestform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (donationRequest.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            donationRequestManager.remove(donationRequest.getId());
            saveMessage(request, getText("donationRequest.deleted", locale));
        } else {
            donationRequestManager.save(donationRequest);
            String key = (isNew) ? "donationRequest.added" : "donationRequest.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:donationRequestform?id=" + donationRequest.getId();
            }
        }

        return success;
    }
}
