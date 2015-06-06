package com.djavafactory.service.impl;

import com.djavafactory.dao.ItemCategoryDao;
import com.djavafactory.model.ItemCategory;
import com.djavafactory.service.ItemCategoryManager;
import com.djavafactory.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("itemCategoryManager")
@WebService(serviceName = "ItemCategoryService", endpointInterface = "com.djavafactory.service.ItemCategoryManager")
public class ItemCategoryManagerImpl extends GenericManagerImpl<ItemCategory, Long> implements ItemCategoryManager {
    ItemCategoryDao itemCategoryDao;

    @Autowired
    public ItemCategoryManagerImpl(ItemCategoryDao itemCategoryDao) {
        super(itemCategoryDao);
        this.itemCategoryDao = itemCategoryDao;
    }
}