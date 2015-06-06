package com.djavafactory.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.djavafactory.service.OrganizationManager;
import com.djavafactory.model.Organization;
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
@RequestMapping("/organizationform*")
public class OrganizationFormController extends BaseFormController {
    private OrganizationManager organizationManager = null;

    @Autowired
    public void setOrganizationManager(OrganizationManager organizationManager) {
        this.organizationManager = organizationManager;
    }

    public OrganizationFormController() {
        setCancelView("redirect:organizations");
        setSuccessView("redirect:organizations");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Organization showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return organizationManager.get(new Long(id));
        }

        return new Organization();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Organization organization, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(organization, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "organizationform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (organization.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            organizationManager.remove(organization.getId());
            saveMessage(request, getText("organization.deleted", locale));
        } else {
            organizationManager.save(organization);
            String key = (isNew) ? "organization.added" : "organization.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:organizationform?id=" + organization.getId();
            }
        }

        return success;
    }
}
