package com.djavafactory.dao.hibernate;

import com.djavafactory.model.Organization;
import com.djavafactory.dao.OrganizationDao;
import com.djavafactory.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("organizationDao")
public class OrganizationDaoHibernate extends GenericDaoHibernate<Organization, Long> implements OrganizationDao {

    public OrganizationDaoHibernate() {
        super(Organization.class);
    }
}
