package com.djavafactory.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.djavafactory.dao.DonationItemDao;
import com.djavafactory.model.DonationItem;
import com.djavafactory.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class DonationItemManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private DonationItemManagerImpl manager;

    @Mock
    private DonationItemDao dao;


    @Test
    public void testGetDonationItem() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final DonationItem donationItem = new DonationItem();
        given(dao.get(id)).willReturn(donationItem);

        //when
        DonationItem result = manager.get(id);

        //then
        assertSame(donationItem, result);
    }

    @Test
    public void testGetDonationItems() {
        log.debug("testing getAll...");
        //given
        final List donationItems = new ArrayList();
        given(dao.getAll()).willReturn(donationItems);

        //when
        List result = manager.getAll();

        //then
        assertSame(donationItems, result);
    }

    @Test
    public void testSaveDonationItem() {
        log.debug("testing save...");

        //given
        final DonationItem donationItem = new DonationItem();
        // enter all required fields
        


        given(dao.save(donationItem)).willReturn(donationItem);

        //when
        manager.save(donationItem);

        //then
        verify(dao).save(donationItem);
    }

    @Test
    public void testRemoveDonationItem() {
        log.debug("testing remove...");

        //given
        final Long id = -11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}