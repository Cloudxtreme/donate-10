package com.djavafactory.service;

import com.djavafactory.dto.DonationInfoResponse;
import com.djavafactory.model.DonationRequest;

public interface DonationRequestManager extends GenericManager<DonationRequest, Long> {
	
	public DonationInfoResponse getAllDonationRequestJson();
	
	public DonationInfoResponse getAllDonationRequest();
    
}