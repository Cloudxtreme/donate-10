package com.djavafactory.webapp.controller;

import com.djavafactory.model.Contact;
import com.djavafactory.service.ContactManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/contactform*")
public class ContactFormController extends BaseFormController {
    private ContactManager contactManager = null;

    @Autowired
    public void setContactManager(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    public ContactFormController() {
        setCancelView("redirect:contacts");
        setSuccessView("redirect:contacts");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Contact showForm(HttpServletRequest request)
            throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return contactManager.get(new Long(id));
        }

        return new Contact();
    }


    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Contact contact, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
            throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(contact, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "contactform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (contact.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            contactManager.remove(contact.getId());
            saveMessage(request, getText("contact.deleted", locale));
        } else {
            contactManager.save(contact);
            String key = (isNew) ? "contact.added" : "contact.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:/contactform?id=" + contact.getId();
            }
        }

        return success;
    }


    @RequestMapping(value = "/front/{name}/{phone}/{email}/{message}", method = RequestMethod.GET)
    public String frontSubmit(HttpServletRequest request, @PathVariable("name") String name, @PathVariable("phone") String phone,@PathVariable("email") String email,@PathVariable("message") String message) throws Exception {

        System.out.println("success! "+ name+phone+email+message);

        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhoneNo(phone);
        contact.setEmail(email);
        contact.setMessage(message);

        contactManager.save(contact);

        return "redirect:/landing";
    }
}
