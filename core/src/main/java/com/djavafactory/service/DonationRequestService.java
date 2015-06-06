package com.djavafactory.service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.djavafactory.dto.DonationInfoResponse;

@WebService
@Path("/donation")
public interface DonationRequestService {
	
	@GET
	@Path("json")
    @Produces(MediaType.APPLICATION_JSON)
	public DonationInfoResponse getAllDonationRequestJson();
	
	@GET
    @Produces(MediaType.APPLICATION_XML)
	public DonationInfoResponse getAllDonationRequest();
    
}