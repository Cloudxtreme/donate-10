package com.djavafactory.service.impl;

import com.djavafactory.dao.ContactDao;
import com.djavafactory.model.Contact;
import com.djavafactory.service.ContactManager;
import com.djavafactory.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("contactManager")
@WebService(serviceName = "ContactService", endpointInterface = "com.djavafactory.service.ContactManager")
public class ContactManagerImpl extends GenericManagerImpl<Contact, Long> implements ContactManager {
    ContactDao contactDao;

    @Autowired
    public ContactManagerImpl(ContactDao contactDao) {
        super(contactDao);
        this.contactDao = contactDao;
    }
}