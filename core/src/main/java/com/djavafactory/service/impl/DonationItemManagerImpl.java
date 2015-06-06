package com.djavafactory.service.impl;

import com.djavafactory.dao.DonationItemDao;
import com.djavafactory.model.DonationItem;
import com.djavafactory.service.DonationItemManager;
import com.djavafactory.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("donationItemManager")
@WebService(serviceName = "DonationItemService", endpointInterface = "com.djavafactory.service.DonationItemManager")
public class DonationItemManagerImpl extends GenericManagerImpl<DonationItem, Long> implements DonationItemManager {
    DonationItemDao donationItemDao;

    @Autowired
    public DonationItemManagerImpl(DonationItemDao donationItemDao) {
        super(donationItemDao);
        this.donationItemDao = donationItemDao;
    }
}