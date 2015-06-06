package com.djavafactory.dao.hibernate;

import com.djavafactory.model.DonationRequest;
import com.djavafactory.dao.DonationRequestDao;
import com.djavafactory.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("donationRequestDao")
public class DonationRequestDaoHibernate extends GenericDaoHibernate<DonationRequest, Long> implements DonationRequestDao {

    public DonationRequestDaoHibernate() {
        super(DonationRequest.class);
    }
}
