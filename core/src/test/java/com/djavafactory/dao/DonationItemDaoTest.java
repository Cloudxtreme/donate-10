package com.djavafactory.dao;

import com.djavafactory.model.DonationItem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.assertNotNull;

public class DonationItemDaoTest extends BaseDaoTestCase {
    @Autowired
    private DonationItemDao donationItemDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveDonationItem() {
        DonationItem donationItem = new DonationItem();

        // enter all required fields

        log.debug("adding donationItem...");
        donationItem = donationItemDao.save(donationItem);

        donationItem = donationItemDao.get(donationItem.getId());

        assertNotNull(donationItem.getId());

        log.debug("removing donationItem...");

        donationItemDao.remove(donationItem.getId());

        // should throw DataAccessException 
        donationItemDao.get(donationItem.getId());
    }
}