package com.djavafactory.service;

import com.djavafactory.service.GenericManager;
import com.djavafactory.model.DonationItem;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface DonationItemManager extends GenericManager<DonationItem, Long> {

    /**
     * Show all items that are not expired yet
     * @return
     */
    public List<DonationItem> getActiveItems();
    
}