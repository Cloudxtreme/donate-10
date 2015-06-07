package com.djavafactory.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djavafactory.dao.DonationItemDao;
import com.djavafactory.dao.DonationRequestDao;
import com.djavafactory.dto.DonationInfoResponse;
import com.djavafactory.model.DonationItem;
import com.djavafactory.model.DonationRequest;
import com.djavafactory.service.DonationRequestManager;
import com.djavafactory.service.DonationRequestService;

@Service("donationRequestManager")
@WebService(serviceName = "DonationRequestService", endpointInterface = "com.djavafactory.service.DonationRequestService")
public class DonationRequestManagerImpl extends GenericManagerImpl<DonationRequest, Long> implements DonationRequestManager, DonationRequestService {
    DonationRequestDao donationRequestDao;
    @Autowired
    DonationItemDao donationItemDao;

    @Autowired
    public DonationRequestManagerImpl(DonationRequestDao donationRequestDao) {
        super(donationRequestDao);
        this.donationRequestDao = donationRequestDao;
    }

	@Override
	public DonationInfoResponse getAllDonationRequestJson() {
		return getAllDonationRequest();
	}

	@Override
	public DonationInfoResponse getAllDonationRequest() {
		List<DonationRequest> requestList = donationRequestDao.getAll();
		for (DonationRequest req: requestList) {
			List<DonationItem> items = donationItemDao.findByDonationRequest(req.getId());
			req.setDonationItems(new HashSet(items));
		}
		DonationInfoResponse res = new DonationInfoResponse();
		res.setRequestList(requestList);
		return res;
	}
}