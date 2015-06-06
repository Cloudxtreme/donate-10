package com.djavafactory.dao;

import com.djavafactory.dao.GenericDao;

import com.djavafactory.model.Contact;


public interface ChartDao extends GenericDao<Chart, Long> {
	
	/**
	 * @return List of donations.
	 */
	
	public int findTotalDonation(Long requestId);
	
	/**
	 * @return List of recipients.
	 */
	
	public int findTotalRecipient(Long requestId);

	

}
