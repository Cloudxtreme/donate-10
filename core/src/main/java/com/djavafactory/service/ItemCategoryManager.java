package com.djavafactory.service;

import com.djavafactory.service.GenericManager;
import com.djavafactory.model.ItemCategory;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ItemCategoryManager extends GenericManager<ItemCategory, Long> {
    
}