package com.djavafactory.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.djavafactory.dao.ItemCategoryDao;
import com.djavafactory.model.ItemCategory;
import org.appfuse.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class ItemCategoryManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private ItemCategoryManagerImpl manager;

    @Mock
    private ItemCategoryDao dao;


    @Test
    public void testGetItemCategory() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final ItemCategory itemCategory = new ItemCategory();
        given(dao.get(id)).willReturn(itemCategory);

        //when
        ItemCategory result = manager.get(id);

        //then
        assertSame(itemCategory, result);
    }

    @Test
    public void testGetItemCategories() {
        log.debug("testing getAll...");
        //given
        final List itemCategories = new ArrayList();
        given(dao.getAll()).willReturn(itemCategories);

        //when
        List result = manager.getAll();

        //then
        assertSame(itemCategories, result);
    }

    @Test
    public void testSaveItemCategory() {
        log.debug("testing save...");

        //given
        final ItemCategory itemCategory = new ItemCategory();
        // enter all required fields
        


        given(dao.save(itemCategory)).willReturn(itemCategory);

        //when
        manager.save(itemCategory);

        //then
        verify(dao).save(itemCategory);
    }

    @Test
    public void testRemoveItemCategory() {
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