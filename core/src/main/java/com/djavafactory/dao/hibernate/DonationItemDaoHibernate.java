package com.djavafactory.dao.hibernate;

import com.djavafactory.model.DonationItem;
import com.djavafactory.dao.DonationItemDao;
import com.djavafactory.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("donationItemDao")
public class DonationItemDaoHibernate extends GenericDaoHibernate<DonationItem, Long> implements DonationItemDao {

    public DonationItemDaoHibernate() {
        super(DonationItem.class);
    }
}
