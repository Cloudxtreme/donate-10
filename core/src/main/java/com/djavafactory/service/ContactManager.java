package com.djavafactory.service;

import com.djavafactory.service.GenericManager;
import com.djavafactory.model.Contact;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ContactManager extends GenericManager<Contact, Long> {
    
}