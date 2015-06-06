package com.djavafactory.dao;

import java.util.List;

import com.djavafactory.model.DonationItem;

/**
 * An interface that provides a data management interface to the DonationItem table.
 */
public interface DonationItemDao extends GenericDao<DonationItem, Long> {

	public List<DonationItem> findByDonationRequest(Long requestId);
}