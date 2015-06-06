package com.djavafactory.dao.hibernate;

import com.djavafactory.model.Contact;
import com.djavafactory.dao.ContactDao;
import com.djavafactory.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("contactDao")
public class ContactDaoHibernate extends GenericDaoHibernate<Contact, Long> implements ContactDao {

    public ContactDaoHibernate() {
        super(Contact.class);
    }
}
