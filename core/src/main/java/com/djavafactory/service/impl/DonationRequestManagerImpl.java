package com.djavafactory.service.impl;

import com.djavafactory.dao.DonationRequestDao;
import com.djavafactory.model.DonationRequest;
import com.djavafactory.service.DonationRequestManager;
import com.djavafactory.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("donationRequestManager")
@WebService(serviceName = "DonationRequestService", endpointInterface = "com.djavafactory.service.DonationRequestManager")
public class DonationRequestManagerImpl extends GenericManagerImpl<DonationRequest, Long> implements DonationRequestManager {
    DonationRequestDao donationRequestDao;

    @Autowired
    public DonationRequestManagerImpl(DonationRequestDao donationRequestDao) {
        super(donationRequestDao);
        this.donationRequestDao = donationRequestDao;
    }
}