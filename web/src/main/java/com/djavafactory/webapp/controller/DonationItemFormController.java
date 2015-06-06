package com.djavafactory.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.djavafactory.service.DonationItemManager;
import com.djavafactory.model.DonationItem;
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
@RequestMapping("/donationItemform*")
public class DonationItemFormController extends BaseFormController {
    private DonationItemManager donationItemManager = null;

    @Autowired
    public void setDonationItemManager(DonationItemManager donationItemManager) {
        this.donationItemManager = donationItemManager;
    }

    public DonationItemFormController() {
        setCancelView("redirect:donationItems");
        setSuccessView("redirect:donationItems");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected DonationItem showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return donationItemManager.get(new Long(id));
        }

        return new DonationItem();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(DonationItem donationItem, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(donationItem, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "donationItemform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (donationItem.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            donationItemManager.remove(donationItem.getId());
            saveMessage(request, getText("donationItem.deleted", locale));
        } else {
            donationItemManager.save(donationItem);
            String key = (isNew) ? "donationItem.added" : "donationItem.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:donationItemform?id=" + donationItem.getId();
            }
        }

        return success;
    }
}
