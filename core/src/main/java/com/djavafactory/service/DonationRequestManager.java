package com.djavafactory.service;

import com.djavafactory.service.GenericManager;
import com.djavafactory.model.DonationRequest;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface DonationRequestManager extends GenericManager<DonationRequest, Long> {
    
}