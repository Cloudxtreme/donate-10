package com.djavafactory.dao;

import com.djavafactory.dao.BaseDaoTestCase;
import com.djavafactory.model.ItemCategory;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemCategoryDaoTest extends BaseDaoTestCase {
    @Autowired
    private ItemCategoryDao itemCategoryDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveItemCategory() {
        ItemCategory itemCategory = new ItemCategory();

        // enter all required fields

        log.debug("adding itemCategory...");
        itemCategory = itemCategoryDao.save(itemCategory);

        itemCategory = itemCategoryDao.get(itemCategory.getId());

        assertNotNull(itemCategory.getId());

        log.debug("removing itemCategory...");

        itemCategoryDao.remove(itemCategory.getId());

        // should throw DataAccessException 
        itemCategoryDao.get(itemCategory.getId());
    }
}