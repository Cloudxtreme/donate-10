package com.djavafactory.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.djavafactory.dao.DonationItemDao;
import com.djavafactory.model.DonationItem;

@Repository("donationItemDao")
public class DonationItemDaoHibernate extends GenericDaoHibernate<DonationItem, Long> implements DonationItemDao {

    public DonationItemDaoHibernate() {
        super(DonationItem.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<DonationItem> findByDonationRequest(Long requestId) {
		Criteria criteria = getSession().createCriteria(DonationItem.class);
//		criteria.createAlias("donationRequest", "donationRequest");
		criteria.add(Restrictions.eq("donationRequest.id", requestId));
		return criteria.list();
	}
}
